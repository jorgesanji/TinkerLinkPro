package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestStudy extends RestBase {

    @SerializedName("escuela")
    private String school = "";

    @SerializedName("curso")
    private String course = "";

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
