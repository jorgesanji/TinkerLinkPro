package com.cronosgroup.tinkerlink.view.presignuser;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.presignuser.PreSignUserPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * PreSignUser Fragment
 */
public class PreSignUserFragment extends MVPTinkerLinkFragment<PreSignUserPresenter, PreSignUserPresenter.View>
        implements PreSignUserPresenter.View, PreSignUserScreen.Listener {

    // Vars

    // Views
    private PreSignUserScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new PreSignUserScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected PreSignUserPresenter createPresenter() {
        return new PreSignUserPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected PreSignUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** PreSignUserPresenter.View **************

    //endregion

    //region ************** PreSignUserScreen.Listener **************

    @Override
    public void onLoginPressed() {
        getPresenter().onLoginPressed();
    }

    @Override
    public void onSignPressed() {
        getPresenter().onSignPressed();
    }


    //endregion

}
