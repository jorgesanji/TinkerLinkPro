package com.cronosgroup.tinkerlink.view.tutorial.tutorialpage;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 20/10/15.
 */
public class TutorialPage extends RelativeLayout {

    // VARS
    private int imageTop;
    private int imageBottom;
    private int imageBackground;

    // Views
    @BindView(R.id.imageBackground)
    TLImageView mImageBackground;

    @BindView(R.id.imageTop)
    TLImageView mImageTop;

    @BindView(R.id.imageBottom)
    TLImageView mImageBottom;

    /**
     * @param context
     */
    public TutorialPage(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public TutorialPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TutorialPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TutorialPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_tutorial_page, this);
        ButterKnife.bind(this);
        mImageBottom.setVisibility(GONE);
    }

    // Public methods

    public int getImageTop() {
        return imageTop;
    }

    public void setImageTop(int imageTop) {
        this.imageTop = imageTop;
        mImageTop.setImageResource(imageTop);
    }

    public int getImageBottom() {
        return imageBottom;
    }

    public void setImageBottom(int imageBottom) {
        this.imageBottom = imageBottom;
        mImageBottom.setVisibility(GONE);
        if (imageBottom != -1){
            mImageBottom.setImageResource(imageBottom);
            mImageBottom.setVisibility(VISIBLE);
        }
    }

    public int getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(int imageBackground) {
        this.imageBackground = imageBackground;
        mImageBackground.setImageResource(imageBackground);
    }

    public void animBackground() {
        mImageBackground.setScaleX(0.5f);
        mImageBackground.setScaleY(0.5f);
        mImageBackground.animate().scaleX(1).scaleY(1).start();
    }
}
