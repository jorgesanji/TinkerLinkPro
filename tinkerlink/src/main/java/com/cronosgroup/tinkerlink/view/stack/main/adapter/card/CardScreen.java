package com.cronosgroup.tinkerlink.view.stack.main.adapter.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main contacts view.
 */
public class CardScreen extends LinearLayout {


    /**
     * listeners of the Card's screen.
     */
    public interface Listener {
        void showDetailPressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public CardScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public CardScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public CardScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public CardScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_card, this);
        ButterKnife.bind(this);
    }

    // **************  UI Actions **************

    @OnClick(R.id.test)
    protected void showDetailPressed() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bounce);
        startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                listener.showDetailPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}