package com.cronosgroup.tinkerlink.view.config.policyprivacy;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.importcontacts.ImportContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.policyprivacy.PolicyPrivacyPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class PolicyPrivacyFragment extends MVPTinkerLinkFragment<PolicyPrivacyPresenter, PolicyPrivacyPresenter.View>
        implements PolicyPrivacyPresenter.View, PolicyPrivacyScreen.Listener {

    // Vars

    // Views
    private PolicyPrivacyScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new PolicyPrivacyScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected PolicyPrivacyPresenter createPresenter() {
        return new PolicyPrivacyPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected PolicyPrivacyPresenter.View getPresenterView() {
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
