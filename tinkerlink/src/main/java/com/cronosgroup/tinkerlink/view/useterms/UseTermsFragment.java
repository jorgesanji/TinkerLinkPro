package com.cronosgroup.tinkerlink.view.useterms;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.policyprivacy.PolicyPrivacyPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class UseTermsFragment extends MVPTinkerLinkFragment<PolicyPrivacyPresenter, PolicyPrivacyPresenter.View>
        implements PolicyPrivacyPresenter.View, UseTermsScreen.Listener {

    // Vars

    // Views
    private UseTermsScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new UseTermsScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected PolicyPrivacyPresenter createPresenter() {
        return new PolicyPrivacyPresenter();
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
