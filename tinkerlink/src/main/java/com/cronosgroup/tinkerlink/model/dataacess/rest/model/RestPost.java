package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.tinkerlink.enums.PostStatus;
import com.cronosgroup.tinkerlink.enums.PostType;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronasencio on 12/05/15.
 */
public class RestPost extends RestBase{

    @SerializedName("id")
    private String id = "";

    @SerializedName("user")
    private RestContact user = new RestContact();

    @SerializedName("contact")
    private RestContact contact = null;

    @SerializedName("type")
    private String type = "tinker";

    @SerializedName("date")
    private Date date = null;

    @SerializedName("likes")
    private Integer likes = 0;

    @SerializedName("view")
    private Integer numberOfViews = 0;

    @SerializedName("shares")
    private Integer numberShares = 0;

    @SerializedName("recommendations")
    private List<RestRecommendation> recommendations = new ArrayList<RestRecommendation>();

    @SerializedName("usersLike")
    private List<String> usersLike = new ArrayList<String>();

    @SerializedName("usersShare")
    private List<String> usersShare = new ArrayList<String>();

    @SerializedName("text")
    private String text = "";

    @SerializedName("pictures")
    private List<String> pictures = new ArrayList<String>();

    @SerializedName("post")
    private RestPost post = null;

    @SerializedName("country")
    private String country = "";

    @SerializedName("city")
    private String city = "";

    @SerializedName("latitude")
    private double latitude = 0.0;

    @SerializedName("longitude")
    private double longitude = 0.0;

    @SerializedName("category")
    private String category = "";

    @SerializedName("description")
    private String description = "";

    @SerializedName("salary")
    private String salary = "";

    @SerializedName("salaryType")
    private String salaryType = "";

    @SerializedName("skills")
    private List<RestSkill> skills = new ArrayList<RestSkill>();

    @SerializedName("timeByProject")
    private String timeByProject = "";

    @SerializedName("profession")
    private String profession = "";

    @SerializedName("experience")
    private String experience = "";

    @SerializedName("share")
    private Boolean share = false;

    @SerializedName("like")
    private Boolean like = false;

    @SerializedName("linkUrl")
    private String linkUrl = "";

    @SerializedName("linkTitle")
    private String linkTitle = "";

    @SerializedName("linkDescription")
    private String linkDescription = "";

    @SerializedName("linkImage")
    private String linkImage = "";

    private PostStatus status = PostStatus.PUBLISHED;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestContact getUser() {
        return user;
    }

    public void setUser(RestContact user) {
        this.user = user;
    }

    public RestContact getContact() {
        return contact;
    }

    public void setContact(RestContact contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<String> getUsersLike() {
        return usersLike;
    }

    public void setUsersLike(List<String> usersLike) {
        this.usersLike = usersLike;
    }

    public List<String> getUsersShare() {
        return usersShare;
    }

    public void setUsersShare(List<String> usersShare) {
        this.usersShare = usersShare;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public Integer getNumberShares() {
        return numberShares;
    }

    public void setNumberShares(Integer numberShares) {
        this.numberShares = numberShares;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public RestPost getPost() {
        return post;
    }

    public void setPost(RestPost post) {
        this.post = post;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public List<RestSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<RestSkill> skills) {
        this.skills = skills;
    }

    public List<RestRecommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<RestRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public String getTimeByProject() {
        return timeByProject;
    }

    public void setTimeByProject(String timeByProject) {
        this.timeByProject = timeByProject;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public PostType getTypePost() {
        PostType type = PostType.typeFromString(getType());
        if (type == PostType.SHARE) {
            type = PostType.typeFromString(getType() + "_" + getPost().getType());
        }
        return type;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLocation() {
        return (getCity() == null || getCity().isEmpty()) ? ((getCountry() == null || getCountry().isEmpty()) ? null : getCountry()) : getCity() + ", " + getCountry();
    }

    public boolean isShared() {
        return (getTypePost() == PostType.SHARE_TINKER ||
                getTypePost() == PostType.SHARE_LINKER ||
                getTypePost() == PostType.SHARE_RECOMMENDATION ||
                getTypePost() == PostType.SHARE_STATUS ||
                getTypePost() == PostType.SHARE_UPDATEPHOTO ||
                getTypePost() == PostType.SHARE_UPDATEPROFILE);
    }
}
