package com.cronosgroup.tinkerlink.view.dialog.places.adapter;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dialog.places.adapter.viewholder.ViewHolderPlace;

import java.io.IOException;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/25/15.
 */
public class PlaceAutoCompleteAdapter extends BaseAdapter<ViewHolderPlace, Address> {
    private static final int DEFAULT_MAX_RESULTS = 10;

    private Geocoder mGeocoder;
    private int maxResults = DEFAULT_MAX_RESULTS;

    public PlaceAutoCompleteAdapter(Context context) {
        super(null, true);
        mGeocoder = new Geocoder(context);
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRow = inflater.inflate(R.layout.lay_item_dialog, parent, false);
        ViewHolderPlace viewHolder = new ViewHolderPlace(viewRow);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(ViewHolderPlace holder, int position, boolean isLastItem) {
        holder.configureItem(getItems().get(position));
    }

    @Override
    public List<Address> filterBy(String query) {
        try {
            return mGeocoder.getFromLocationName(query, maxResults);
        } catch (IOException ex) {
            Log.d("", "");
        }
        return null;
    }


    public static String addFormattAddres(Address address) {
        String formattDescription = address.getCountryName();
        if (address.getLocality() != null) {
            formattDescription = address.getLocality() + ",  " + address.getCountryName();
        }
        return formattDescription;
    }
}
