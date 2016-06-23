package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/17/15.
 */
public class RestCategoria extends RestBase {

    @SerializedName("profesion")
    private String profesion;

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<>();

    public String getProfesion() {
        return removeQuoationMarks(profesion);
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCategoria() {
        return removeQuoationMarks(categoria);
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
