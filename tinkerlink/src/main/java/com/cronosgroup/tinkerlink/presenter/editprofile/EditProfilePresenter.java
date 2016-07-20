package com.cronosgroup.tinkerlink.presenter.editprofile;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class EditProfilePresenter extends TinkerLinkPresenter<EditProfilePresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
        void onNetWorkPressed(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public EditProfilePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

}

