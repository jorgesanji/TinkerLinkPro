package com.cronosgroup.tinkerlink.view.searchcontacts;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class SearchContactsActivity extends TinkerLinkActivity<SearchContactsFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.search_card_title);
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getActivityStyle() {
        return ToolBarStyle.DEFAULTSTYLE;
    }

    @Override
    public Class<SearchContactsFragment> getFragment() {
        return SearchContactsFragment.class;
    }
}
