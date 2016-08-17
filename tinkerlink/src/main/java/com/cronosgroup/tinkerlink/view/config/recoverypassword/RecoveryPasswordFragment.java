package com.cronosgroup.tinkerlink.view.config.recoverypassword;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.recoverypassword.RecoveryPasswordPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * RecoveryPassword Fragment
 */
public class RecoveryPasswordFragment extends MVPTinkerLinkFragment<RecoveryPasswordPresenter, RecoveryPasswordPresenter.View>
        implements RecoveryPasswordPresenter.View, RecoveryPasswordScreen.Listener {

    // Vars

    // Views
    private RecoveryPasswordScreen recoveryPasswordScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        recoveryPasswordScreen = new RecoveryPasswordScreen(getActivity());
        recoveryPasswordScreen.setListener(this);
        return recoveryPasswordScreen;
    }

    @Override
    protected RecoveryPasswordPresenter createPresenter() {
        return new RecoveryPasswordPresenter();
    }

    @Override
    protected RecoveryPasswordPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** RecoveryPasswordPresenter.View **************

    //endregion

    //region ************** RecoveryPasswordScreen.Listener **************

    //endregion

}
