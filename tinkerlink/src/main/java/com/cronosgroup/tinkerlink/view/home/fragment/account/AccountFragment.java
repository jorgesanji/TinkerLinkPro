package com.cronosgroup.tinkerlink.view.home.fragment.account;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.account.AccountPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Profile Fragment
 */
public class AccountFragment extends MVPTinkerLinkFragment<AccountPresenter, AccountPresenter.View>
        implements AccountPresenter.View, AccountScreen.Listener {

    private AccountScreen accountScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        accountScreen = new AccountScreen(getActivity());
        accountScreen.setListener(this);
        return accountScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected AccountPresenter createPresenter() {
        return new AccountPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected AccountPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        accountScreen.setUserImage("http://qsrock.com/wp-content/uploads/2016/04/130699422.jpg");
        accountScreen.setUserName("Jorge Sanmartin");
        accountScreen.setUserJob("Plomero");
        accountScreen.setUserRecommendationsNumber("2K");
    }

    //region **************  AccountScreen.Listener **************

    @Override
    public void onEditProfilePressed() {
        getPresenter().onLaunchEditProfile();
    }

    @Override
    public void onConfigProfilePressed() {
        getPresenter().onLaunchConfigProfile();
    }

    @Override
    public void onWatchProfilePressed() {
        getPresenter().onLaunchProfile();
    }

    @Override
    public void onImTinkerPressed() {
        getPresenter().onLaunchTinkerCards();
    }

    @Override
    public void onSearchTinkerPressed() {
        getPresenter().onLaunchLinkerCards();
    }

    //endregion

    //region **************  AccountPresenter.View **************

    //endregion
}
