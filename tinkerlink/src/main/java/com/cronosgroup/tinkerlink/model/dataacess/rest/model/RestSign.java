package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestSign extends RestBase {

    @SerializedName("exist")
    private Boolean exists = Boolean.FALSE;

    @SerializedName("usuario")
    private RestUser user = new RestUser();

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public RestUser getUser() {
        return user;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }
}
