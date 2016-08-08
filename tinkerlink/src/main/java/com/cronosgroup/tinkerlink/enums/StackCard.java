package com.cronosgroup.tinkerlink.enums;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/2/16.
 */
public enum StackCard {
    LINKER(1, R.color.linkercolor, R.string.news_feed_watch_linkers, R.string.stack_watch_linker, R.drawable.background_linker_category_color_filled),
    TINKER(2, R.color.tinkercolor, R.string.news_feed_watch_tinkers, R.string.stack_watch_tinker, R.drawable.background_tinker_category_color_filled);

    private final int stackType;
    private final int stackColor;
    private final int stackTitle;
    private final int stackTitleAction;
    private final int stackSelectorColor;

    private StackCard(int stackType, int stackColor, int stackTitle, int stackTitleAction, int stackSelectorColor) {
        this.stackType = stackType;
        this.stackColor = stackColor;
        this.stackTitle = stackTitle;
        this.stackTitleAction = stackTitleAction;
        this.stackSelectorColor = stackSelectorColor;
    }

    public int getStackType() {
        return stackType;
    }

    public int getStackColor() {
        return stackColor;
    }

    public int getStackTitle() {
        return stackTitle;
    }

    public int getStackTitleAction() {
        return stackTitleAction;
    }

    public int getStackSelectorColor() {
        return stackSelectorColor;
    }
}