package com.cronosgroup.tinkerlink.view.chatuser;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppPermissionsManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class ChatUserActivity extends TinkerLinkActivity<ChatUserFragment> {

    public static final String ITEMS_KEY = "items_key";

    //Vars
    private RestChat restChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restChat = (RestChat) getIntent().getExtras().getSerializable(ITEMS_KEY);
        final RestUser restUser = restChat.getUser().getUser();
        setTitle(restUser.getName());
        setSubtitle(restUser.getProfile().getProfession());
        setToolBarIconFromUrl(restUser.getPhoto(), R.mipmap.newsfeed_avatar_hombre);
    }

    @Override
    public Class<ChatUserFragment> getFragment() {
        return ChatUserFragment.class;
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
