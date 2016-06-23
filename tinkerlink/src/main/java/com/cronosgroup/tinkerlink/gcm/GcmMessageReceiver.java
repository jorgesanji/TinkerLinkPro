package com.cronosgroup.tinkerlink.gcm;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.manager.AppGcmNotificationsManager;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class GcmMessageReceiver extends GcmListenerService {

    private AppGcmNotificationsManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        this.notificationManager = new AppGcmNotificationsManager(this);
    }

    @Override
    public void onMessageReceived(String from, Bundle data) {
        notificationManager.handleNotification(data);
    }
}