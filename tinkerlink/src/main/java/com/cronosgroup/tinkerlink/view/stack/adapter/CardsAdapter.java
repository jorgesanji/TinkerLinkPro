package com.cronosgroup.tinkerlink.view.stack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.stack.adapter.card.CardScreen;

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
        CardScreen view = (CardScreen)convertView;
        if (view == null) {
            view = (CardScreen)LayoutInflater.from(mContext).inflate(R.layout.lay_card_internal, parent, false);
        }

        view.setUserImageUrl("http://qsrock.com/wp-content/uploads/2016/04/6d43fc_ed0189fbfceb4a0795ddb0ae695f509b.jpg");
        view.setUserName("Jorge Sanmartin");
        view.setUserCardJob("Electricista");
        view.setUserLocation("Barcelona - Spain");

        return view;
    }

    public List<RestPost> getItems() {
        return items;
    }

    public void setItems(List<RestPost> items) {
        this.items = items;
    }

    public void addItems(List<RestPost> list) {
        items.addAll(list);
        notifyDataSetChanged();
    }
}
