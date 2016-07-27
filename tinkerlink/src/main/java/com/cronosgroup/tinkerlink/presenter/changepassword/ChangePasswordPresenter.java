package com.cronosgroup.tinkerlink.presenter.changepassword;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChangePasswordPresenter extends TinkerLinkPresenter<ChangePasswordPresenter.View> {

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
        void onLaunchRecoveryPassword(Activity activity, Bundle bundle);
    }


    /**
     * @param navigationListener
     */
    public ChangePasswordPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

    public void onRecoveryPressed() {
        listener.onLaunchRecoveryPassword(getView().getActivity(), null);
    }

}


