package com.cronosgroup.tinkerlink.presenter.sign;

import android.graphics.Bitmap;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkImagePickerPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * Sign presenter.
 */
public class SignProfilePresenter extends TinkerLinkImagePickerPresenter<SignProfilePresenter.View> {


    private final Actions listener;

    /**
     * Sign profile listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Sign profile actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public SignProfilePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************
    //endregion

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

    @Override
    public View getView() {
        return view;
    }

}
