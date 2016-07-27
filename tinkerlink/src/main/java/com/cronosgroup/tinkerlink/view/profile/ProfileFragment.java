package com.cronosgroup.tinkerlink.view.profile;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Sign Fragment
 */
public class ProfileFragment extends MVPTinkerLinkFragment<ProfilePresenter, ProfilePresenter.View>
        implements ProfilePresenter.View, ProfileScreen.Listener {

    // Vars

    // Views
    private ProfileScreen profileScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        profileScreen = new ProfileScreen(getActivity());
        profileScreen.setListener(this);
        return profileScreen;
    }

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
        profileScreen.initPager(getActivity().getSupportFragmentManager());
    }

    //endregion

    //region ************** ProfilePresenter.View **************

    //endregion

    //region ************** ProfileScreen.Listener **************


    //endregion

    //endregion

}
