package com.cronosgroup.tinkerlink.view.sign.socialnetworkregistration;


import android.view.View;

import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.sign.SocialNetworkRegistrationPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class SocialNetWorkRegistrationFragment extends MVPTinkerLinkFragment<SocialNetworkRegistrationPresenter, SocialNetworkRegistrationPresenter.View>
        implements SocialNetworkRegistrationPresenter.View, SocialNetWorkRegistrationScreen.Listener {

    //Views
    private SocialNetWorkRegistrationScreen registerSelectorScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        registerSelectorScreen = new SocialNetWorkRegistrationScreen(getActivity());
        registerSelectorScreen.setListener(this);
        return registerSelectorScreen;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected SocialNetworkRegistrationPresenter createPresenter() {
        return new SocialNetworkRegistrationPresenter();
    }

    @Override
    protected SocialNetworkRegistrationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  SocialNetworkRegistrationPresenter.View **************

    @Override
    public void setAppUser(AppUser user) {
        getPresenter().launchPhoneRegistration(user);
    }

    //endregion

    //region **************  SocialNetworkRegistrationScreen.Listener **************

    @Override
    public void onUseTermsPressed() {
        getPresenter().launchUseTerms();
    }

    @Override
    public void onLoginPressed() {
        getPresenter().doLogin();
    }

    @Override
    public void onLoginGooglePressed() {
        getPresenter().doLoginGoogle();
    }

    @Override
    public void onLoginFacebookPressed() {
        getPresenter().doLoginFacebook();
    }

    //endregion

}
