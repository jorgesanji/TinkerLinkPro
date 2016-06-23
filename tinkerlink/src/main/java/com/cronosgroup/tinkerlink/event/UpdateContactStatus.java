package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;

/**
 * Created by jorgesanmartin on 4/5/16.
 */
public class UpdateContactStatus {

    private final RestContacto contacto;

    public UpdateContactStatus(RestContacto restContacto) {
        this.contacto = restContacto;
    }

    public RestContacto getContacto() {
        return contacto;
    }
}
