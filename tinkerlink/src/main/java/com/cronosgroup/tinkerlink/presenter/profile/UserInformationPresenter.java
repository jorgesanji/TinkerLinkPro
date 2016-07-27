package com.cronosgroup.tinkerlink.presenter.profile;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserInformationPresenter extends TinkerLinkPresenter<UserInformationPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * UserInformation listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * UserInformation actions.
     */
    public interface Actions {
        void onLaunchUserContacts(Activity activity, Bundle bundle);
    }


    /**
     * @param navigationListener
     */
    public UserInformationPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

    public void onUserContactsPressed() {
        listener.onLaunchUserContacts(getView().getActivity(), null);
    }

}


