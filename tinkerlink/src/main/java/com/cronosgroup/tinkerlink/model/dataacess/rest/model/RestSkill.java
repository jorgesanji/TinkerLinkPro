package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 11/18/15.
 */
public class RestSkill extends RestBase {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    private boolean custom = false;
    private boolean selected = false;

    public String getName() {
        return name;
    }

    public RestSkill setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
