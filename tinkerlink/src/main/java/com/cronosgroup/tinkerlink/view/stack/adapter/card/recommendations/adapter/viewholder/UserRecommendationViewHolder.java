package com.cronosgroup.tinkerlink.view.stack.adapter.card.recommendations.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 2/8/16.
 */
public class UserRecommendationViewHolder extends BaseViewHolder<RestRecommendation> {

    @BindView(R.id.userTitle)
    protected TLTextView mUserTitle;

    @BindView(R.id.userDescription)
    protected TLTextView mUserDescription;

    @BindView(R.id.recommendationNumber)
    protected TLTextView mRecommendationNumber;

    @BindView(R.id.userImage)
    protected TLImageView mUserImage;

    @BindView(R.id.tabTinkers)
    protected TLTabItem mTabTinkers;

    @BindView(R.id.tabLinkers)
    protected TLTabItem mTabLinkers;

    public UserRecommendationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void configureItem(RestRecommendation item) {
        super.configureItem(item);
    }
}
