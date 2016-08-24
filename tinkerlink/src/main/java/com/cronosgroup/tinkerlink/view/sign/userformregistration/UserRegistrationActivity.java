package com.cronosgroup.tinkerlink.view.sign.userformregistration;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class UserRegistrationActivity extends TinkerLinkActivity<UserRegistrationFragment> implements IOFormListener {

    // Vars
    private AppUser user = new AppUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIconAndBackButton();
    }

    @Override
    public Class<UserRegistrationFragment> getFragment() {
        return UserRegistrationFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getToolBarStyle() {
        return ToolBarStyle.HOMESTYLE;
    }

    // Form listener

    @Override
    public AppUser getFormUser() {
        return user;
    }

    @Override
    public void setFormUser(AppUser appUser) {
        user = appUser;
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
