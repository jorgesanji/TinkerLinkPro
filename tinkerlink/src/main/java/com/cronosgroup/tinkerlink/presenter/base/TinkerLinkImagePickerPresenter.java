package com.cronosgroup.tinkerlink.presenter.base;

import android.content.Intent;
import android.graphics.Bitmap;

import com.cronosgroup.core.managers.ImagePickerManager;
import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.view.AppStatusMessageManager;

import java.util.List;


/**
 * Created by jorgesanmartin on 21/4/16.
 */
public abstract class TinkerLinkImagePickerPresenter extends TinkerLinkPresenter implements Presenter, ImagePickerManager.IOPickerImageSelector{

    protected ImagePickerManager mImagePickerManager;

    public abstract void imageSelected(Bitmap original, Bitmap cropped);

    public abstract void errorPickerImage();

    public abstract void cancelPickerImage();


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void attachView(View view) {
        super.attachView(view);
        this.mImagePickerManager = new ImagePickerManager();
        mImagePickerManager.setOwner(view.getFragment() != null ? view.getFragment() : view.getActivity());
        mImagePickerManager.setMultipleSelection(false);
        mImagePickerManager.setListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mImagePickerManager.onActivityResult(requestCode, resultCode, data);
    }

    public AppStatusMessageManager getStatusView() {
        return mStatusManager;
    }

    // Picker Image methods

    @Override
    public void onMultiImagesSelected(List<Bitmap> images) {

    }

    @Override
    public void onImageSelected(Bitmap original, Bitmap cropped) {
        if (original != null) {
            imageSelected(original, cropped);
        }
    }

    @Override
    public void onCancel() {
        cancelPickerImage();
    }

    @Override
    public void onError() {
        errorPickerImage();
    }

    public void launchGallery() {
        if (getPermissionManager().checkGalleryPermissions()) {
            mImagePickerManager.launchGallery();
        } else {
            getPermissionManager().requestGalleryPermission(new PermissionsManager.IOAppPermission() {
                @Override
                public void permission(PermissionsManager.Permission permission, boolean enable) {
                    if (permission.getCode() == PermissionsManager.Permission.GALLERY.getCode() && enable) {
                        mImagePickerManager.launchGallery();
                    }
                }
            });
        }
    }

    public void launchCamera() {
        if (getPermissionManager().checkCameraPermissions()) {
            mImagePickerManager.launchCamera();
        } else {
            getPermissionManager().requestCameraPermission(new PermissionsManager.IOAppPermission() {
                @Override
                public void permission(PermissionsManager.Permission permission, boolean enable) {
                    if (permission.getCode() == PermissionsManager.Permission.CAMERA.getCode() && enable) {
                        mImagePickerManager.launchCamera();
                    }
                }
            });
        }
    }

    public PermissionsManager getPermissionManager(){
        return ((BaseActivity)getView().getActivity()).getPermissionsManager();
    }

    public ImagePickerManager getImagePickerManager() {
        return mImagePickerManager;
    }
}
