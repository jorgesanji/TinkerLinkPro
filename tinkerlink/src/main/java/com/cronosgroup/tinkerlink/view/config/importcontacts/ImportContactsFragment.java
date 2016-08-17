package com.cronosgroup.tinkerlink.view.config.importcontacts;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.importcontacts.ImportContactsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class ImportContactsFragment extends MVPTinkerLinkFragment<ImportContactsPresenter, ImportContactsPresenter.View>
        implements ImportContactsPresenter.View, ImportContactsScreen.Listener {

    // Vars

    // Views
    private ImportContactsScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new ImportContactsScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected ImportContactsPresenter createPresenter() {
        return new ImportContactsPresenter();
    }

    @Override
    protected ImportContactsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ChangePhoneNumberPresenter.View **************

    //endregion

    //region ************** ChangePhoneNumberScreen.Listener **************

    //endregion

}
