package com.cronosgroup.tinkerlink.enums;

/**
 * Created by jorgesanmartin on 8/10/16.
 */
public enum Font {

    REGULAR(0, "OpenSans-Regular.ttf"),
    BOLD(1, "OpenSans-Bold.ttf"),
    LIGTH(2, "OpenSans-Light.ttf"),
    SEMIBOLD(3, "OpenSans-Semibold.ttf");

    private final int type;
    private final String fontName;

    Font(int type, String fontName) {
        this.type = type;
        this.fontName = fontName;
    }

    public int getType() {
        return type;
    }

    public String getFontName() {
        return fontName;
    }
}
