package com.cronosgroup.tinkerlink.view.detailcard.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.view.detailcard.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.detailcard.adapter.page.DetailCardFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 8/22/16.
 */
public class DetailStackAdapter extends FragmentStatePagerAdapter {

    private List<TLCard> items = new ArrayList<>();

    private final Context mContext;

    public DetailStackAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = Fragment.instantiate(mContext, DetailCardFragment.class.getName());
        Bundle bundle =  new Bundle();
        bundle.putSerializable(DetailStackActivity.KEY_ITEM, items.get(position));
        fragment.setArguments(bundle);
        return Fragment.instantiate(mContext, DetailCardFragment.class.getName());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public List<TLCard> getItems() {
        return items;
    }

    public void setItems(List<TLCard> items) {
        this.items = items;
    }
}
