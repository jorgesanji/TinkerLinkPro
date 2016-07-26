package com.cronosgroup.tinkerlink.view.config.changephonenumber;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.changephonenumber.ChangePhoneNumberPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class ChangePhoneNumberFragment extends MVPTinkerLinkFragment<ChangePhoneNumberPresenter, ChangePhoneNumberPresenter.View>
        implements ChangePhoneNumberPresenter.View, ChangePhoneNumberScreen.Listener {

    // Vars

    // Views
    private ChangePhoneNumberScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new ChangePhoneNumberScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected ChangePhoneNumberPresenter createPresenter() {
        return new ChangePhoneNumberPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ChangePhoneNumberPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ChangePhoneNumberPresenter.View **************

    //endregion

    //region ************** ChangePhoneNumberScreen.Listener **************

    @Override
    public void onVerifyPressed() {
        getPresenter().onVerifyPressed();
    }

    //endregion

}
