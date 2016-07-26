package com.cronosgroup.tinkerlink.view.profile;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.editprofile.EditProfilePresenter;
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
    private ProfileScreen editProfileScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        editProfileScreen = new ProfileScreen(getActivity());
        editProfileScreen.setListener(this);
        return editProfileScreen;
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

    }

    //endregion

    //region ************** EditProfilePresenter.View **************

    //endregion

    //region ************** ChatUserScreen.Listener **************


    //endregion

    //endregion

}
