package com.cronosgroup.tinkerlink.enums;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/8/16.
 */
public enum ToolBarStyle {

    HOMESTYLE(0, R.layout.layout_base_toolbar_no_elevation_black_items, R.color.white, R.mipmap.icon_app, R.color.tinkercolor),
    DEFAULTSTYLE(1, R.layout.layout_base_toolbar_black_items, R.color.white, 0, R.color.tinkercolor),
    LINKERSTYLE(2, R.layout.layout_base_toolbar_white_items, R.color.linkercolor, 0, R.color.linkercolor),
    TINKERSTYLE(3, R.layout.layout_base_toolbar_white_items, R.color.tinkercolor, 0, R.color.tinkercolor),
    RECOMMENDATIONSSTYLE(4, R.layout.layout_base_toolbar_black_items, R.color.yellow, 0, R.color.yellow),
    WHITEITEMSTYLE(5, R.layout.layout_base_toolbar_white_items, R.color.white, 0, R.color.tinkercolor);

    private final int style;
    private final int backgroundColor;
    private final int icon;
    private final int statusColor;
    private final int layout;

    ToolBarStyle(int style, int layout, int backgroundColor, int icon, int statusColor) {
        this.style = style;
        this.layout = layout;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
        this.statusColor = statusColor;
    }

    public int getIcon() {
        return icon;
    }

    public int getBackgroundColor() {
        return backgroundColor;
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
