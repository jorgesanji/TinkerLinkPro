package com.cronosgroup.tinkerlink.view.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class HomeActivity extends TinkerLinkActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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
    public Fragment getFragment() {
        return new HomeFragment();
    }

}
