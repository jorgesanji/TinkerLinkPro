package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
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
    private final Context context;

    public CircleBitmapDisplayer() {
        super(0);
        this.alphaAnimation = false;
        this.withBorder = false;
        this.context = null;
    }

    public CircleBitmapDisplayer(boolean alphaAnimation) {
        super(0);
        this.alphaAnimation = alphaAnimation;
        this.withBorder = false;
        this.context = null;
    }

    public CircleBitmapDisplayer(boolean alphaAnimation, boolean withBorder) {
        super(0);
        this.alphaAnimation = alphaAnimation;
        this.withBorder = withBorder;
        this.context = null;
    }

    public CircleBitmapDisplayer(Context context, boolean alphaAnimation, boolean withBorder) {
        super(0);
        this.alphaAnimation = alphaAnimation;
        this.withBorder = withBorder;
        this.context = context;
    }

    @Override
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware != null && !(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }

        int border = DimenUtils.getIntPixelsFromDp(imageAware.getWrappedView().getContext(), 1);

        RoundedBitmapDrawable rounddrawable = RoundedBitmapDrawableFactory.create(context.getResources(), isWithBorder() ? TLBitmapUtils.bitmapWithBorder(bitmap, border) : bitmap);
        rounddrawable.setCircular(true);
        rounddrawable.setAntiAlias(true);

        if (imageAware != null) {
            if (isAlphaAnimation()) {
                imageAware.getWrappedView().setAlpha(0.0f);
            }

            imageAware.setImageDrawable(rounddrawable);

            if (isAlphaAnimation()) {
                imageAware.getWrappedView().animate().alpha(1.0f).start();
            }
        }
    }

    public boolean isAlphaAnimation() {
        return alphaAnimation;
    }

    public boolean isWithBorder() {
        return withBorder;
    }
}
