package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 7/29/16.
 */
public class TLLinearLayout extends LinearLayout {

    public static final long ANIMATION_TIME = 200;

    public TLLinearLayout(Context context) {
        this(context, null);
    }

    public TLLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void animate(View viewToAnimate, long duration, int animationResource) {
        viewToAnimate.setVisibility(VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(getContext(), animationResource);
        animation.setDuration(duration);
        animation.setInterpolator(new LinearInterpolator());
//        animation.setInterpolator(new BounceInterpolator());
        viewToAnimate.startAnimation(animation);
    }

    private void animateToUp(View viewToAnimate, long duration) {
        animate(viewToAnimate, duration, R.anim.anim_activity_up);
    }

    private void animateToDissmiss(View viewToAnimate, long duration) {
        animate(viewToAnimate, duration, R.anim.anim_activity_down);
    }

    protected void appear(View viewToAnimate) {
        appear(viewToAnimate, ANIMATION_TIME);
    }

    protected void appear(View viewToAnimate, long duration) {
        animateToUp(viewToAnimate, duration);
    }

    protected void dissmiss(View viewToAnimate) {
        dissmiss(viewToAnimate, ANIMATION_TIME);
    }

    protected void dissmiss(View viewToAnimate, long duration) {
        animateToDissmiss(viewToAnimate, duration);
    }
}
