package com.cronosgroup.tinkerlink.enums;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/11/16.
 */
public enum ImageType {
    DEFAULT(0, R.mipmap.placeholder, R.mipmap.placeholder),
    USER(1, R.mipmap.newsfeed_avatar_hombre, R.mipmap.newsfeed_avatar_hombre),
    UPDATEPROFILE(2, R.mipmap.newsfeed_photo_nomostrar, R.mipmap.newsfeed_photo_nomostrar),
    TINKER(3, R.mipmap.tinkercard_noicon, R.mipmap.tinkercard_noicon),
    LINKER(4, R.mipmap.linkercard_noicon, R.mipmap.linkercard_noicon),
    NONE(5, -1, -1);

    private final int type;
    private final int errorResource;
    private final int emptyUriResource;

    ImageType(int type, int resource, int emptyUri) {
        this.type = type;
        this.errorResource = resource;
        this.emptyUriResource = emptyUri;
    }

    public int getType() {
        return type;
    }

    public int getErrorResource() {
        return errorResource;
    }

    public int getEmptyUriResource() {
        return emptyUriResource;
    }

    public static ImageType getImageTypeFromType(int type) {
        if (type == USER.getType()) {
            return USER;
        } else if (type == UPDATEPROFILE.getType()) {
            return UPDATEPROFILE;
        } else if (type == DEFAULT.getType()) {
            return DEFAULT;
        } else {
            return NONE;
        }
    }
}