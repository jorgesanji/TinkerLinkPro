package com.cronosgroup.tinkerlink.view.usercontacts.adapter.pages;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.usercontacts.AllUserContactsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class AllUserContactsFragment extends MVPTinkerLinkFragment<AllUserContactsPresenter, AllUserContactsPresenter.View>
        implements AllUserContactsPresenter.View, AllUserContactsScreen.Listener {

    // Vars

    // Views
    private AllUserContactsScreen allUserContactsScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        allUserContactsScreen = new AllUserContactsScreen(getActivity());
        allUserContactsScreen.setListener(this);
        return allUserContactsScreen;
    }

    @Override
    protected AllUserContactsPresenter createPresenter() {
        return new AllUserContactsPresenter();
    }

    @Override
    protected AllUserContactsPresenter.View getPresenterView() {
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
