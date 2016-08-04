package com.cronosgroup.tinkerlink.view.home;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class HomeActivity extends TinkerLinkActivity<HomeFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.HOME;
    }

    @Override
    public Class<HomeFragment> getFragment() {
        return HomeFragment.class;
    }

}
