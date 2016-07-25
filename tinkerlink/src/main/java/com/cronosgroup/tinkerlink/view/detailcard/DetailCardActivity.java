package com.cronosgroup.tinkerlink.view.detailcard;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class DetailCardActivity extends TinkerLinkActivity<DetailCardFragment> {

    public static final String KEY_ITEM = "card";

    @Override
    public Class<DetailCardFragment> getFragment() {
        return DetailCardFragment.class;
    }

    @Override
    public View getView() {
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.layout_base_toolbar_white, null);
        }
        return view;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE) == StackActivity.Stack.LINKER ? StyleToolBar.LINKERSTYLE : StyleToolBar.TINKERSTYLE;
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
