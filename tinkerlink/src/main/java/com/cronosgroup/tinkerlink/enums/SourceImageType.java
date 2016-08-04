package com.cronosgroup.tinkerlink.enums;

/**
 * Created by jorgesanmartin on 8/4/16.
 */
public enum SourceImageType {
    CAMERA(0),
    GALLERY(1);

    private final int id;

    SourceImageType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
