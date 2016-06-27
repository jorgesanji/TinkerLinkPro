package com.cronosgroup.tinkerlink.view.sign;

import android.support.v4.app.Fragment;

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
public class SignActivity extends TinkerLinkActivity implements IOFormListener {

    private AppUser user = new AppUser();

    @Override
    public Fragment getFragment() {
        return Fragment.instantiate(this, SignFragment.class.getName());
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
    public int getActivityIconBack() {
        return 0;
    }

    @Override
    public void onBackPressed() {
        if (getCurrentFragment() != null && ((SignFragment) getCurrentFragment()).onBackPressed()) {
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
        permissionList.add(AppPermissionsManager.Permission.CAMERA);
        permissionList.add(AppPermissionsManager.Permission.GALLERY);
        return permissionList;
    }
}
