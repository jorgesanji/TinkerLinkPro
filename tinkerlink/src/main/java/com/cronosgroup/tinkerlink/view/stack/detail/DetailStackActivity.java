package com.cronosgroup.tinkerlink.view.stack.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class DetailStackActivity extends TinkerLinkActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.TINKERSTYLE;
    }

    @Override
    public int getActivityIconBack() {
        return 0;
    }

    @Override
    public Fragment getFragment() {
        return new DetailStackFragment();
    }
}
