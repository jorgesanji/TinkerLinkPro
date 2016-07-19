package com.cronosgroup.tinkerlink.view.stack.detail;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class DetailStackActivity extends TinkerLinkActivity<DetailStackFragment> {

    public static final String STACK_ITEMS = "items";
    public static final String STACK_CURRENT_ITEM = "currenIndexPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
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
    public Class<DetailStackFragment> getFragment() {
        return DetailStackFragment.class;
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
