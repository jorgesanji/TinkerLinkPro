package com.cronosgroup.tinkerlink.view.config.changepassword;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.changepassword.ChangePasswordPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePassword Fragment
 */
public class ChangePasswordFragment extends MVPTinkerLinkFragment<ChangePasswordPresenter, ChangePasswordPresenter.View>
        implements ChangePasswordPresenter.View, ChangePasswordScreen.Listener {

    // Vars

    // Views
    private ChangePasswordScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new ChangePasswordScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected ChangePasswordPresenter createPresenter() {
        return new ChangePasswordPresenter();
    }

    @Override
    protected ChangePasswordPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ChangePasswordPresenter.View **************

    //endregion

    //region ************** ChangePasswordScreen.Listener **************

    @Override
    public void onRecoveryPressed() {
        getPresenter().onRecoveryPressed();
    }

    //endregion

}
