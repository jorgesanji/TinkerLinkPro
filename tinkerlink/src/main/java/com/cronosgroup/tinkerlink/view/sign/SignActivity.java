package com.cronosgroup.tinkerlink.view.sign;

import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class SignActivity extends TinkerLinkActivity<SignFragment> implements IOFormListener {

    // Vars
    private AppUser user = new AppUser();

    @Override
    public Class<SignFragment> getFragment() {
        return SignFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.TINKERSTYLE;
    }

    @Override
    public void onBackPressed() {
        if (getCurrentFragment() != null && (getCurrentFragment()).onBackPressed()) {
            return;
        }
        AppRestManager.sharedManager().cancelAllRequestWithTag(this);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppRestManager.sharedManager().cancelAllRequestWithTag(this);
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
        List<AppPermissionsManager.Permission> permissionList = new ArrayList<>();
        return permissionList;
    }
}
