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
    private List<RestMessage> mensajes = new ArrayList<RestMessage>();

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

    public List<RestMessage> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<RestMessage> mensajes) {
        this.mensajes = mensajes;
    }
}