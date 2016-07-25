package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.registerselector;


import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.event.NextPageEvent;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.sign.RegisterSelectorPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class RegisterSelectorFragment extends MVPTinkerLinkFragment<RegisterSelectorPresenter, RegisterSelectorPresenter.View>
        implements RegisterSelectorPresenter.View, RegisterSelectorScreen.Listener {

    //Vars
    private IOFormListener mCallback;

    //Views
    private RegisterSelectorScreen registerSelectorScreen;

    //region **************  Fragment **************
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (IOFormListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement IOFormListener");
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        registerSelectorScreen = new RegisterSelectorScreen(getActivity());
        registerSelectorScreen.setListener(this);
        return registerSelectorScreen;
    }

    @Override
    protected RegisterSelectorPresenter createPresenter() {
        return new RegisterSelectorPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected RegisterSelectorPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  RegisterSelectorPresenter.View **************

    @Override
    public void setAppUser(AppUser user) {
        if (user != null) {
            mCallback.getFormUser().setName(user.getName());
            mCallback.getFormUser().setEmail(user.getEmail());
            mCallback.getFormUser().setImageUrl(user.getImageUrl());
            mCallback.getFormUser().setBirthday(user.getBirthday());
            mCallback.getFormUser().setOriginalBitmageBase64(user.getOriginalBitmageBase64());
            mCallback.getFormUser().setGender(user.getGender());
            mCallback.getFormUser().setPhone(user.getPhone());
            mCallback.getFormUser().setIdUser(user.getIdUser());
            mCallback.getFormUser().setId(user.getId());
        }
        EventBus.getDefault().post(new NextPageEvent());
    }

    //endregion

    //region **************  RegisterSelectorScreen.Listener **************

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
