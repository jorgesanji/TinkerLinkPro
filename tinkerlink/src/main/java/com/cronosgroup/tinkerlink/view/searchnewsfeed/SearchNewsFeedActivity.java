package com.cronosgroup.tinkerlink.view.searchnewsfeed;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class SearchNewsFeedActivity extends TinkerLinkActivity<SearchNewsFeedFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.search_newsfeed_title);
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.DEFAULTSTYLE;
    }

    @Override
    public Class<SearchNewsFeedFragment> getFragment() {
        return SearchNewsFeedFragment.class;
    }
}
