package com.cronosgroup.tinkerlink.view.giverecommendation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

/**
 * Main  UserRecommendations view.
 */
public class GiveRecommendationsScreen extends TLBaseView {

    public interface Listener {
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public GiveRecommendationsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public GiveRecommendationsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public GiveRecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_give_recommendation;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}