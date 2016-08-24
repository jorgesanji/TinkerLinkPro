package com.cronosgroup.tinkerlink.view.sign.createaccountregistration;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.sign.VerifyRegistrationPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Verify registration Fragment
 */
public class CreateAccountRegistrationFragment extends MVPTinkerLinkFragment<VerifyRegistrationPresenter, VerifyRegistrationPresenter.View>
        implements VerifyRegistrationPresenter.View, CreateAccountRegistrationScreen.Listener {

    private CreateAccountRegistrationScreen signScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        this.signScreen = new CreateAccountRegistrationScreen(getActivity());
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
    protected VerifyRegistrationPresenter createPresenter() {
        return new VerifyRegistrationPresenter();
    }

    @Override
    protected VerifyRegistrationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  VerifyRegistrationPresenter.View **************

    @Override
    public String getValidationCode() {
        return null;
    }

    @Override
    public void validateUser(RestUser restUser) {

    }

    //endregion

    //region **************  VerifyRegistrationScreen.Listener **************

    //endregion

    //region **************  EventBus **************

    //endregion
}
