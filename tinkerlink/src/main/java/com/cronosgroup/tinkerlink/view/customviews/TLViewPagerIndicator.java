package com.cronosgroup.tinkerlink.view.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 19/10/15.
 */
public class TLViewPagerIndicator extends LinearLayout {

    private static final String TAG = TLViewPagerIndicator.class.toString();

    private static final int DEFAULT_SELECTED = 1;
    private static final int DEFAULT_NUMDOTS = 2;
    private static final int DEFAULT_SIZE = 20;
    private static final int MARGIN_INTO_DOTS = 5;

    private int numDots;
    private Drawable imageUnSelectedDot;
    private Drawable imageSelectedDot;
    private int currentSelected;
    private int previusDotSelected = -1;
    private float sizeDot;

    public TLViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public TLViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TLViewPagerIndicator(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);

        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLViewPagerIndicator);
                setSizeDot(attributes.getDimensionPixelSize(R.styleable.TLViewPagerIndicator_sizeDot, DEFAULT_SIZE));
                setNumDots(attributes.getInt(R.styleable.TLViewPagerIndicator_numDots, DEFAULT_NUMDOTS));
                setImageSelectedDot(attributes.getDrawable(R.styleable.TLViewPagerIndicator_imageSelectedDot));
                setImageUnSelectedDot(attributes.getDrawable(R.styleable.TLViewPagerIndicator_imageUnSelectedDot));
                setCurrentSelected(attributes.getInt(R.styleable.TLViewPagerIndicator_currentSelected, DEFAULT_SELECTED));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    private void createDots() {
        if (getNumDots() > 0) {
            for (int dot = 0; dot < getNumDots(); dot++) {
                ImageView dotImage = new ImageView(getContext());
                LayoutParams params = new LayoutParams((int) getSizeDot(), (int) getSizeDot());
                params.setMargins(MARGIN_INTO_DOTS, 0, 0, 0);
                dotImage.setLayoutParams(params);
                addView(dotImage);
            }
        }
    }

    private void updateDots() {
        for (int dot = 0; dot < getChildCount(); dot++) {
            ImageView dotImage = (ImageView) getChildAt(dot);
            LayoutParams params = new LayoutParams((int) getSizeDot(), (int) getSizeDot());
            params.setMargins(MARGIN_INTO_DOTS, 0, 0, 0);
            dotImage.setLayoutParams(params);
            dotImage.setImageDrawable(getImageUnSelectedDot());
        }
        invalidate();
    }

    private void reloadDots() {
        removeAllViews();
        createDots();
        invalidate();
    }

    // Public methods

    public int getNumDots() {
        return numDots;
    }

    public void setNumDots(int numDots) {
        this.numDots = numDots;
        reloadDots();
    }

    public Drawable getImageUnSelectedDot() {
        return imageUnSelectedDot;
    }

    public void setImageUnSelectedDot(Drawable imageUnSelectedDot) {
        this.imageUnSelectedDot = imageUnSelectedDot;
        updateDots();
    }

    public Drawable getImageSelectedDot() {
        return imageSelectedDot;
    }

    public void setImageSelectedDot(Drawable imageSelectedDot) {
        this.imageSelectedDot = imageSelectedDot;
    }

    public int getCurrentSelected() {
        return currentSelected;
    }

    public void setCurrentSelected(int currentSelected) {
        ImageView image = (ImageView) getChildAt(previusDotSelected);
        if (image != null) {
            image.setImageDrawable(getImageUnSelectedDot());
        }
        this.currentSelected = currentSelected;
        this.previusDotSelected = currentSelected;
        image = (ImageView) getChildAt(currentSelected);
        if (image != null) {
            image.setImageDrawable(getImageSelectedDot());

            image.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_button);
            image.startAnimation(animation);
        }
    }

    public float getSizeDot() {
        return sizeDot;
    }

    public void setSizeDot(int sizeDot) {
        this.sizeDot = sizeDot;
//        this.sizeDot = DimentionsUtils.pxToDp(getContext(), sizeDot);
        updateDots();
    }
}
