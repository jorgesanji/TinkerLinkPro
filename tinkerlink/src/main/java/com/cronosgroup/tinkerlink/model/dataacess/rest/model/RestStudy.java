package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestStudy extends RestBase {

    @SerializedName("school")
    private String school = "";

    @SerializedName("course_name")
    private String courseName = "";

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
