package com.cronosgroup.tinkerlink.view.tutorial;

import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.gcm.GcmRegistrationDevice;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.utils.GcmUtils;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 16/10/15.
 */

public class TutorialActivity extends TinkerLinkActivity<TutorialFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (GcmUtils.checkPlayServices(this)) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, GcmRegistrationDevice.class);
            startService(intent);
        }
    }

    @Override
    public Class<TutorialFragment> getFragment() {
        return TutorialFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.DEFAULTSTYLE;
    }

    @Override
    public boolean canLaunchPermission() {
        return false;
    }

    @Override
    public List<AppPermissionsManager.Permission> getRequestPermission() {
        List<AppPermissionsManager.Permission> permissionList = new ArrayList<>();
        permissionList.add(AppPermissionsManager.Permission.ALL);

        return permissionList;
    }
}