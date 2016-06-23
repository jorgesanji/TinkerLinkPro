package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;

/**
 * Created by jorgesanmartin on 12/17/15.
 */
public class UpdateUserEvent {

    private final RestContacto restContacto;
    private final boolean reloadData;
    private final boolean loadWholeProfile;

    public UpdateUserEvent() {
        super();
        this.restContacto = null;
        this.reloadData = false;
        this.loadWholeProfile = false;
    }

    public UpdateUserEvent(RestContacto restContacto, boolean reloadData, boolean loadWholeProfile) {
        super();
        this.restContacto = restContacto;
        this.reloadData = reloadData;
        this.loadWholeProfile = loadWholeProfile;
    }

    // Public methods

    public RestContacto getRestContacto() {
        return restContacto;
    }

    public boolean isReloadData() {
        return reloadData;
    }

    public boolean isLoadWholeProfile() {
        return loadWholeProfile;
    }
}
