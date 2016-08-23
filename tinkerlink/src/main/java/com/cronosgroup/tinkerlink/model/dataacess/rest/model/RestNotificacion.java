/**
 * Clase que encapsula el objeto Notificacion
 */
package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestNotificacion extends RestBase {

    @SerializedName("id")
    private String id = "";

    @SerializedName("user")
    private RestContact user = new RestContact();

    @SerializedName("type")
    private Integer type = 0;

    @SerializedName("date")
    private Date date;

    @SerializedName("readed")
    private Boolean readed = false;

    @SerializedName("done")
    private Boolean done = false;

    @SerializedName("text")
    private String texto = "";

    @SerializedName("skills")
    private List<String> skills = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(RestContact user) {
        this.user = user;
    }

    public RestContact getUser() {
        return user;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

}
