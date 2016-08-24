package com.cronosgroup.tinkerlink.view.login;

import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class LoginActivity extends TinkerLinkActivity<LoginFragment> {

    @Override
    public Class<LoginFragment> getFragment() {
        return LoginFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }

    @Override
    public ToolBarStyle getToolBarStyle() {
        return ToolBarStyle.DEFAULTSTYLE;
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
