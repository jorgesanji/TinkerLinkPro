package com.cronosgroup.tinkerlink.view.cardfilter;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class FilterCardsActivity extends TinkerLinkActivity<FilterCardsFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.filter_cards_title);
    }

    @Override
    public Class<FilterCardsFragment> getFragment() {
        return FilterCardsFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getToolBarStyle() {
        return ToolBarStyle.DEFAULTSTYLE;
    }


}
