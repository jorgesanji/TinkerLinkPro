package com.cronosgroup.tinkerlink.enums;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/8/16.
 */
public enum StyleToolBar {

    HOMESTYLE(1, R.layout.layout_base_toolbar_white, R.color.white, R.color.black, R.mipmap.ic_isotipo, R.color.tinkercolor),
    DEFAULTSTYLE(1, R.layout.layout_base_toolbar_black_items, R.color.white, R.color.black, 0, R.color.tinkercolor),
    LINKERSTYLE(2, R.layout.layout_base_toolbar_white_items, R.color.linkercolor, R.color.white, 0, R.color.linkercolor),
    TINKERSTYLE(3, R.layout.layout_base_toolbar_white_items, R.color.tinkercolor, R.color.white, 0, R.color.tinkercolor),
    RECOMMENDATIONSSTYLE(4, R.layout.layout_base_toolbar_black_items, R.color.yellow, R.color.black, 0, R.color.yellow),
    WHITEITEMSTYLE(1, R.layout.layout_base_toolbar_white, R.color.white, R.color.black, 0, R.color.tinkercolor);

    private final int style;
    private final int backgroundColor;
    private final int textColor;
    private final int icon;
    private final int statusColor;
    private final int layout;

    StyleToolBar(int style, int layout, int backgroundColor, int textColor, int icon, int statusColor) {
        this.style = style;
        this.layout = layout;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.icon = icon;
        this.statusColor = statusColor;
    }

    public int getIcon() {
        return icon;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getStyle() {
        return style;
    }

    public int getStatusColor() {
        return statusColor;
    }

    public int getLayout() {
        return layout;
    }
}
