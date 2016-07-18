package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class RestMessage extends RestBase {

    @SerializedName("_id")
    private String id = "";

    @SerializedName("chat")
    private String idChat = "";

    @SerializedName("user")
    private RestContacto usuario = new RestContacto();

    @SerializedName("message")
    private String mensaje = "";

    @SerializedName("date")
    private Date date = new Date();

    @SerializedName("readed")
    private Boolean leido = Boolean.FALSE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public RestContacto getUser() {
        return usuario;
    }

    public void setUsuario(RestContacto usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

}
