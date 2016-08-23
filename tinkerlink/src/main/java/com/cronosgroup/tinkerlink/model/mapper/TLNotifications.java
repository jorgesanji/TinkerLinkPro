package com.cronosgroup.tinkerlink.model.mapper;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;

/**
 * Created by jorgesanmartin on 2/5/16.
 */
public class TLNotifications {

    public static RestNotificacion toRest(TLNotification notification) {

        RestNotificacion restNotificacion = new RestNotificacion();
        restNotificacion.setUser(TLUsers.toContact(notification.getUser(), false));
        restNotificacion.setId(notification.getId());
        restNotificacion.setType(notification.getTipo());
        restNotificacion.setDate(notification.getDate());
        restNotificacion.setTexto(notification.getTexto());
        restNotificacion.setSkills(AppRestManager.mapping.mappingFromStrinToStringList(notification.getHabilities()));

        return restNotificacion;
    }
}
