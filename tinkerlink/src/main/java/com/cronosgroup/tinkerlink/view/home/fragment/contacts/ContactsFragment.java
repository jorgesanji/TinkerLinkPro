package com.cronosgroup.tinkerlink.view.home.fragment.contacts;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;


/**
 * Login Fragment
 */
public class ContactsFragment extends MVPFragment<ContactsPresenter, ContactsPresenter.View>
        implements ContactsPresenter.View, ContactsPresenter.Actions, ContactsScreen.Listener {

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

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
