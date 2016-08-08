package com.cronosgroup.tinkerlink.view.dialog.country.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.view.dialog.country.adapter.viewholder.ViewHolderRow;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView navigation menu adapter.
 */
public class CountryAdapter extends BaseAdapter<ViewHolderRow, RestCountry> {

    private final Context mContext;

    public CountryAdapter(List<RestCountry> items, Context context) {
        super(items, true);
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRow = inflater.inflate(R.layout.lay_item_dialog, parent, false);
        ViewHolderRow viewHolder = new ViewHolderRow(viewRow);
        viewHolder.setClickListener(getClickListener());

        return viewHolder;
    }

    @Override
    public void configItem(ViewHolderRow holder, int position, boolean isLastItem) {
        holder.configureItem(getItems().get(position));
    }

    @Override
    public List<RestCountry> filterBy(String query) {
        List<RestCountry> countryList = new ArrayList<RestCountry>();
        if (query.length() == 0) {
            getItems().clear();
            countryList = getAllItems();
        } else {
            for (RestCountry country : getAllItems()) {
                if (AppCountryManager.getCurrentNameFromLocale(mContext, country).toLowerCase().contains(query)) {
                    countryList.add(country);
                }
            }
        }

        return countryList;
    }

}
