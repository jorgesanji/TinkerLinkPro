package com.cronosgroup.tinkerlink.view.giverecommendation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * Main  UserRecommendations view.
 */
public class GiveRecommendationsScreen extends RelativeLayout {

    public interface Listener {
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public GiveRecommendationsScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public GiveRecommendationsScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public GiveRecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GiveRecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_give_recommendation, this);
        ButterKnife.bind(this);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}