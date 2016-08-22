package com.cronosgroup.tinkerlink.enums;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/2/16.
 */
public enum StackCardType {
    TINKER(0, R.color.tinkercolor, R.string.news_feed_watch_tinkers, R.drawable.background_tinker_category_color_filled, R.drawable.background_tinker_gradient, R.drawable.background_tinker_batge_img),
    LINKER(1, R.color.linkercolor, R.string.news_feed_watch_linkers, R.drawable.background_linker_category_color_filled, R.drawable.background_linker_gradient, R.drawable.background_linker_batge_img);

    private final int stackType;
    private final int stackColor;
    private final int stackTitle;
    private final int stackSelectorColor;
    private final int gradientCard;
    private final int cardType;

    StackCardType(int stackType, int stackColor, int stackTitle, int stackSelectorColor, int gradientCard, int cardType) {
        this.stackType = stackType;
        this.stackColor = stackColor;
        this.stackTitle = stackTitle;
        this.stackSelectorColor = stackSelectorColor;
        this.gradientCard = gradientCard;
        this.cardType = cardType;
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

    public int getCardType() {
        return cardType;
    }

    public int getStackSelectorColor() {
        return stackSelectorColor;
    }

    public int getGradientCard() {
        return gradientCard;
    }
}