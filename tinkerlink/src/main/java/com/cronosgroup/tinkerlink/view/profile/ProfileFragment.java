package com.cronosgroup.tinkerlink.view.profile;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
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
        return new ProfilePresenter();
    }

    @Override
    protected ProfilePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getUserInfo();
    }

    //endregion

    //region ************** ProfilePresenter.View **************

    @Override
    public void setContact(RestContact contact) {
        RestUser restUser = contact.getUser();
        profileScreen.setUserName(restUser.getName());
        profileScreen.setUserJob(restUser.getProfile().getProfession());
        profileScreen.setUserImage(restUser.getPhoto());
        profileScreen.setUserCountry(restUser.getProfile().getCity() + "," + restUser.getProfile().getCountry());
        profileScreen.setContacts(contact.getUsersCommon());
        profileScreen.initPager(getActivity().getSupportFragmentManager());
    }

    //endregion

    //region ************** ProfileScreen.Listener **************

    @Override
    public void onClosePressed() {
        getActivity().finish();
    }

    @Override
    public void onImTinkerStackPressed() {
        getPresenter().onLaunchImTinker();
    }

    @Override
    public void onSearchTinkerStackPressed() {
        getPresenter().onLaunchSearchTinker();
    }

    //endregion

}
