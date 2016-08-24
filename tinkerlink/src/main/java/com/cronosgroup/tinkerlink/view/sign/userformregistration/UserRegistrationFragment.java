package com.cronosgroup.tinkerlink.view.sign.userformregistration;

import android.view.View;

import com.cronosgroup.tinkerlink.event.RegistrationStepsEvent;
import com.cronosgroup.tinkerlink.presenter.sign.UserRegistrationPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.validation.ValidationDialogFragment;
import com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.SignAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Sign Fragment
 */
public class UserRegistrationFragment extends MVPTinkerLinkFragment<UserRegistrationPresenter, UserRegistrationPresenter.View>
        implements UserRegistrationPresenter.View, UserRegistrationScreen.Listener {

    private UserRegistrationScreen signScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        this.signScreen = new UserRegistrationScreen(getActivity(), getFragmentManager());
        signScreen.setListener(this);
        return signScreen;
    }

    @Override
    protected void onDidAppear() {
        signScreen.initAdapter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected UserRegistrationPresenter createPresenter() {
        return new UserRegistrationPresenter();
    }

    @Override
    protected UserRegistrationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  SignPresenter.View **************
    //endregion

    //region **************  SignScreen.Listener **************

    @Override
    public void verifiedPage(int page) {
        if (page == SignAdapter.TINKER || page == SignAdapter.LINKER) {
            signScreen.showNextPage();
        } else if (page == SignAdapter.USERFORM) {
            addDialogFragment(ValidationDialogFragment.class, ValidationDialogFragment.CODE);
        } else {
            getPresenter().goToHome();
        }
    }

    @Override
    public boolean onBackPressed() {
        return signScreen.showPreviousPage();
    }

    //endregion

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(RegistrationStepsEvent event) {
        signScreen.showNextPage();
    }

    //endregion

}
