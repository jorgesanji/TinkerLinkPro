package com.cronosgroup.tinkerlink.view.home.fragment.profile;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;


/**
 * Profile Fragment
 */
public class ProfileFragment extends MVPFragment<ProfilePresenter, ProfilePresenter.View>
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
            ((ToolBarActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
