package com.cronosgroup.tinkerlink.view.profile;

import android.view.View;

import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.EditProfilePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Sign Fragment
 */
public class ProfileFragment extends MVPTinkerLinkFragment<EditProfilePresenter, EditProfilePresenter.View>
        implements EditProfilePresenter.View, ProfileScreen.Listener {

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
    protected EditProfilePresenter createPresenter() {
        return new EditProfilePresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected EditProfilePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** EditProfilePresenter.View **************

    //endregion

    //region ************** EditProfileScreen.Listener **************


    //endregion

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
