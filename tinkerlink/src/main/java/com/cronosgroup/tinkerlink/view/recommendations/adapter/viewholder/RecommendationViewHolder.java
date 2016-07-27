package com.cronosgroup.tinkerlink.view.recommendations.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class RecommendationViewHolder extends BaseViewHolder<RestRecomendacion> {

    @BindView(R.id.user)
    protected TLUserView mUser;

    @BindView(R.id.recommendationText)
    protected TLTextView mRecommendationText;


    public RecommendationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void configureItem(RestRecomendacion item) {
        super.configureItem(item);
        RestUser restUser = item.getUser().getUser();
        mUser.setTitle(restUser.getName());
        mUser.setSubTitle(restUser.getProfile().getProfession());
        mUser.setUserImageFromUrl(restUser.getPhoto());
        mUser.setTime(item.getCreateDate());
        mRecommendationText.setText(item.getRecomendacion());
    }
}
