package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLRecommendationView extends LinearLayout {

    @BindView(R.id.user)
    protected TLUserView mUser;

    @BindView(R.id.recommendationText)
    protected TLTextView mRecommendationText;

    public TLRecommendationView(Context context) {
        this(context, null);
    }

    public TLRecommendationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLRecommendationView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLRecommendationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_recommendation_item, this);
        ButterKnife.bind(this);
    }

    // Public methods

    public void setUserName(String userName) {
        mUser.setTitle(userName);
    }

    public void setJob(String job) {
        mUser.setSubTitle(job);
    }

    public void setTime(String time) {
        mUser.setTime(time);
    }

    public void setRecommendation(String recommendation) {
        mRecommendationText.setText(recommendation);
    }
}
