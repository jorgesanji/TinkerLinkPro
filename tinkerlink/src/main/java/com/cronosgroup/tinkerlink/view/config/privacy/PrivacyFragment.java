package com.cronosgroup.tinkerlink.view.config.privacy;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.privacy.PrivacyPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class PrivacyFragment extends MVPTinkerLinkFragment<PrivacyPresenter, PrivacyPresenter.View>
        implements PrivacyPresenter.View, PrivacyScreen.Listener {

    // Vars

    // Views
    private PrivacyScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new PrivacyScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected PrivacyPresenter createPresenter() {
        return new PrivacyPresenter();
    }

    @Override
    protected PrivacyPresenter.View getPresenterView() {
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
