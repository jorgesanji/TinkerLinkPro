package com.cronosgroup.tinkerlink.presenter.searchcontacts;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class SearchContactsPresenter extends TinkerLinkPresenter<SearchContactsPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * SearchContacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * SearchContacts actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public SearchContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


