package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronasencio on 12/05/15.
 */
public class RestCard extends RestBase {

    @SerializedName("id")
    private String id = "";

    @SerializedName("type")
    private String type = "";

    @SerializedName("user")
    private RestContact user = new RestContact();

    @SerializedName("category")
    private String category = "";

    @SerializedName("description")
    private String description = "";

    @SerializedName("budget")
    private String budget = "";

    @SerializedName("paymentMethod")
    private String paymentMethod = "";

    @SerializedName("profession")
    private String profession = "";

    @SerializedName("country")
    private String country = "";

    @SerializedName("city")
    private String city = "";

    @SerializedName("latitude")
    private double latitude = 0.0;

    @SerializedName("longitude")
    private double longitude = 0.0;

    @SerializedName("skills")
    private List<RestSkill> skills = new ArrayList<RestSkill>();

    @SerializedName("timeByProject")
    private String timeByProject = "";

    @SerializedName("experience")
    private String experience = "";

    @SerializedName("date")
    private Date date = null;

    @SerializedName("recommendations")
    private List<RestRecommendation> recommendations = new ArrayList<RestRecommendation>();

    @SerializedName("images")
    private List<String> images = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public RestContact getUser() {
        return user;
    }

    public void setUser(RestContact user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RestSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<RestSkill> skills) {
        this.skills = skills;
    }

    public String getTimeByProject() {
        return timeByProject;
    }

    public void setTimeByProject(String timeByProject) {
        this.timeByProject = timeByProject;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<RestRecommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<RestRecommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
