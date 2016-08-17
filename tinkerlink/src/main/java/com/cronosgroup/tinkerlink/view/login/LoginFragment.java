package com.cronosgroup.tinkerlink.view.login;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.login.LoginPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * PreSignUser Fragment
 */
public class LoginFragment extends MVPTinkerLinkFragment<LoginPresenter, LoginPresenter.View>
        implements LoginPresenter.View, LoginScreen.Listener {

    // Vars

    // Views
    private LoginScreen loginScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        loginScreen = new LoginScreen(getActivity());
        loginScreen.setListener(this);
        return loginScreen;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected LoginPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** LoginPresenter.View **************

    @Override
    public String getIdUser() {
        return loginScreen.getIdUser();
    }

    @Override
    public String getPasswordUser() {
        return loginScreen.getPasswordUser();
    }

    //endregion

    //region ************** LoginScreen.Listener **************

    @Override
    public void onLoginPressed() {
        getPresenter().doLogin();
    }

    @Override
    public void onLoginGooglePressed() {
        getPresenter().doGoogleLogin();
    }

    @Override
    public void onLoginFacebookPressed() {
        getPresenter().doFacebookLogin();
    }

    //endregion

}
