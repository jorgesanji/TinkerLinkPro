package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.tinkerlink.model.dataacess.database.manager.ChatManager;


/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class AppMessagesManager {
    private final Context mContext;
    private final ChatManager mManager;

    public AppMessagesManager(Context context) {
        super();
        this.mContext = context;
        this.mManager = new ChatManager();
    }

    public void getMessagesUnRead() {
        
    }
}
