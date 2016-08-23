package com.cronosgroup.tinkerlink.view.tutorial.adapter;

/**
 * Created by jorgesanmartin on 8/23/16.
 */
public class TutoriaItem {

    private int backgroundHeader;
    private int imageHeader;
    private String nameHeader;
    private String typeHeader;
    private String jobHeader;
    private String title;
    private String subTitle;
    private String description;

    public TutoriaItem(int backgroundHeader, int imageHeader, String nameHeader, String typeHeader, String jobHeader, String title, String subTitle, String description) {
        this.backgroundHeader = backgroundHeader;
        this.imageHeader = imageHeader;
        this.nameHeader = nameHeader;
        this.typeHeader = typeHeader;
        this.jobHeader = jobHeader;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
    }

    public int getBackgroundHeader() {
        return backgroundHeader;
    }

    public void setBackgroundHeader(int backgroundHeader) {
        this.backgroundHeader = backgroundHeader;
    }

    public int getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(int imageHeader) {
        this.imageHeader = imageHeader;
    }

    public String getNameHeader() {
        return nameHeader;
    }

    public void setNameHeader(String nameHeader) {
        this.nameHeader = nameHeader;
    }

    public String getTypeHeader() {
        return typeHeader;
    }

    public void setTypeHeader(String typeHeader) {
        this.typeHeader = typeHeader;
    }

    public String getJobHeader() {
        return jobHeader;
    }

    public void setJobHeader(String jobHeader) {
        this.jobHeader = jobHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
