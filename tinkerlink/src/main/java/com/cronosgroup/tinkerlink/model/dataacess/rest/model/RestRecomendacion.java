package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronasencio on 30/7/15.
 */
public class RestRecomendacion extends RestBase {

    @SerializedName("_id")
    private String id = "";

    @SerializedName("user")
    private RestContacto user = new RestContacto();

    @SerializedName("create_date")
    private String createDate = "";

    @SerializedName("texto")
    private String recomendacion = "";

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<String>();


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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
