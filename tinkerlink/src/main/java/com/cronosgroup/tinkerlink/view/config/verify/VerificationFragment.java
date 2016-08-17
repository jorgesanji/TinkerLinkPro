package com.cronosgroup.tinkerlink.view.config.verify;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.verify.VerifyPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.country.CountryDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.validation.ValidationDialogFragment;


/**
 * Verification Fragment
 */
public class VerificationFragment extends MVPTinkerLinkFragment<VerifyPresenter, VerifyPresenter.View>
        implements VerifyPresenter.View, VerificationScreen.Listener {

    // Vars

    // Views

    private VerificationScreen recoveryPasswordScreen;

    @Override
    protected View getRootView() {
        recoveryPasswordScreen = new VerificationScreen(getActivity());
        recoveryPasswordScreen.setListener(this);
        return recoveryPasswordScreen;
    }

    @Override
    protected void onDidAppear() {

    }

    //region **************  MVPFragment **************

    @Override
    protected VerifyPresenter createPresenter() {
        return new VerifyPresenter();
    }

    @Override
    protected VerifyPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region ************** VerifyPresenter.View **************

    //endregion

    //region ************** VerifyScreen.Listener **************

    @Override
    public void onSendPressed() {
        addDialogFragment(ValidationDialogFragment.class, ValidationDialogFragment.CODE);
    }

    @Override
    public void onSelectorCountryPressed() {
        addDialogFragment(CountryDialogFragment.class, CountryDialogFragment.CODE);
    }

    //endregion

}
