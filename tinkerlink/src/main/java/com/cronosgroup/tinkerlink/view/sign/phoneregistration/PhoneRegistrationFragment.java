package com.cronosgroup.tinkerlink.view.sign.phoneregistration;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.sign.PhoneRegistrationPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Verify registration Fragment
 */
public class PhoneRegistrationFragment extends MVPTinkerLinkFragment<PhoneRegistrationPresenter, PhoneRegistrationPresenter.View>
        implements PhoneRegistrationPresenter.View, PhoneRegistrationScreen.Listener {

    private PhoneRegistrationScreen signScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        this.signScreen = new PhoneRegistrationScreen(getActivity());
        signScreen.setListener(this);
        return signScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().initSmsBroadCastReceiver();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected PhoneRegistrationPresenter createPresenter() {
        return new PhoneRegistrationPresenter();
    }

    @Override
    protected PhoneRegistrationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  PhoneRegistrationPresenter.View **************

    @Override
    public String getValidationCode() {
        return signScreen.getCode();
    }

    @Override
    public String getPhoneNumber() {
        return signScreen.getPhoneNumber();
    }

    @Override
    public void onVerifyPressed() {
        getPresenter().checkCode();
    }

    @Override
    public void setValidCode(boolean validCode) {
        signScreen.setValidCode(validCode);
    }

    @Override
    public String getPassword() {
        return signScreen.getPassword();
    }

    //endregion

    //region **************  PhoneRegistrationScreen.Listener **************

    @Override
    public void onSendCodePressed() {
        getPresenter().sendPhoneNumber();
    }

    @Override
    public void setCode(String code) {
        signScreen.setCode(code);
    }

    @Override
    public void onCreateAccountPressed() {
        getPresenter().createAccount();
    }

    //endregion
}
