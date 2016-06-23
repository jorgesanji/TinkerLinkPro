package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestProfile extends RestBase {

    @SerializedName("like")
    private Boolean like = Boolean.FALSE;

    @SerializedName("share")
    private Boolean share = Boolean.FALSE;

    @SerializedName("comparticiones")
    private int shared = 0;

    @SerializedName("likes")
    private int likes = 0;

    @SerializedName("visto")
    private int visto = 0;

    @SerializedName("recommendations")
    private int recommendations = 0;

    @SerializedName("descripcion")
    private String descripcion = "";

    @SerializedName("categoria")
    private String category = "";

    @SerializedName("profesion")
    private String profession = "";

    @SerializedName("estudios")
    private List<RestStudy> studies = new ArrayList<>();

    @SerializedName("habilidades")
    private List<String> habilities = new ArrayList<>();

    @SerializedName("userLikes")
    private List<String> userLikes = new ArrayList<>();

    @SerializedName("galeria")
    private List<String> galllery = new ArrayList<>();

    @SerializedName("fotoGaleria")
    private List<String> historicImagesProfile = new ArrayList<>();

    @SerializedName("pais")
    private String country = "";

    @SerializedName("ciudad")
    private String city = "";

    public int getShared() {
        return shared;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getVisto() {
        return visto;
    }

    public void setVisto(int visto) {
        this.visto = visto;
    }

    public List<RestStudy> getStudies() {
        return studies;
    }

    public void setStudies(List<RestStudy> studies) {
        this.studies = studies;
    }

    public List<String> getHabilities() {
        return habilities;
    }

    public void setHabilities(List<String> habilities) {
        this.habilities = habilities;
    }

    public List<String> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<String> userLikes) {
        this.userLikes = userLikes;
    }

    public List<String> getGalllery() {
        return galllery;
    }

    public void setGalllery(List<String> galllery) {
        this.galllery = galllery;
    }

    public List<String> getHistoricImagesProfile() {
        return historicImagesProfile;
    }

    public void setHistoricImagesProfile(List<String> historicImagesProfile) {
        this.historicImagesProfile = historicImagesProfile;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(int recommendations) {
        this.recommendations = recommendations;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocation() {
        return getCity().isEmpty() ? null : getCity() + ", " + getCountry();
    }
}
