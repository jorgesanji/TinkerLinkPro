package com.cronosgroup.tinkerlink.presenter.sign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * Sign presenter.
 */
public class SignPresenter extends TinkerLinkPresenter<SignPresenter.View> {


    private final Actions listener;

    /**
     * Sign listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Sign actions.
     */
    public interface Actions {
        void onUsePolicyPressed(Activity activity, Bundle bundle);

        void onSuccessValidation(Activity activity, Bundle bundle);

        void onGoToLogin(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public SignPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    //endregion

    //region **************  View Actions **************
    //endregion
}
