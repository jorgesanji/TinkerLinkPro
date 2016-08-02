package com.cronosgroup.tinkerlink.view.createcard;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class CreateCardActivity extends TinkerLinkActivity<CreateCardFragment> {

    @Override
    public Class<CreateCardFragment> getFragment() {
        return CreateCardFragment.class;
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
        return getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE) == StackCard.LINKER ? StyleToolBar.LINKERSTYLE : StyleToolBar.TINKERSTYLE;
    }

    @Override
    public void onBackPressed() {
        if (getCurrentFragment() != null && ((CreateCardFragment) getCurrentFragment()).onBackPressed()) {
            return;
        }
        super.onBackPressed();
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
