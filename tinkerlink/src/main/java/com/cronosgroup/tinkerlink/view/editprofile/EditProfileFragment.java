package com.cronosgroup.tinkerlink.view.editprofile;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.editprofile.EditProfilePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Sign Fragment
 */
public class EditProfileFragment extends MVPTinkerLinkFragment<EditProfilePresenter, EditProfilePresenter.View>
        implements EditProfilePresenter.View, EditProfileScreen.Listener {

    // Vars

    // Views
    private EditProfileScreen editProfileScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        editProfileScreen = new EditProfileScreen(getActivity());
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

    //region ************** ChatUserScreen.Listener **************


    //endregion

}
