package com.cronosgroup.tinkerlink.view.config.verify;

import android.view.View;

import com.cronosgroup.tinkerlink.event.RegistrationStepsEvent;
import com.cronosgroup.tinkerlink.presenter.verify.VerifyPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Verification Fragment
 */
public class VerificationFragment extends MVPTinkerLinkFragment<VerifyPresenter, VerifyPresenter.View>
        implements VerifyPresenter.View, VerificationScreen.Listener {

    // Vars

    // Views
    private VerificationScreen recoveryPasswordScreen;

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


    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        recoveryPasswordScreen = new VerificationScreen(getActivity());
        recoveryPasswordScreen.setListener(this);
        return recoveryPasswordScreen;
    }

    @Override
    protected VerifyPresenter createPresenter() {
        return new VerifyPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected VerifyPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** VerifyPresenter.View **************

    //endregion

    //region ************** VerifyScreen.Listener **************

    //endregion

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(RegistrationStepsEvent event) {
        recoveryPasswordScreen.closeValidator();
        getActivity().finish();
    }

    //endregion

}
