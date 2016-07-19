package com.cronosgroup.tinkerlink.view.network;

import android.graphics.Color;

import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class NetworkActivity extends TinkerLinkActivity<NetworkFragment>  {

    @Override
    public Class<NetworkFragment> getFragment() {
        return NetworkFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return null;
    }

    @Override
    public int getStatusColor() {
        return Color.TRANSPARENT;
    }

    // Manage Permissions

    @Override
    public boolean canLaunchPermission() {
        return false;
    }

    @Override
    public List<AppPermissionsManager.Permission> getRequestPermission() {
        List<AppPermissionsManager.Permission> permissionList = new ArrayList<>();
        return permissionList;
    }
}
