package com.cronosgroup.tinkerlink.view.config.main.adapter.pages.usernotifications;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.editprofile.UserNotificationsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * User Notifications Fragment
 */
public class UserNotificationsFragment extends MVPTinkerLinkFragment<UserNotificationsPresenter, UserNotificationsPresenter.View>
        implements UserNotificationsPresenter.View, UserNotificationsScreen.Listener {

    // Vars

    // Views
    private UserNotificationsScreen userNotificationsScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        userNotificationsScreen = new UserNotificationsScreen(getActivity());
        userNotificationsScreen.setListener(this);
        return userNotificationsScreen;
    }

    @Override
    protected UserNotificationsPresenter createPresenter() {
        return new UserNotificationsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected UserNotificationsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** UserNotificationsPresenter.View **************

    //endregion

    //region ************** UserNotificationsScreen.Listener **************

    //endregion

}
