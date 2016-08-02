package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.contacts.ContactsUserPresenter;
import com.cronosgroup.tinkerlink.presenter.usercontacts.AllUserContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class ContactsUserFragment extends MVPTinkerLinkFragment<ContactsUserPresenter, ContactsUserPresenter.View>
        implements ContactsUserPresenter.View, ContactsUserScreen.Listener {

    // Vars

    // Views
    private ContactsUserScreen contactsUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        contactsUserScreen = new ContactsUserScreen(getActivity());
        contactsUserScreen.setListener(this);
        return contactsUserScreen;
    }

    @Override
    protected ContactsUserPresenter createPresenter() {
        return new ContactsUserPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ContactsUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region ************** AllUserContactsPresenter.View **************

    //endregion

    //region ************** AllUserContactsScreen.Listener **************

    //endregion

}
