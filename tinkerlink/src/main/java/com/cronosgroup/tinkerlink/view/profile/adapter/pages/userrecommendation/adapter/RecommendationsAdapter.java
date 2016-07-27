package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userrecommendation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.view.profile.adapter.pages.userrecommendation.adapter.viewholder.RecommendationViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class RecommendationsAdapter extends BaseAdapter<RecommendationViewHolder, RestRecomendacion> {

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View view = getInflater(parent).inflate(R.layout.lay_recommendation_item, parent, false);
        RecommendationViewHolder viewHolder = new RecommendationViewHolder(view);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(RecommendationViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<RestRecomendacion> filterBy(String query) {
        return null;
    }
}
