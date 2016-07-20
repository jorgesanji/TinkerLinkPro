package com.cronosgroup.tinkerlink.presenter.sign;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.manager.AppFacebookManager;
import com.cronosgroup.tinkerlink.manager.AppImagePickerManager;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Facebook sign presenter.
 */
public class FacebookPresenter extends TinkerLinkPresenter<FacebookPresenter.View> implements AppImagePickerManager.IOPickerImageSelector {

    private final Actions listener;
    private final AppImagePickerManager mImagePickerManager;
    private AppFacebookManager mFacebookManager;

    /**
     * Facebook view.
     */
    public interface View extends TinkerLinkPresenterView {
        void onAddImage(Bitmap bitmap, Bitmap bitmapcrop);

        void onFacebookUser(AppUser user);

        AppUser getFormUser();
    }

    /**
     * Facebook actions.
     */
    public interface Actions {
        void onUsePolicyPressed(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public FacebookPresenter(Actions navigationListener) {
        this.listener = navigationListener;
        this.mImagePickerManager = new AppImagePickerManager();
        mImagePickerManager.setCropImage(true);
    }

    //region **************  BasePresenter **************

    @Override
    public void attachView(View view) {
        super.attachView(view);
        mFacebookManager = new AppFacebookManager(view.getActivity());
        mImagePickerManager.setOwner(getView().getFragment());
        mImagePickerManager.setListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFacebookManager.onActivityResult(requestCode, resultCode, data);
        mImagePickerManager.onActivityResult(requestCode, resultCode, data);
    }

    //endregion

    //region **************  View Actions **************

    public void onFacebookPressed() {
        getView().showLoading();
        mFacebookManager.doLogin(getView().getFragment(), new AppFacebookManager.IOFacebookCallBack<AppUser>() {
            @Override
            public void onResponse(final AppUser user) {

                AsyncLoader asyncLoader = new AsyncLoader<Bitmap>() {
                    @Override
                    public Bitmap doInBackground() {
                        return ImageLoader.getInstance().loadImageSync(user.getImageUrl());
                    }

                    @Override
                    public void postProcess(Bitmap result) {
                        user.setOriginalBitmageBase64(BitmapUtils.getBase64StringfromBitmap(result));
                        getView().onFacebookUser(user);
                        getView().hideLoading();
                    }
                };

                asyncLoader.start();

            }

            @Override
            public void onError(Object response) {
                getView().getMessagesHandler().showNetworkError();
                getView().hideLoading();
            }
        }, AppUser.class);
    }

    public void onUsePolicyPressed() {
        listener.onUsePolicyPressed(getView().getActivity(), null);
    }

    public void onGalleryPressed() {
        mImagePickerManager.launchGallery();
    }

    public void onCameraPressed() {
        mImagePickerManager.launchCamera();
    }

    public boolean onValidateForm() {
        AppUser appUser = getView().getFormUser();
        if (!(appUser.getName() != null && !appUser.getName().isEmpty())) {
            getView().getMessagesHandler().showNameError();
            return false;
        }

        if (!(appUser.getGender() != null && !appUser.getGender().isEmpty())) {
            getView().getMessagesHandler().showSexError();
            return false;
        }

        if (!(appUser.getBirthday() != null && !appUser.getBirthday().isEmpty()) && appUser.getBirthday().equalsIgnoreCase("DD/MM/YYYY")) {
            getView().getMessagesHandler().showBirthDateError();
            return false;
        }
        if (!(appUser.getEmail() != null && !appUser.getEmail().isEmpty())) {
            getView().getMessagesHandler().showEmailError();
            return false;
        }

        return true;
    }

    //endregion

    //region **************  SelectorImage Listener **************

    @Override
    public void onMultiImagesSelected(List<Bitmap> images) {

    }

    @Override
    public void onImageSelected(Bitmap original, Bitmap cropped) {
        getView().onAddImage(cropped, cropped);
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError() {

    }

    //endregion

}
