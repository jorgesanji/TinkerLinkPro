package com.cronosgroup.tinkerlink.view.home.adapter.fragment.prenewsfeed;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.prenewsfeed.PreNewsFeedPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * PreNewsFeed Fragment
 */
public class PreNewsFeedFragment extends MVPTinkerLinkFragment<PreNewsFeedPresenter, PreNewsFeedPresenter.View>
        implements PreNewsFeedPresenter.View, PreNewsFeedScreen.Listener {

    private PreNewsFeedScreen preNewsFeedScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        preNewsFeedScreen = new PreNewsFeedScreen(getActivity());
        preNewsFeedScreen.setListener(this);
        return preNewsFeedScreen;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected PreNewsFeedPresenter createPresenter() {
        return new PreNewsFeedPresenter();
    }

    @Override
    protected PreNewsFeedPresenter.View getPresenterView() {
        return this;
    }

    //region **************  PreNewsFeedScreen.Listener **************

    @Override
    public void onCompleteProfilePressed() {
        getPresenter().onCompleteProfilePressed();
    }

    @Override
    public void onEmailVerifyPressed() {
        getPresenter().onLaunchVerifyEmail();
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

    //region **************  PreNewsFeedPresenter.View **************

    //endregion
}
