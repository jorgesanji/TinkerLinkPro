package com.cronosgroup.tinkerlink.presenter.usercontacts;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class AllUserContactsPresenter extends TinkerLinkPresenter<AllUserContactsPresenter.View> {

    private final Actions listener;

    /**
     * AllUserContacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * AllUserContacts actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public AllUserContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

}
