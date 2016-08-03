package com.cronosgroup.tinkerlink.presenter.contacts;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class RequestContactsPresenter extends TinkerLinkPresenter<RequestContactsPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public RequestContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

}
