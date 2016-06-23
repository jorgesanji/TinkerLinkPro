package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

/**
 * Created by jorgesanmartin on 11/18/15.
 */
public class RestHabilidad implements Cloneable {
    private String name;
    private boolean custom = false;
    private boolean selected = false;

    public String getName() {
        return name;
    }

    public RestHabilidad setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isCustom() {
        return custom;
    }

    public RestHabilidad setCustom(boolean custom) {
        this.custom = custom;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public RestHabilidad setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
