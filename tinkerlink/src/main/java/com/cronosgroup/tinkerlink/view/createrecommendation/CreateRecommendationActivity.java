package com.cronosgroup.tinkerlink.view.createrecommendation;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class CreateRecommendationActivity extends TinkerLinkActivity<CreateRecommendationFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.create_recommendation_title);
    }

    @Override
    public Class<CreateRecommendationFragment> getFragment() {
        return CreateRecommendationFragment.class;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getActivityStyle() {
        return ToolBarStyle.RECOMMENDATIONSSTYLE;
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
