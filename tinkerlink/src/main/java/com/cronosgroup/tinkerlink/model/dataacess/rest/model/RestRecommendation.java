package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronasencio on 30/7/15.
 */
public class RestRecommendation extends RestBase {

    @SerializedName("id")
    private String id = "";

    @SerializedName("user")
    private RestUser user = new RestUser();

    @SerializedName("date")
    private Date date;

    @SerializedName("text")
    private String text = "";

    @SerializedName("skills")
    private List<String> skills = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestUser getUser() {
        return user;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return date;
    }

    public void setCreateDate(Date createDate) {
        this.date = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
