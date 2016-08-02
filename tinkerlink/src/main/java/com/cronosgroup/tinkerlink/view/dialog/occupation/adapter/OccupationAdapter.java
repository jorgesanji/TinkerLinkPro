package com.cronosgroup.tinkerlink.view.dialog.occupation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dialog.occupation.adapter.viewholder.OccupationViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 7/28/16.
 */
public class OccupationAdapter extends BaseAdapter<OccupationViewHolder, String> {

    public OccupationAdapter(List<String> list) {
        super(list, true);
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View viewRow = getInflater(parent).inflate(R.layout.lay_item_dialog, parent, false);
        OccupationViewHolder viewHolder = new OccupationViewHolder(viewRow);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(OccupationViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<String> filterBy(String query) {
        List<String> occupations = new ArrayList<String>();
        if (query.length() == 0) {
            getItems().clear();
            occupations = getAllItems();
        } else {
            for (String item : getAllItems()) {
                if (item.toLowerCase().contains(query.toLowerCase())) {
                    occupations.add(item);
                }

            }
        }
        return occupations;
    }

}
