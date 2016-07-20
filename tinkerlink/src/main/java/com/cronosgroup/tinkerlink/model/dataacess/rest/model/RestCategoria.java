package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/17/15.
 */
public class RestCategoria extends RestBase implements ParentListItem {

    @SerializedName("profesion")
    private String profesion;

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<>();

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCategoria() {
        return categoria;
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

    @Override
    public List<String> getChildItemList() {
        return habilidades;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
