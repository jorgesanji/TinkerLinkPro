package com.cronosgroup.tinkerlink.view.detailcard;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class DetailStackActivity extends TinkerLinkActivity<DetailStackFragment> {

    public static final String KEY_ITEM = "item";
    public static final String KEY_PUBLISH = "publish";
    public static final String KEY_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isPuslish = getIntent().getExtras().getBoolean(KEY_PUBLISH);
        setTitle(isPuslish ? null : getString(R.string.create_card_experience_previsualize));
    }

    @Override
    public Class<DetailStackFragment> getFragment() {
        return DetailStackFragment.class;
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
        return null;
    }
}
