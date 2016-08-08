package com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchmycontacts;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.searchnewsfeed.SearchNewsFeedPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * StackCardType Fragment
 */
public class SearchMyContactsFragment extends MVPTinkerLinkFragment<SearchNewsFeedPresenter, SearchNewsFeedPresenter.View>
        implements SearchNewsFeedPresenter.View, SearchMyContactsScreen.Listener {

    private SearchMyContactsScreen searchCardScreen;
    private StackCardType stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View getRootView() {
        searchCardScreen = new SearchMyContactsScreen(getActivity(), this);
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
