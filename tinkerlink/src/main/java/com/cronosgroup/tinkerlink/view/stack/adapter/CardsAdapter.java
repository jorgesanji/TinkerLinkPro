package com.cronosgroup.tinkerlink.view.stack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 8/5/16.
 */
public class CardsAdapter extends BaseAdapter {

    private List<RestPost> items = new ArrayList<>();
    private final Context mContext;

    public CardsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lay_card, parent, false);
        return view;
    }

    public List<RestPost> getItems() {
        return items;
    }

    public void setItems(List<RestPost> items) {
        this.items = items;
    }
}
