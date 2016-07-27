package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userinformation;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.profile.UserInformationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * User Information Fragment
 */
public class UserInformationFragment extends MVPTinkerLinkFragment<UserInformationPresenter, UserInformationPresenter.View>
        implements UserInformationPresenter.View, UserInformationScreen.Listener {

    // Vars

    // Views
    private UserInformationScreen userInformationScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        userInformationScreen = new UserInformationScreen(getActivity());
        userInformationScreen.setListener(this);
        return userInformationScreen;
    }

    @Override
    protected UserInformationPresenter createPresenter() {
        return new UserInformationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected UserInformationPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** UserInformationPresenter.View **************

    //endregion

    //region ************** UserInformationScreen.Listener **************

    @Override
    public void onShowAllContactsPressed() {
        getPresenter().onUserContactsPressed();
    }

    //endregion

    //endregion

}
