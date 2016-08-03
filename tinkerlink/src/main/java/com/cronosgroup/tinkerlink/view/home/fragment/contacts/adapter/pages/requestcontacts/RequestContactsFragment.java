package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.requestcontacts;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.contacts.RequestContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class RequestContactsFragment extends MVPTinkerLinkFragment<RequestContactsPresenter, RequestContactsPresenter.View>
        implements RequestContactsPresenter.View, RequestContactsScreen.Listener {

    // Vars

    // Views
    private RequestContactsScreen contactsUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        contactsUserScreen = new RequestContactsScreen(getActivity());
        contactsUserScreen.setListener(this);
        return contactsUserScreen;
    }

    @Override
    protected RequestContactsPresenter createPresenter() {
        return new RequestContactsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected RequestContactsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region ************** RequestContactsPresenter.View **************

    //endregion

    //region ************** RequestContactsScreen.Listener **************

    //endregion

}
