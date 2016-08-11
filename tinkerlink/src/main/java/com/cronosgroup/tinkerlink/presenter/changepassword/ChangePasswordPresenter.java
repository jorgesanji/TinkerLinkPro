package com.cronosgroup.tinkerlink.presenter.changepassword;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChangePasswordPresenter extends TinkerLinkPresenter<ChangePasswordPresenter.View> {


    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //Actions

    public void onRecoveryPressed() {
        navigation.onLaunchRecoveryUserPassword(getView().getActivity(), null);
    }

}


