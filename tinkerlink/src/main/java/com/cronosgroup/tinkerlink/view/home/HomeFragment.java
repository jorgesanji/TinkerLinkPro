package com.cronosgroup.tinkerlink.view.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;


/**
 * Login Fragment
 */
public class HomeFragment extends MVPFragment<HomePresenter, HomePresenter.View>
        implements HomePresenter.View, HomePresenter.Actions, HomeScreen.Listener {

    private HomeScreen homeScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        homeScreen = new HomeScreen(getActivity());
        homeScreen.setListener(this);
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
        onNewsFeedPresed();
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

        switch (position) {
            case 0:
                replaceFragment(MainFragments.NEWSFEED);
                break;
            case 1:
                replaceFragment(MainFragments.CONTACTS);
                break;
            case 2:
                replaceFragment(MainFragments.CHAT);
                break;
            case 3:
                replaceFragment(MainFragments.PROFILE);
                break;
        }
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

    //region **************  HomePresenter.View **************

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
