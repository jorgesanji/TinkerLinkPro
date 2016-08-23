package com.cronosgroup.tinkerlink.view.verifyemail;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.verifyemail.VerifyEmailPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Verification Fragment
 */
public class VerifyEmailFragment extends MVPTinkerLinkFragment<VerifyEmailPresenter, VerifyEmailPresenter.View>
        implements VerifyEmailPresenter.View, VerifyEmailScreen.Listener {

    // Vars

    // Views

    private VerifyEmailScreen verifyEmailScreen;

    @Override
    protected View getRootView() {
        verifyEmailScreen = new VerifyEmailScreen(getActivity());
        verifyEmailScreen.setListener(this);
        return verifyEmailScreen;
    }

    @Override
    protected void onDidAppear() {

    }

    //region **************  MVPFragment **************

    @Override
    protected VerifyEmailPresenter createPresenter() {
        return new VerifyEmailPresenter();
    }

    @Override
    protected VerifyEmailPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region ************** VerifyEmailPresenter.View **************

    //endregion

    //region ************** VerifyEmailScreen.Listener **************


    //endregion

}
