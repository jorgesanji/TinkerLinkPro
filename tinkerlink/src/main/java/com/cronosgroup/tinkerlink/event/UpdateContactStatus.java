package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;

/**
 * Created by jorgesanmartin on 4/5/16.
 */
public class UpdateContactStatus {

    private final RestContact contacto;

    public UpdateContactStatus(RestContact restContact) {
        this.contacto = restContact;
    }

    public RestContact getContacto() {
        return contacto;
    }
}
