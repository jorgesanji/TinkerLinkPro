package com.cronosgroup.tinkerlink.view.config.verifyphone;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.verifyphone.VerifyPhonePresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.country.CountryDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.validation.ValidationDialogFragment;


/**
 * Verification Fragment
 */
public class VerifyPhoneFragment extends MVPTinkerLinkFragment<VerifyPhonePresenter, VerifyPhonePresenter.View>
        implements VerifyPhonePresenter.View, VerifyPhoneScreen.Listener {

    // Vars

    // Views

    private VerifyPhoneScreen recoveryPasswordScreen;

    @Override
    protected View getRootView() {
        recoveryPasswordScreen = new VerifyPhoneScreen(getActivity());
        recoveryPasswordScreen.setListener(this);
        return recoveryPasswordScreen;
    }

    @Override
    protected void onDidAppear() {

    }

    //region **************  MVPFragment **************

    @Override
    protected VerifyPhonePresenter createPresenter() {
        return new VerifyPhonePresenter();
    }

    @Override
    protected VerifyPhonePresenter.View getPresenterView() {
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
