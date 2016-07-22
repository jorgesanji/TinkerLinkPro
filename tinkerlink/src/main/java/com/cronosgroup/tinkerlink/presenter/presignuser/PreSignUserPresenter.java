package com.cronosgroup.tinkerlink.presenter.presignuser;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class PreSignUserPresenter extends TinkerLinkPresenter<PreSignUserPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * PreSignUser listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * PreSignUser actions.
     */
    public interface Actions {
        void onLaunchLogin(Activity activity, Bundle bundle);

        void onLaunchSign(Activity activity, Bundle bundle);
    }


    /**
     * @param navigationListener
     */
    public PreSignUserPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //Actions

    public void onLoginPressed() {
        listener.onLaunchLogin(getView().getActivity(), null);
    }

    public void onSignPressed() {
        listener.onLaunchSign(getView().getActivity(), null);
    }
}


