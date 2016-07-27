package com.cronosgroup.tinkerlink.presenter.changephonenumber;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChangePhoneNumberPresenter extends TinkerLinkPresenter<ChangePhoneNumberPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Config user account actions.
     */
    public interface Actions {
        void onLaunchVerify(Activity activity, Bundle bundle);
    }


    /**
     * @param navigationListener
     */
    public ChangePhoneNumberPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

    public void onVerifyPressed() {
        listener.onLaunchVerify(getView().getActivity(), null);
    }
}


