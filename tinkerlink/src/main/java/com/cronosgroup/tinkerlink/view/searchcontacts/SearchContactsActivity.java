package com.cronosgroup.tinkerlink.view.searchcontacts;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class SearchContactsActivity extends TinkerLinkActivity<SearchContactsFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(R.string.search_card_title);
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
    public Class<SearchContactsFragment> getFragment() {
        return SearchContactsFragment.class;
    }
}
