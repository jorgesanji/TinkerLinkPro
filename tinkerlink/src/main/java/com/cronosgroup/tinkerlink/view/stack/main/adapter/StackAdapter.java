package com.cronosgroup.tinkerlink.view.stack.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 6/22/16.
 */
public class StackAdapter extends FragmentStatePagerAdapter {

    private List<RestPost> items;

    public StackAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return new CardFragment();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void setItems(List<RestPost> items) {
        this.items = items;
    }

    public void addItems(List<RestPost> postList) {
        items.addAll(postList);
    }
}
