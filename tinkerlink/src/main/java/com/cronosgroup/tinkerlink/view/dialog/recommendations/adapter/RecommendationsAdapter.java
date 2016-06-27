package com.cronosgroup.tinkerlink.view.dialog.recommendations.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.view.dialog.recommendations.adapter.viewholder.ViewHolderRecommendation;

import java.util.List;

/**
 * RecyclerView navigation menu adapter.
 */
public class RecommendationsAdapter extends BaseAdapter<ViewHolderRecommendation, RestRecomendacion> {

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRow = inflater.inflate(R.layout.lay_new_recommendation, parent, false);
        ViewHolderRecommendation viewHolder = new ViewHolderRecommendation(viewRow);
        return viewHolder;
    }

    @Override
    public void configItem(ViewHolderRecommendation holder, int position, boolean isLastItem) {
        holder.configureItem(getItems().get(position));
    }

    @Override
    public List<RestRecomendacion> filterBy(String query) {
        return null;
    }

}
