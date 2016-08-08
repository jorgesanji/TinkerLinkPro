package com.cronosgroup.tinkerlink.view.home;

import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class HomeActivity extends TinkerLinkActivity<HomeFragment> {

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getActivityStyle() {
        return ToolBarStyle.HOMESTYLE;
    }

    @Override
    public Class<HomeFragment> getFragment() {
        return HomeFragment.class;
    }

}
