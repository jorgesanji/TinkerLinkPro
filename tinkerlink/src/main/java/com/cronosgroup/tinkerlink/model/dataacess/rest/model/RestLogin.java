package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestLogin extends RestBase {

    @SerializedName("usuario")
    private RestUser user = new RestUser();

    public RestUser getUser() {
        return user;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }
}
