package com.cronosgroup.tinkerlink.view.searchcard;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class SearchCardActivity extends TinkerLinkActivity<SearchCardFragment> {

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
    public Class<SearchCardFragment> getFragment() {
        return SearchCardFragment.class;
    }
}
