package com.cronosgroup.tinkerlink.view.config.helptinkerlink;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.helptinkerlink.HelpTinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.policyprivacy.PolicyPrivacyPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class HelpTinkerLinkFragment extends MVPTinkerLinkFragment<HelpTinkerLinkPresenter, HelpTinkerLinkPresenter.View>
        implements HelpTinkerLinkPresenter.View, HelpTinkerLinkScreen.Listener {

    // Vars

    // Views
    private HelpTinkerLinkScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new HelpTinkerLinkScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected HelpTinkerLinkPresenter createPresenter() {
        return new HelpTinkerLinkPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected HelpTinkerLinkPresenter.View getPresenterView() {
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
