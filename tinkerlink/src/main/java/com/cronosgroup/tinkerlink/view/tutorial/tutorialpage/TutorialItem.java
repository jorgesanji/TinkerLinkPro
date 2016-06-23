package com.cronosgroup.tinkerlink.view.tutorial.tutorialpage;

/**
 * Created by jorgesanmartin on 10/22/15.
 */
public class TutorialItem {
    final private int imageTop;
    final private int imageMidlle;
    final private int imageBottom;
    final private int backgroundImage;

    public TutorialItem(int imageTop, int imageMidlle, int imageBottom, int backgroundColor) {
        this.imageTop = imageTop;
        this.imageMidlle = imageMidlle;
        this.imageBottom = imageBottom;
        this.backgroundImage = backgroundColor;
    }

    public int getImageTop() {
        return imageTop;
    }

    public int getImageMidlle() {
        return imageMidlle;
    }

    public int getImageBottom() {
        return imageBottom;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }
}
