package com.cronosgroup.tinkerlink.model.adapter;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;

/**
 * Created by jorgesanmartin on 2/5/16.
 */
public class TLNotifications {

    public static RestNotificacion toRest(TLNotification notification) {

        RestNotificacion restNotificacion = new RestNotificacion();
        restNotificacion.setUsuario(TLUsers.toContact(notification.getUser(), false));
        restNotificacion.setId(notification.getId());
        restNotificacion.setIdNotificacion(notification.getIdNotifications());
        restNotificacion.setTipo(notification.getTipo());
        restNotificacion.setFecha(notification.getDate());
        restNotificacion.setTexto(notification.getTexto());
        restNotificacion.setHabilities(AppRestManager.mapping.mappingFromStrinToStringList(notification.getHabilities()));

        return restNotificacion;
    }
}
