package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class TLImageButton extends ImageButton {

    private static final String TAG = ImageButton.class.toString();
    public static final int DEFAULT_FONT = 0;

    /**
     * @param context
     */
    public TLImageButton(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public TLImageButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
    }

    // Public Methods

    public void scaleAnimation() {
        clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_button);
        setAnimation(animation);
    }

}
