package com.cronosgroup.tinkerlink.presenter.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cronosgroup.tinkerlink.manager.socialnetworks.AppFacebookManager;
import com.cronosgroup.tinkerlink.manager.socialnetworks.AppGooglePlusManager;
import com.cronosgroup.tinkerlink.manager.socialnetworks.IOSocialNetwork;
import com.cronosgroup.tinkerlink.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class LoginPresenter extends TinkerLinkPresenter<LoginPresenter.View> {

    // Vars
    private IOSocialNetwork<AppUser> appGooglePlusManager;
    private IOSocialNetwork<AppUser> appFacebookManager;
    private final Actions listener;

    /**
     * Login listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        String getIdUser();

        String getPasswordUser();
    }

    /**
     * Login actions.
     */
    public interface Actions {
        void onLaunchHome(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public LoginPresenter(Actions navigationListener) {
        this.listener = navigationListener;
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

    // Private methods

    private void doLogin(IOSocialNetwork socialNetwork) {
        getView().showLoading();
        socialNetwork.LogIn(new IOSocialNetWorkCallBack<AppUser>() {
            @Override
            public void onResponse(AppUser response) {
                getView().hideLoading();
                listener.onLaunchHome(getView().getActivity(), null);
            }

            @Override
            public void onError(Object response) {
                getView().hideLoading();
                getView().getMessagesHandler().showNetworkError();
            }
        });
    }

    //Actions

    public void doLogin() {
        String userId = getView().getIdUser();
        String passwordUser = getView().getPasswordUser();
        getView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().hideLoading();
                    listener.onLaunchHome(getView().getActivity(), null);
                }
            }
        }, 2000);

    }

    public void doGoogleLogin() {
        doLogin(appGooglePlusManager);
    }

    public void doFacebookLogin() {
        doLogin(appFacebookManager);
    }
}

