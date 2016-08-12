package com.cronosgroup.tinkerlink.view.home;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Home Fragment
 */
public class HomeFragment extends MVPTinkerLinkFragment<HomePresenter, HomePresenter.View>
        implements HomePresenter.View, HomeScreen.Listener {

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
        return new HomePresenter();
    }

    @Override
    protected HomePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        onNewsFeedPresed();
    }

    //region **************  HomeScreen.Listener **************

    @Override
    public void onCreateRecommendationPressed() {
        getPresenter().onLaunchCreateRecommendation();
    }

    @Override
    public void onCreateTinkerPressed() {
        getPresenter().onLaunchCreateTinker();
    }

    @Override
    public void onCreateLinkerPressed() {
        getPresenter().onLaunchCreateLinker();
    }

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
        homeScreen.setItem(position);
        replaceFragment(fragments[position]);
    }

    private void replaceFragment(MainFragments mainFragment) {
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(mainFragment.getFragment());
        if (fragment == null || !fragment.getClass().equals(mainFragment.getClassFragment())) {
            addFragment(mainFragment.getClassFragment(), R.id.contentActionsFrame);
        }
    }

    //endregion

}
