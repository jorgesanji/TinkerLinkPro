package com.cronosgroup.tinkerlink.view.dialog.places.adapter;

import android.location.Address;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dialog.places.adapter.viewholder.ViewHolderPlace;

import java.util.List;

/**
 * Created by jorgesanmartin on 11/25/15.
 */
public class PlaceAutoCompleteAdapter extends BaseAdapter<ViewHolderPlace, Address> {

    public PlaceAutoCompleteAdapter() {
        super();
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
