package com.cronosgroup.tinkerlink.presenter.profile;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserInformationPresenter extends TinkerLinkPresenter<UserInformationPresenter.View> {

    // Vars

    /**
     * UserInformation listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //Actions

    public void onUserContactsPressed() {
        navigation.onLaunchUserContacts(getView().getActivity(), null);
    }

}


