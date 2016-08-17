package com.cronosgroup.tinkerlink.presenter.contacts;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ContactsPresenter extends TinkerLinkPresenter<ContactsPresenter.View> {

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    // public methods

    public void launchImportContacts() {
        navigation.onLaunchImportUserContacts(getView().getActivity(), null);
    }

}
