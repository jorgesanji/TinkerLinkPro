package com.cronosgroup.tinkerlink.view.sign.createaccountregistration;

import android.os.Bundle;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class CreateAccountRegistrationActivity extends TinkerLinkActivity<CreateAccountRegistrationFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIconAndBackButton();
    }

    @Override
    public Class<CreateAccountRegistrationFragment> getFragment() {
        return CreateAccountRegistrationFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getToolBarStyle() {
        return ToolBarStyle.HOMESTYLE;
    }


    // Manage Permissions

    @Override
    public boolean canLaunchPermission() {
        return true;
    }

    @Override
    public List<AppPermissionsManager.Permission> getRequestPermission() {
        List<PermissionsManager.Permission> list = new ArrayList<>();
        list.add(PermissionsManager.Permission.SMS);
        return null;
    }
}
