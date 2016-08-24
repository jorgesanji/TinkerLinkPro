package com.cronosgroup.tinkerlink.view.sign.socialnetworkregistration;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class SocialNetWorkRegistrationActivity extends TinkerLinkActivity<SocialNetWorkRegistrationFragment>  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIconAndBackButton();
    }

    @Override
    public Class<SocialNetWorkRegistrationFragment> getFragment() {
        return SocialNetWorkRegistrationFragment.class;
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
