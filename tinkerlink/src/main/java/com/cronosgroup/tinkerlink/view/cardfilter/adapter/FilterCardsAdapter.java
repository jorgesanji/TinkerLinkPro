package com.cronosgroup.tinkerlink.view.cardfilter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.view.cardfilter.adapter.viewholder.FilterViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 8/1/16.
 */
public class FilterCardsAdapter extends BaseAdapter<FilterViewHolder, RestCategory> {

    private StackCardType type;

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View view = getInflater(parent).inflate(R.layout.lay_filter_item, parent, false);
        FilterViewHolder holder = new FilterViewHolder(view);
        holder.setType(getType());
        holder.setClickListener(getClickListener());
        return holder;
    }

    @Override
    public void configItem(FilterViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<RestCategory> filterBy(String query) {
        return null;
    }

    public StackCardType getType() {
        return type;
    }

    public void setType(StackCardType type) {
        this.type = type;
    }
}
