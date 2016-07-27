package com.cronosgroup.tinkerlink.presenter.usercontacts;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserContactsPresenter extends TinkerLinkPresenter<UserContactsPresenter.View> {

    private final Actions listener;

    /**
     * User Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * User Contacts actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public UserContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

}
