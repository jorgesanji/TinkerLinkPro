package com.cronosgroup.tinkerlink.view.sign.phoneregistration;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class PhoneRegistrationActivity extends TinkerLinkActivity<PhoneRegistrationFragment> {

    public static final String KEY_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIconAndBackButton();
    }

    @Override
    public Class<PhoneRegistrationFragment> getFragment() {
        return PhoneRegistrationFragment.class;
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
        return false;
    }

    @Override
    public List<AppPermissionsManager.Permission> getRequestPermission() {
        return null;
    }
}
