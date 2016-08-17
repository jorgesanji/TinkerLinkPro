package com.cronosgroup.tinkerlink.view.profile.adapter.pages.useractivity;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.profile.UserActivityPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * UserActivity Fragment
 */
public class UserActivityFragment extends MVPTinkerLinkFragment<UserActivityPresenter, UserActivityPresenter.View>
        implements UserActivityPresenter.View, UserActivityScreen.Listener {

    // Vars

    // Views
    private UserActivityScreen userActivityScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        userActivityScreen = new UserActivityScreen(getActivity());
        userActivityScreen.setListener(this);
        return userActivityScreen;
    }

    @Override
    protected UserActivityPresenter createPresenter() {
        return new UserActivityPresenter();
    }

    @Override
    protected UserActivityPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** UserActivityPresenter.View **************

    //endregion

    //region ************** UserActivityScreen.Listener **************


    //endregion

    //endregion

}
