package com.cronosgroup.tinkerlink.view.home.fragment.profile;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;


/**
 * Profile Fragment
 */
public class ProfileFragment extends MVPTinkerLinkFragment<ProfilePresenter, ProfilePresenter.View>
        implements ProfilePresenter.View, ProfilePresenter.Actions, ProfileScreen.Listener {

    private ProfileScreen profileScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        profileScreen = new ProfileScreen(getActivity());
        profileScreen.setListener(this);
        return profileScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected ProfilePresenter createPresenter() {
        return new ProfilePresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ProfilePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //region **************  ProfileScreen.Listener **************


    //endregion

    //region **************  ProfilePresenter.View **************

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
