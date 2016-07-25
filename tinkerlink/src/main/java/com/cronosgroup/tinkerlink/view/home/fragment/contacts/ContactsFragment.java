package com.cronosgroup.tinkerlink.view.home.fragment.contacts;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Contacts Fragment
 */
public class ContactsFragment extends MVPTinkerLinkFragment<ContactsPresenter, ContactsPresenter.View>
        implements ContactsPresenter.View, ContactsScreen.Listener {

    private ContactsScreen contactsScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        contactsScreen = new ContactsScreen(getActivity());
        contactsScreen.setListener(this);
        return contactsScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected ContactsPresenter createPresenter() {
        return new ContactsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ContactsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //region **************  ContactsScreen.Listener **************

    //endregion

    //region **************  ContactsPresenter.View **************

    //endregion
}
