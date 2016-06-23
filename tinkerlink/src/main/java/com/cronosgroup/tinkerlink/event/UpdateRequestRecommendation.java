package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;

/**
 * Created by jorgesanmartin on 4/7/16.
 */
public class UpdateRequestRecommendation {

    private final RestNotificacion notificacion;

    public UpdateRequestRecommendation(RestNotificacion notificacion) {
        this.notificacion = notificacion;
    }

    public RestNotificacion getNotificacion() {
        return notificacion;
    }
}
