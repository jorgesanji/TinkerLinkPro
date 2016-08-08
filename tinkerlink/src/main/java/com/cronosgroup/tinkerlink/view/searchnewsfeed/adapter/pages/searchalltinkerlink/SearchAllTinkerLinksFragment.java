package com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchalltinkerlink;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.presenter.searchnewsfeed.SearchNewsFeedPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * StackCard Fragment
 */
public class SearchAllTinkerLinksFragment extends MVPTinkerLinkFragment<SearchNewsFeedPresenter, SearchNewsFeedPresenter.View>
        implements SearchNewsFeedPresenter.View, SearchAllTinkerLinkScreen.Listener {

    private SearchAllTinkerLinkScreen searchCardScreen;
    private StackCard stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View getRootView() {
        searchCardScreen = new SearchAllTinkerLinkScreen(getActivity(), this);
        return searchCardScreen;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected SearchNewsFeedPresenter createPresenter() {
        return new SearchNewsFeedPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected SearchNewsFeedPresenter.View getPresenterView() {
        return this;
    }

    //region **************  SearchNewsFeedScreen.Listener **************

    //endregion

    //region **************  SearchNewsFeedPresenter.View **************

    //endregion
}