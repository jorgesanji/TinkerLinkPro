package com.cronosgroup.tinkerlink.presenter.sign;

import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.model.manager.socialnetworks.AppFacebookManager;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.AppGooglePlusManager;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.IOSocialNetwork;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.sign.phoneregistration.PhoneRegistrationActivity;

/**
 * Register selector presenter.
 */
public class SocialNetworkRegistrationPresenter extends TinkerLinkPresenter<SocialNetworkRegistrationPresenter.View> {

    // Vars
    private IOSocialNetwork<AppUser> appGooglePlusManager;
    private IOSocialNetwork<AppUser> appFacebookManager;

    /**
     * FormUser view.
     */
    public interface View extends TinkerLinkPresenterView {
        void setAppUser(AppUser user);
    }

    @Override
    public void attachView(View view) {
        super.attachView(view);
        appGooglePlusManager = new AppGooglePlusManager(getView().getActivity());
        appFacebookManager = new AppFacebookManager(getView().getActivity());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        appGooglePlusManager.onActivityResult(requestCode, resultCode, data);
        appFacebookManager.onActivityResult(requestCode, resultCode, data);
    }

    //endregion

    private void doLogin(IOSocialNetwork socialNetwork) {
        getView().showLoading();
        socialNetwork.LogIn(new IOSocialNetWorkCallBack<AppUser>() {
            @Override
            public void onResponse(AppUser response) {
                getView().hideLoading();
                getView().setAppUser(response);
            }

            @Override
            public void onError(Object response) {
                getView().hideLoading();
                getView().setAppUser(null);
//                getView().getSnackMessageManager().showNetworkError();
            }
        });
    }

    //region **************  View Actions **************

    public void doLogin() {
        getView().setAppUser(null);
    }

    public void doLoginGoogle() {
        doLogin(appGooglePlusManager);
    }

    public void doLoginFacebook() {
        doLogin(appFacebookManager);
    }

    public void launchPhoneRegistration(AppUser user) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PhoneRegistrationActivity.KEY_USER, user);
        navigation.onLaunchPhoneRegistration(getView().getActivity(), null);
    }

    public void launchUseTerms() {
        navigation.onLaunchUseTerms(getView().getActivity(), null);
    }

    //endregion
}