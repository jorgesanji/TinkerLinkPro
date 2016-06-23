package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronasencio on 14/5/15.
 */
public class Perfil implements Serializable {

    @SerializedName("id")
    private Long id = (long) -1;

    @SerializedName("pais")
    private String pais = "";

    @SerializedName("ciudad")
    private String ciudad = "";

    @SerializedName("categoria")
    private String categoria = "";

    @SerializedName("profesion")
    private String profesion = "";

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<String>();

    @SerializedName("estudios")
    private List<Estudio> estudios = new ArrayList<Estudio>();

    @SerializedName("likes")
    private Integer likes = 0;

    @SerializedName("like")
    private Boolean like = false;

    @SerializedName("comparticiones")
    private Integer comparticiones = 0;

    @SerializedName("visto")
    private Integer visto = 0;

    @SerializedName("recomendaciones")
    private ArrayList<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();

    @SerializedName("galeria")
    private ArrayList<String> galeria = new ArrayList<String>();

    public Perfil() {

    }

    public Perfil(Long id, String pais, String ciudad, String categoria, String profesion, List<String> habilidades,
                  List<Estudio> estudios, Integer likes, Boolean like, Integer comparticiones,
                  Integer visto, ArrayList<Recomendacion> recomendaciones, ArrayList<String> galeria) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.profesion = profesion;
        this.habilidades = habilidades;
        this.estudios = estudios;
        this.likes = likes;
        this.like = like;
        this.comparticiones = comparticiones;
        this.visto = visto;
        this.recomendaciones = recomendaciones;
        this.galeria = galeria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Integer getComparticiones() {
        return comparticiones;
    }

    public void setComparticiones(Integer comparticiones) {
        this.comparticiones = comparticiones;
    }

    public Integer getVisto() {
        return visto;
    }

    public void setVisto(Integer visto) {
        this.visto = visto;
    }

    public ArrayList<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(ArrayList<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public ArrayList<String> getGaleria() {
        return galeria;
    }

    public void setGaleria(ArrayList<String> galeria) {
        this.galeria = galeria;
    }
}
