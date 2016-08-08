package com.cronosgroup.tinkerlink.view.detailcard;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

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
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getActivityStyle() {
        return getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE) == StackCardType.LINKER ? ToolBarStyle.LINKERSTYLE : ToolBarStyle.TINKERSTYLE;
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
