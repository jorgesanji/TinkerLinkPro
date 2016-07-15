package com.cronosgroup.tinkerlink.utils;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/**
 * Created by jorgesanmartin on 11/27/15.
 */
public class CircleBitmapDisplayer extends RoundedBitmapDisplayer {

    private final boolean alphaAnimation;
    private final boolean withBorder;

    public CircleBitmapDisplayer() {
        super(0);
        this.alphaAnimation = false;
        this.withBorder = false;
    }

    public CircleBitmapDisplayer(boolean alphaAnimation) {
        super(0);
        this.alphaAnimation = alphaAnimation;
        this.withBorder = false;
    }

    public CircleBitmapDisplayer(boolean alphaAnimation, boolean withBorder) {
        super(0);
        this.alphaAnimation = alphaAnimation;
        this.withBorder = withBorder;
    }

    @Override
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }

        RoundedBitmapDrawable rounddrawable =
                RoundedBitmapDrawableFactory.create(imageAware.getWrappedView().getResources(), isWithBorder() ? TLBitmapUtils.bitmapWithBorder(bitmap) : bitmap);
        rounddrawable.setCircular(true);
        rounddrawable.setAntiAlias(true);

        if (isAlphaAnimation()) {
            imageAware.getWrappedView().setAlpha(0.0f);
        }

        imageAware.setImageDrawable(rounddrawable);

        if (isAlphaAnimation()) {
            imageAware.getWrappedView().animate().alpha(1.0f).start();
        }
    }

    public boolean isAlphaAnimation() {
        return alphaAnimation;
    }

    public boolean isWithBorder() {
        return withBorder;
    }
}
