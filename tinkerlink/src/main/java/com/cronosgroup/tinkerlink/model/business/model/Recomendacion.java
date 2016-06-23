package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronasencio on 30/7/15.
 */
public class Recomendacion {

    @SerializedName("idRecomendacion")
    private Long id = (long) -1;

    @SerializedName("_id")
    private String idWS = "";

    @SerializedName("usuario")
    private User usuario = new User();

    @SerializedName("habilities")
    private String intervalo = "";

    @SerializedName("texto")
    private String recomendacion = "";

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<String>();

    public Recomendacion() {

    }

    public Recomendacion(String idWS, User usuario, String intervalo, String recomendacion,
                         List<String> habilidades) {
        this.idWS = idWS;
        this.usuario = usuario;
        this.intervalo = intervalo;
        this.recomendacion = recomendacion;
        this.habilidades = habilidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdWS() {
        return idWS;
    }

    public void setIdWS(String idWS) {
        this.idWS = idWS;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
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
