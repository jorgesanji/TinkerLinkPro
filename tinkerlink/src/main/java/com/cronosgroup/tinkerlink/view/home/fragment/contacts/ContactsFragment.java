package com.cronosgroup.tinkerlink.view.home.fragment.contacts;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;


/**
 * Login Fragment
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

    @Override
    public void onLaunch() {
        getPresenter().onLaunchNetWork();
    }


    //endregion

    //region **************  ContactsPresenter.View **************

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
