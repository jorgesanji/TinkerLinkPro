package com.cronosgroup.tinkerlink.view.sign.fragments.facebook;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.event.FormRegistrationEvent;
import com.cronosgroup.tinkerlink.event.FormValidationEvent;
import com.cronosgroup.tinkerlink.event.NextPageEvent;
import com.cronosgroup.tinkerlink.event.enums.FormState;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.sign.FacebookPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.view.interfaces.IOValidationForm;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class FacebookFragment extends MVPTinkerLinkFragment<FacebookPresenter, FacebookPresenter.View>
        implements FacebookPresenter.View, FacebookScreen.Listener, IOValidationForm {

    //Vars
    private IOFormListener mCallback;
    private AppUser appUser;

    //Views
    private FacebookScreen facebookPage;

    //region **************  Fragment **************

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (IOFormListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appUser = mCallback.getFormUser();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        facebookPage = new FacebookScreen(getActivity());
        facebookPage.setListener(this);
        return facebookPage;
    }

    @Override
    protected FacebookPresenter createPresenter() {
        return new FacebookPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected FacebookPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }

    //endregion

    //region **************  NewUserProfilePresenter.View **************


    @Override
    public AppUser getFormUser() {
        return appUser;
    }

    @Override
    public void onAddImage(Bitmap bitmap, Bitmap cropped) {
        if (cropped != null) {
            appUser.setCropBitmageBase64(BitmapUtils.getBase64StringfromBitmap(cropped));
        }

        if (bitmap != null) {
            appUser.setOriginalBitmageBase64(BitmapUtils.getBase64StringfromBitmap(bitmap));
        }

        facebookPage.changeProfileImage(cropped);
    }

    @Override
    public void onFacebookUser(AppUser user) {
        appUser = user;
        facebookPage.fillUserForm(user);
    }

    //endregion

    //region **************  UserProfileScreen.Listener **************

    @Override
    public void onUsePolicyPressed() {
        getPresenter().onUsePolicyPressed();
    }

    @Override
    public void onFacebookPressed() {
        getPresenter().onFacebookPressed();
    }

    @Override
    public void onGalleryPressed() {
        getPresenter().onGalleryPressed();
    }

    @Override
    public void onCameraPressed() {
        getPresenter().onCameraPressed();
    }

    @Override
    public void onMalePressed() {
        appUser.setGender(AppUser.MALE);
    }

    @Override
    public void onWomenPressed() {
        appUser.setGender(AppUser.FEMALE);
    }

    //endregion

    @Override
    public boolean validationForm() {
        return getPresenter().onValidateForm();
    }

    //region **************  EventBus **************
    @Subscribe
    public void onEventMainThread(FormRegistrationEvent event) {
        if (event.getState() == FormState.FACEBOOK) {

            appUser.setEmail(facebookPage.getEmail());
            appUser.setName(facebookPage.getName());
            appUser.setBirthday(facebookPage.getBirthDate());
            appUser.setGender(facebookPage.getGender());
            mCallback.setFormUser(appUser);

            if (validationForm()) {
                EventBus.getDefault().post(new FormValidationEvent(FormState.FACEBOOK, true));
            }
        }
    }

    @Subscribe
    public void onEventMainThread(NextPageEvent event) {
        if (event.getState() == FormState.FACEBOOK) {
            appUser = mCallback.getFormUser();
        }
    }

    //endregion
}
