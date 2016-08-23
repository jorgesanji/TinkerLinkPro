package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;

import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.event.UpdateContactStatus;
import com.cronosgroup.tinkerlink.event.UpdateNotificationsEvent;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.NotificationsManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.utils.AppNotificationBuilder;
import com.cronosgroup.tinkerlink.utils.UINotificationHelper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 4/7/16.
 */
public class AppGcmNotificationsManager {

    public static final String TAG = AppGcmNotificationsManager.class.toString();
    public static final String KEY_MESSAGE_GCM = "msg";
    public static final String KEY_MESSAGE = "mensaje";
    public static final String KEY_NOTIFICATION = "notificacion";
    public static final String SEND_MESSAGE_CHAT = "enviarMensaje";
    public static final int CHAT_TYPE = 1;
    public static final int NOTIFICATION_TYPE = 2;
    public static String KEY_TYPE = "type";
    public static String KEY_ITEM = "user";

    private NotificationsManager notificationManager;
    private final Context mContext;

    @Inject
    AppMessagesManager appMessagesManager;

    @Inject
    AppContactsManager appContactsManager;

    @Inject
    AppUserSessionManager appUserSessionManager;

    public AppGcmNotificationsManager(Context mContext) {
        this.mContext = mContext;
        this.notificationManager = new NotificationsManager();
    }

    private void notificationReceived(String notification) {
        RestNotificacion restNotification = (RestNotificacion) AppRestManager.mapping.mappingJson(notification, KEY_NOTIFICATION, RestNotificacion.class);
        if (restNotification != null
                && (NotificationsManager.notificationsAllowed.contains(restNotification.getType())
                || NotificationsManager.notificationsAllowedWithoutAction.contains(restNotification.getType()))) {
            if (restNotification.getType().intValue() == NotificationsManager.NOTIFICACION_TIPO_USUARIO_DUPLICADO) {
                if (TinkerLinkApplication.getApp() != null) {
                    appUserSessionManager.logout();
                }
            } else if (restNotification.getType().intValue() == NotificationsManager.NOTIFICACION_CONTACT_DELETED_TO_ME) {
                if (TinkerLinkApplication.getApp() != null) {
                    appContactsManager.loadContacts();
                }
                EventBus.getDefault().post(new UpdateContactStatus(restNotification.getUser()));
            } else if (restNotification.getType().intValue() == NotificationsManager.NOTIFICACION_CONTACT_REJECTED_TO_ME) {
                TLNotification tlNotification = notificationManager.getNotificationById(restNotification.getId());
                if (tlNotification != null) {
                    tlNotification.delete();
                }
                EventBus.getDefault().post(new UpdateContactStatus(restNotification.getUser()));
            } else {
                if (TinkerLinkApplication.getApp() != null) {
                    notificationManager.saveNotification(restNotification);
                    long notificationsUnReadNumber = notificationManager.getNotificationsUnReadCount();
                    if (notificationsUnReadNumber > 0) {
                        EventBus.getDefault().post(new UpdateNotificationsEvent(notificationsUnReadNumber));
                    }
                    if (restNotification.getType() == NotificationsManager.NOTIFICACION_CONTACT_ACCEPTED_TO_ME) {
                        appContactsManager.loadContacts();
                        EventBus.getDefault().post(new UpdateContactStatus(restNotification.getUser()));
                    }
                    if (restNotification.getType() == NotificationsManager.NOTIFICACION_CONTACT_REQUESTED_TO_ME) {
                        EventBus.getDefault().post(new UpdateContactStatus(restNotification.getUser()));
                    }
                }
                Pair<Integer, Integer> resources = UINotificationHelper.getResourcesFromType(restNotification.getType());
                String message = String.format(mContext.getResources().getString(resources.second), restNotification.getUser().getUser().getName());
                sendNotification(NOTIFICATION_TYPE, mContext.getString(R.string.app_name), message, restNotification.getUser());
            }
        }
    }

    private void messageReceived(String message) {
        RestMessage restMensaje = (RestMessage) AppRestManager.mapping.mappingJson(message, KEY_MESSAGE, RestMessage.class);
        if (restMensaje != null) {
            if (TinkerLinkApplication.getApp() != null) {
                appMessagesManager.getMessagesUnRead();
            }
            sendNotification(CHAT_TYPE, restMensaje.getUser().getUser().getName(), restMensaje.getMensaje(), restMensaje.getUser());
        }
    }

    private void sendNotification(int type, String title, String message, RestBase restBase) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TYPE, type);
        if (restBase != null) {
            bundle.putSerializable(KEY_ITEM, restBase);
        }

        AppNotificationBuilder.showNotification(mContext, title, message, R.mipmap.ic_notification, R.color.tinkercolor, bundle);
    }

    //Public methods

    public void handleNotification(Bundle data) {
        boolean userLoged;
        if (TinkerLinkApplication.getApp() != null) {
            userLoged = (appUserSessionManager.getCurrentUser() != null);
        } else {
            AppDataBaseManager.initDataBase(mContext);
            appUserSessionManager = new AppUserSessionManager(mContext);
            userLoged = (appUserSessionManager.getCurrentUser() != null);
        }

        if (userLoged) {
            String response = data.getString(KEY_MESSAGE_GCM);
            RestResponse restResponse = (RestResponse) AppRestManager.mapping.mappingJson(response, RestResponse.class);
            if (restResponse != null) {
                if (restResponse.getFuncName().equalsIgnoreCase(SEND_MESSAGE_CHAT)) {
                    messageReceived(restResponse.getData());
                } else {
                    notificationReceived(restResponse.getData());
                }
            }
        }
    }
}
