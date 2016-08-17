package com.cronosgroup.tinkerlink.presenter.changephonenumber;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChangePhoneNumberPresenter extends TinkerLinkPresenter<ChangePhoneNumberPresenter.View> {

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //Actions

    public void onVerifyPressed() {
        navigation.onLaunchUserVerification(getView().getActivity(), null);
    }
}


