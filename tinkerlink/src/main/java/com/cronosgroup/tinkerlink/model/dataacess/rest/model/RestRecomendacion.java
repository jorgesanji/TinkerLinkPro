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

    @SerializedName("usuario")
    private RestContacto usuario = new RestContacto();

    @SerializedName("habilities")
    private String intervalo = "";

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

    public RestContacto getUsuario() {
        return usuario;
    }

    public void setUsuario(RestContacto usuario) {
        this.usuario = usuario;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
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
