package com.cronosgroup.tinkerlink.presenter.sign;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * Sign presenter.
 */
public class SignPresenter extends TinkerLinkPresenter<SignPresenter.View> {


    /**
     * Sign listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //region **************  BasePresenter **************
    //endregion

    //region **************  View Actions **************

    public void goToHome() {
        navigation.onLaunchHome(getView().getActivity(), null);
    }
    //endregion
}
