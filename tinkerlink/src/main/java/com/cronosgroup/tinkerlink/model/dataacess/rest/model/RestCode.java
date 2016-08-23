package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 11/5/15.
 */
public class RestCode extends RestBase {

    @SerializedName("user")
    private RestUser user = new RestUser();

    public RestCode() {
        super();
    }

    public RestUser getUser() {
        return user;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }
}
