package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RestChat extends RestBase {

    @SerializedName("_id")
    private String id = "";

    @SerializedName("user")
    private RestContacto user = new RestContacto();

    @SerializedName("messages")
    private List<RestMensaje> mensajes = new ArrayList<RestMensaje>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestContacto getUser() {
        return user;
    }

    public void setUser(RestContacto user) {
        this.user = user;
    }

    public List<RestMensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<RestMensaje> mensajes) {
        this.mensajes = mensajes;
    }
}