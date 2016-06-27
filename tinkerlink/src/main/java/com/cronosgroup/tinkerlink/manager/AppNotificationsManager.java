package com.cronosgroup.tinkerlink.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.event.UpdateNotificationsEvent;
import com.cronosgroup.tinkerlink.model.business.logic.NotificationsUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.NotificationsManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

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

        NotificationsUseCases.getNotifications(new Callback<List<RestNotificacion>, RestError>() {
            @Override
            public void onResponse(List<RestNotificacion> response) {
                for (RestNotificacion restNotificacion : response) {
                    notificationManager.saveNotification(restNotificacion);
                }
                long notificationsUnReadNumber = notificationManager.getNotificationsUnReadCount();
                if (notificationsUnReadNumber > 0) {
                    EventBus.getDefault().post(new UpdateNotificationsEvent(notificationsUnReadNumber));
                }
            }

            @Override
            public void onErrorResponse(RestError error) {

            }

        }, mContext);
    }

    public void checkAllNotifications(final List<TLNotification> notificationList) {

        AsyncLoader asyncLoader = new AsyncLoader() {
            @Override
            public Object doInBackground() {

                for (final TLNotification tlNotification : notificationList) {
                    NotificationsUseCases.checkNotificationReaded(tlNotification.getId(), new Callback<Boolean, RestError>() {
                        @Override
                        public void onResponse(Boolean response) {
                            if (!response) {
                                tlNotification.setReaded(true);
                                tlNotification.save();
                            }
                        }

                        @Override
                        public void onErrorResponse(RestError error) {

                        }

                    }, mContext);
                }

                return null;
            }

            @Override
            public void postProcess(Object result) {

            }
        };

        asyncLoader.start();
    }
}
