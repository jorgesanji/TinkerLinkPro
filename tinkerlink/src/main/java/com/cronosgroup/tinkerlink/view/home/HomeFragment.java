package com.cronosgroup.tinkerlink.view.home;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Home Fragment
 */
public class HomeFragment extends MVPTinkerLinkFragment<HomePresenter, HomePresenter.View>
        implements HomePresenter.View, HomeScreen.Listener {

    private HomeScreen homeScreen;

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
        homeScreen.initAdapter(getActivity().getSupportFragmentManager());
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

    //endregion

    @Override
    public boolean onBackPressed() {
        boolean firstPage = homeScreen.isFirstPage();
        if (!firstPage) {
            homeScreen.setPageSelected(0);
        }

        return !firstPage;
    }
}
