package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.NotificationsServices;
import com.cronosgroup.tinkerlink.utils.DateUtils;

/**
 * Created by jorgesanmartin on 10/1/16.
 */
public class NotificationsUseCases {

    public static void getNotifications(Callback callback, Object tag) {
        String endpoint = DateUtils.getCurrentDateTime();
        NotificationsServices.getNotifications(endpoint, RestNotificacion.class, callback, tag);
    }

    public static void deleteNotification(String idNotification, final Callback callback, Object tag) {
        NotificationsServices.deleteNotification(idNotification, callback, tag);
    }

    public static void responseRecommendation(long idNotification, boolean accept, final Callback callback, Object tag) {
        String endpoint = String.valueOf(idNotification) + "/" + (accept ? "true" : "false") + "/" + DateUtils.getCurrentDateTime();
        NotificationsServices.responseRecommendation(endpoint, RestNotificacion.class, callback, tag);
    }

    public static void checkNotificationReaded(String idNotification, final Callback<Boolean, RestError> callback, Object tag) {
        NotificationsServices.checkNotificationReaded(idNotification, callback, tag);
    }
}
