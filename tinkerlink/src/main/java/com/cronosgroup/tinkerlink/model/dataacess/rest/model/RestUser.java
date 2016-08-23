package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestUser extends RestBase {

    @SerializedName("id")
    private String id = "";

    @SerializedName("phone")
    private String phone = "";

    @SerializedName("name")
    private String name = "";

    @SerializedName("lastname")
    private String lastname = "";

    @SerializedName("gender")
    private String gender = "";

    @SerializedName("email")
    private String email = "";

    @SerializedName("photo")
    private String photo = "";

    @SerializedName("birthday")
    private String birthday = "";

    @SerializedName("contacts")
    private List<RestUser> contacts = new ArrayList<>();

    @SerializedName("linker")
    private int numberLinkers;

    @SerializedName("tinker")
    private int numberTinkers;

    @SerializedName("recommendations")
    private int recommendations;

    @SerializedName("description")
    private String description = "";

    @SerializedName("category")
    private String category = "";

    @SerializedName("profession")
    private String profession = "";

    @SerializedName("estudies")
    private List<RestStudy> studies = new ArrayList<>();

    @SerializedName("skills")
    private List<String> skills = new ArrayList<>();

    @SerializedName("gallery")
    private List<String> gallery = new ArrayList<>();

    @SerializedName("country")
    private String country = "";

    @SerializedName("city")
    private String city = "";

    private boolean me = false;

    private boolean support = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<RestUser> getContacts() {
        return contacts;
    }

    public void setContacts(List<RestUser> contacts) {
        this.contacts = contacts;
    }

    public int getNumberLinkers() {
        return numberLinkers;
    }

    public void setNumberLinkers(int numberLinkers) {
        this.numberLinkers = numberLinkers;
    }

    public int getNumberTinkers() {
        return numberTinkers;
    }

    public void setNumberTinkers(int numberTinkers) {
        this.numberTinkers = numberTinkers;
    }

    public int getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(int recommendations) {
        this.recommendations = recommendations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<RestStudy> getStudies() {
        return studies;
    }

    public void setStudies(List<RestStudy> studies) {
        this.studies = studies;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
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

    public boolean isMe() {
        return me;
    }

    public RestUser setMe(boolean me) {
        this.me = me;
        return this;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

}
