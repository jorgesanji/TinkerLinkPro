package com.cronosgroup.tinkerlink.view.recommendations;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class RecommendationsActivity extends TinkerLinkActivity<RecommendationsFragment> {

    @Override
    public View getView() {
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.layout_base_toolbar_recommendation, null);
        }
        return view;
    }

    @Override
    public Class<RecommendationsFragment> getFragment() {
        return RecommendationsFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.RECOMMENDATIONS;
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
