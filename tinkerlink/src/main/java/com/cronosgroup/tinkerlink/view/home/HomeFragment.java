package com.cronosgroup.tinkerlink.view.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;


/**
 * Home Fragment
 */
public class HomeFragment extends MVPTinkerLinkFragment<HomePresenter, HomePresenter.View>
        implements HomePresenter.View, HomePresenter.Actions, HomeScreen.Listener {

    private HomeScreen homeScreen;
    private MainFragments[] fragments = {MainFragments.NEWSFEED, MainFragments.CONTACTS, MainFragments.CHAT, MainFragments.PROFILE};

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        homeScreen = new HomeScreen(getActivity(), this);
        return homeScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected HomePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        onContactsPresed();
    }

    //region **************  HomeScreen.Listener **************

    @Override
    public void onNewsFeedPresed() {
        onMenuItemSelected(0);
    }

    @Override
    public void onContactsPresed() {
        onMenuItemSelected(1);
    }

    @Override
    public void onMessagesPresed() {
        onMenuItemSelected(2);
    }

    @Override
    public void onProfilePresed() {
        onMenuItemSelected(3);
    }

    private void onMenuItemSelected(int position) {
        replaceFragment(fragments[position]);
        homeScreen.setItem(position);
    }

    private void replaceFragment(MainFragments mainFragments) {
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(mainFragments.getFragment());
        if (fragment == null || !fragment.getClass().equals(mainFragments.getClassFragment())) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
            transaction.replace(R.id.contentActionsFrame, Fragment.instantiate(getActivity(), mainFragments.getFragment()), mainFragments.getFragment());
            transaction.commit();
        }
    }

    //endregion

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
