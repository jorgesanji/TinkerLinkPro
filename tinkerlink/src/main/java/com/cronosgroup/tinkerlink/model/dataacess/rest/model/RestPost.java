package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.tinkerlink.enums.PostStatus;
import com.cronosgroup.tinkerlink.enums.PostType;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by aaronasencio on 12/05/15.
 */
public class RestPost extends RestBase {

    @SerializedName("id")
    private String id = "";

    @SerializedName("user")
    private RestContact user = new RestContact();

    @SerializedName("type")
    private String type = "";

    @SerializedName("date")
    private Date date = null;

    @SerializedName("likes")
    private Integer likes = 0;

    @SerializedName("view")
    private Integer numberOfViews = 0;

    @SerializedName("shares")
    private Integer numberShares = 0;

    @SerializedName("post")
    private RestPost post = null;

    @SerializedName("share")
    private Boolean share = false;

    @SerializedName("like")
    private Boolean like = false;

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

    public RestPost getPost() {
        return post;
    }

    public void setPost(RestPost post) {
        this.post = post;
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

    public boolean isShared() {
        return (getTypePost() == PostType.SHARE_TINKER ||
                getTypePost() == PostType.SHARE_LINKER ||
                getTypePost() == PostType.SHARE_RECOMMENDATION ||
                getTypePost() == PostType.SHARE_STATUS ||
                getTypePost() == PostType.SHARE_UPDATEPHOTO ||
                getTypePost() == PostType.SHARE_UPDATEPROFILE);
    }
}
