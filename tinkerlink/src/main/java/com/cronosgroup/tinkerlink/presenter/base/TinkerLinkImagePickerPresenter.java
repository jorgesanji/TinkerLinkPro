package com.cronosgroup.tinkerlink.presenter.base;

import android.content.Intent;
import android.graphics.Bitmap;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.model.manager.AppImagePickerManager;

import java.util.List;


/**
 * Created by jorgesanmartin on 21/4/16.
 */
public abstract class TinkerLinkImagePickerPresenter<V extends Presenter.View>  extends PresenterDependencies implements Presenter<V>, AppImagePickerManager.IOPickerImageSelector {

    protected V view;

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
    public void attachView(V view) {
        this.view = view;
        appImagePickerManager.setOwner(view.getFragment() != null ? view.getFragment() : view.getActivity());
        appImagePickerManager.setMultipleSelection(false);
        appImagePickerManager.setListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        appImagePickerManager.onActivityResult(requestCode, resultCode, data);
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
            appImagePickerManager.launchGallery();
        } else {
            getPermissionManager().requestGalleryPermission(new PermissionsManager.IOAppPermission() {
                @Override
                public void permission(PermissionsManager.Permission permission, boolean enable) {
                    if (permission.getCode() == PermissionsManager.Permission.GALLERY.getCode() && enable) {
                        appImagePickerManager.launchGallery();
                    }
                }
            });
        }
    }

    public void launchCamera() {
        if (getPermissionManager().checkCameraPermissions()) {
            appImagePickerManager.launchCamera();
        } else {
            getPermissionManager().requestCameraPermission(new PermissionsManager.IOAppPermission() {
                @Override
                public void permission(PermissionsManager.Permission permission, boolean enable) {
                    if (permission.getCode() == PermissionsManager.Permission.CAMERA.getCode() && enable) {
                        appImagePickerManager.launchCamera();
                    }
                }
            });
        }
    }

    public PermissionsManager getPermissionManager() {
        return ((BaseActivity) getView().getActivity()).getPermissionsManager();
    }

    @Override
    public V getView() {
        return view;
    }
}
