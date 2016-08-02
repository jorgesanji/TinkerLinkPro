package com.cronosgroup.tinkerlink.view.searchcard;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.presenter.searchcard.SearchCardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * StackCard Fragment
 */
public class SearchCardFragment extends MVPTinkerLinkFragment<SearchCardPresenter, SearchCardPresenter.View>
        implements SearchCardPresenter.View, SearchCardScreen.Listener {

    private SearchCardScreen searchCardScreen;
    private StackCard stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View getRootView() {
        searchCardScreen = new SearchCardScreen(getActivity(), this);
        return searchCardScreen;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected SearchCardPresenter createPresenter() {
        return new SearchCardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected SearchCardPresenter.View getPresenterView() {
        return this;
    }

    //region **************  DetailStackScreen.Listener **************

    //endregion

    //region **************  DetailStackPresenter.View **************

    //endregion
}
