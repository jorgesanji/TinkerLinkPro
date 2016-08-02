package com.cronosgroup.tinkerlink.view.detailcard;

import android.os.Bundle;
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
public class DetailCardActivity extends TinkerLinkActivity<DetailCardFragment> {

    public static final String KEY_ITEM = "card";
    public static final String KEY_PUBLISH = "publish";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isPuslish = getIntent().getExtras().getBoolean(KEY_PUBLISH);
        if (!isPuslish) {
            setTitle(R.string.detail_card_title);
        }
    }

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
        return getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE) == StackCard.LINKER ? StyleToolBar.LINKERSTYLE : StyleToolBar.TINKERSTYLE;
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
