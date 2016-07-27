package com.cronosgroup.tinkerlink.view.config.frequentlyquestions;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class FrequentlyQuestionsActivity extends TinkerLinkActivity<FrequentlyQuestionsFragment> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbar().setLogo(null);
        getToolbar().setTitle(R.string.configuration_frequently_questions);
    }

    @Override
    public Class<FrequentlyQuestionsFragment> getFragment() {
        return FrequentlyQuestionsFragment.class;
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
