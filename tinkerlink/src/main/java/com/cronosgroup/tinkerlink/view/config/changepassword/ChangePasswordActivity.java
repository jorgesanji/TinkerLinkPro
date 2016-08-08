package com.cronosgroup.tinkerlink.view.config.changepassword;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StyleToolBar;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class ChangePasswordActivity extends TinkerLinkActivity<ChangePasswordFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.configuration_change_password);
    }

    @Override
    public Class<ChangePasswordFragment> getFragment() {
        return ChangePasswordFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.DEFAULTSTYLE;
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
