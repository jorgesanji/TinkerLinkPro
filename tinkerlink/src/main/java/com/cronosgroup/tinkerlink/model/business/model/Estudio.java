package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aaronasencio on 04/05/15.
 */
public class Estudio {

    private int id = -1;

    @SerializedName("curso")
    private String curso = "";

    @SerializedName("escuela")
    private String escuela = "";


    public Estudio() {

    }

    public Estudio(String curso, String escuela) {
        this.curso = curso;
        this.escuela = escuela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
