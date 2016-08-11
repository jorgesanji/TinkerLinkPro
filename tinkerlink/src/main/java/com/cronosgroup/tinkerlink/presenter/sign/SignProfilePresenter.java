package com.cronosgroup.tinkerlink.presenter.sign;

import android.graphics.Bitmap;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkImagePickerPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * Sign presenter.
 */
public class SignProfilePresenter extends TinkerLinkImagePickerPresenter<SignProfilePresenter.View> {

    /**
     * Sign profile listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //region **************  View Actions **************

    //endregion

    @Override
    public void imageSelected(Bitmap original, Bitmap cropped) {

    }

    @Override
    public void errorPickerImage() {

    }

    @Override
    public void cancelPickerImage() {

    }

}
