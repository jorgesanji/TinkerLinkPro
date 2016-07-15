package com.cronosgroup.tinkerlink.view.createrecommendation;

import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.createcard.CreateCardFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class CreateRecommendationActivity extends TinkerLinkActivity {

    @Override
    public Fragment getFragment() {
        return Fragment.instantiate(this, CreateRecommendationFragment.class.getName());
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
