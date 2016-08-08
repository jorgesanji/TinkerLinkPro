package com.cronosgroup.tinkerlink.view.home;

import com.cronosgroup.tinkerlink.enums.StyleToolBar;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class HomeActivity extends TinkerLinkActivity<HomeFragment> {

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.HOMESTYLE;
    }

    @Override
    public Class<HomeFragment> getFragment() {
        return HomeFragment.class;
    }

}
