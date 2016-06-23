package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import com.cronosgroup.tinkerlink.R;

import java.lang.reflect.Field;

/**
 * Created by jorgesanmartin on 22/10/15.
 */
public class TLViewPager extends ViewPager {

    private static final String TAG = TLViewPager.class.toString();
    private static final int DEFAULT_DURATION = 1;

    private ScrollerDuration mScroller = null;

    private boolean disableSwipe = false;

    public TLViewPager(Context context) {
        super(context);
        init(null);
    }

    public TLViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.disableSwipe) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!this.disableSwipe) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    private void init(AttributeSet attributeSet) {

        postInitViewPager();

        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLViewPager);
                setScrollDurationFactor(attributes.getFloat(R.styleable.TLViewPager_scrollDuration, DEFAULT_DURATION));
                setDisableSwipe(attributes.getBoolean(R.styleable.TLViewPager_disableSwipe, false));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     */
    private void postInitViewPager() {
        try {
            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);

            mScroller = new ScrollerDuration(getContext(),
                    (Interpolator) interpolator.get(null));
            scroller.set(this, mScroller);
        } catch (Exception e) {
        }
    }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(double scrollFactor) {
        mScroller.setScrollDurationFactor(scrollFactor);
    }

    public boolean isDisableSwipe() {
        return disableSwipe;
    }

    public void setDisableSwipe(boolean disableSwipe) {
        this.disableSwipe = disableSwipe;
    }

    private class ScrollerDuration extends Scroller {

        private double mScrollFactor = 1;

        public ScrollerDuration(Context context) {
            super(context);
        }

        public ScrollerDuration(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @SuppressLint("NewApi")
        public ScrollerDuration(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        /**
         * Set the factor by which the duration will change
         */
        public void setScrollDurationFactor(double scrollFactor) {
            mScrollFactor = scrollFactor;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, (int) (duration * mScrollFactor));
        }
    }
}
