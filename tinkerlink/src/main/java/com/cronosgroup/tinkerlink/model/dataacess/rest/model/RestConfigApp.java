package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jorgesanmartin on 11/17/15.
 */
public class RestConfigApp extends RestBase {

    @SerializedName("categories")
    private List<RestCategoria> categories;

    @SerializedName("iconPath")
    private String iconPath;

    @SerializedName("imageGalleryPath")
    private String imageGalleryPath;

    @SerializedName("imageGalleryThumbnailPath")
    private String imageGalleryThumbnailPath;

    @SerializedName("imageProfilePath")
    private String imageProfilePath;

    @SerializedName("imageProfileThumbnailPath")
    private String imageProfileThumbnailPath;

    @SerializedName("imageProfileCroppedPath")
    private String imageProfileCroppedPath;

    @SerializedName("imageProfileCroppedThumbnailPath")
    private String imageProfileCroppedThumbnailPath;

    @SerializedName("imageSharePath")
    private String imageSharePath;

    @SerializedName("supportId")
    private String supportId = "1";

    @SerializedName("privacyPolicyPathES")
    private String privacyPolicyPathES;

    @SerializedName("privacyPolicyPathEN")
    private String privacyPolicyPathEN;


    public List<RestCategoria> getCategories() {
        return categories;
    }

    public void setCategories(List<RestCategoria> categories) {
        this.categories = categories;
    }

    public String getImageGalleryPath() {
        return removeQuoationMarks(imageGalleryPath);
    }

    public void setImageGalleryPath(String imageGalleryPath) {
        this.imageGalleryPath = imageGalleryPath;
    }

    public String getImageGalleryThumbnailPath() {
        return removeQuoationMarks(imageGalleryThumbnailPath);
    }

    public void setImageGalleryThumbnailPath(String imageGalleryThumbnailPath) {
        this.imageGalleryThumbnailPath = imageGalleryThumbnailPath;
    }

    public String getImageProfilePath() {
        return removeQuoationMarks(imageProfilePath);
    }

    public void setImageProfilePath(String imageProfilePath) {
        this.imageProfilePath = imageProfilePath;
    }

    public String getImageProfileThumbnailPath() {
        return removeQuoationMarks(imageProfileThumbnailPath);
    }

    public void setImageProfileThumbnailPath(String imageProfileThumbnailPath) {
        this.imageProfileThumbnailPath = imageProfileThumbnailPath;
    }

    public String getImageProfileCroppedPath() {
        return removeQuoationMarks(imageProfileCroppedPath);
    }

    public void setImageProfileCroppedPath(String imageProfileCroppedPath) {
        this.imageProfileCroppedPath = imageProfileCroppedPath;
    }

    public String getImageProfileCroppedThumbnailPath() {
        return removeQuoationMarks(imageProfileCroppedThumbnailPath);
    }

    public void setImageProfileCroppedThumbnailPath(String imageProfileCroppedThumbnailPath) {
        this.imageProfileCroppedThumbnailPath = imageProfileCroppedThumbnailPath;
    }

    public String getIconPath() {
        return removeQuoationMarks(iconPath);
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getImageSharePath() {
        return imageSharePath;
    }

    public void setImageSharePath(String imageSharePath) {
        this.imageSharePath = imageSharePath;
    }

    public String getSupportId() {
        return supportId;
    }

    public void setSupportId(String supportId) {
        this.supportId = supportId;
    }

    public String getPrivacyPolicyPathES() {
        return privacyPolicyPathES;
    }

    public void setPrivacyPolicyPathES(String privacyPolicyPathES) {
        this.privacyPolicyPathES = privacyPolicyPathES;
    }

    public String getPrivacyPolicyPathEN() {
        return privacyPolicyPathEN;
    }

    public void setPrivacyPolicyPathEN(String privacyPolicyPathEN) {
        this.privacyPolicyPathEN = privacyPolicyPathEN;
    }
}
