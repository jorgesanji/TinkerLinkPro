package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userrecommendation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.DimenUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLRecommendationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main  UserRecommendations view.
 */
public class UserRecommendationsScreen extends RelativeLayout {

    public interface Listener {
        void onItemPressed(int position);

        void onShowAllRecommendationsPressed();

        void onGiveRecommendationPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.recommendationsContainer)
    protected LinearLayout mList;

    /**
     * @param context
     */
    public UserRecommendationsScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public UserRecommendationsScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UserRecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserRecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_recommendations_user, this);
        ButterKnife.bind(this);
    }

    // Actions

    @OnClick(R.id.watchRecommendations)
    protected void watchRecommendationsPressed() {
        listener.onShowAllRecommendationsPressed();
    }

    @OnClick(R.id.writteRecommendation)
    protected void writteRecommendationPressed() {
        listener.onGiveRecommendationPressed();
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void addRecommendation(TLRecommendationView view) {
        mList.addView(view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Math.round(DimenUtils.getPixelsFromDp(getContext(), 2)));
        LinearLayout separator = new LinearLayout(getContext());
        separator.setBackgroundResource(R.color.gray);
        separator.setLayoutParams(params);
        mList.addView(separator);

    }
}