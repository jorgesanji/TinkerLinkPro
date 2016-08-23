package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.tinkerlink.model.dataacess.database.manager.NotificationsManager;

/**
 * Created by jorgesanmartin on 10/1/16.
 */
public class AppNotificationsManager {

    private final Context mContext;
    private final NotificationsManager notificationManager;

    public AppNotificationsManager(Context context) {
        super();
        this.mContext = context;
        this.notificationManager = new NotificationsManager();
    }

    public void getNotifications() {

    }
}
