package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class RestRecovery extends RestBase {

    @SerializedName("usuario")
    private RestUser usuario = new RestUser();

    public RestUser getUsuario() {
        return usuario;
    }

    public void setUsuario(RestUser usuario) {
        this.usuario = usuario;
    }
}



