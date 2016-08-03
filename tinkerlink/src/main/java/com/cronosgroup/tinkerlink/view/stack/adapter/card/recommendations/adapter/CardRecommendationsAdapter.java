package com.cronosgroup.tinkerlink.view.stack.adapter.card.recommendations.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.view.stack.adapter.card.recommendations.adapter.viewholder.UserRecommendationViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 2/8/16.
 */
public class CardRecommendationsAdapter extends BaseAdapter<UserRecommendationViewHolder, RestRecomendacion> {

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View view = getInflater(parent).inflate(R.layout.lay_card_recommendation_item, parent, false);
        UserRecommendationViewHolder viewHolder = new UserRecommendationViewHolder(view);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(UserRecommendationViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<RestRecomendacion> filterBy(String query) {
        return null;
    }
}
