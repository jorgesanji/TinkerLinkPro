package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLRecommendationView extends TLBaseView {

    @BindView(R.id.user)
    protected TLUserView mUser;

    @BindView(R.id.recommendationText)
    protected TLTextView mRecommendationText;

    public TLRecommendationView(Context context) {
        super(context);
    }

    public TLRecommendationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLRecommendationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLRecommendationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_recommendation_item;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

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
