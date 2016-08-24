package com.cronosgroup.tinkerlink.presenter.sign;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * User Registration presenter.
 */
public class UserRegistrationPresenter extends TinkerLinkPresenter<UserRegistrationPresenter.View> {

    /**
     * User Registration listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //region **************  View Actions **************

    public void goToHome() {
        navigation.onLaunchHome(getView().getActivity(), null);
    }

    //endregion
}
