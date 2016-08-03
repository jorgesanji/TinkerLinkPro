package com.cronosgroup.tinkerlink.view.stack.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;
import com.cronosgroup.tinkerlink.view.stack.adapter.card.CardFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 6/22/16.
 */
public class StackAdapter extends FragmentStatePagerAdapter {

    private List<RestPost> items = new ArrayList<>();
    private StackCard stackType;
    private boolean detail;

    public StackAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, stackType);
//        bundle.putSerializable(CardFragment.CARD, getItems().get(position));
        bundle.putBoolean(CardFragment.SHOW_CARD_DETAIL, isDetail());
        fragment.setArguments(bundle);
        return fragment;
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

    public List<RestPost> getItems() {
        return items;
    }

    public StackCard getStackType() {
        return stackType;
    }

    public void setStackType(StackCard stackType) {
        this.stackType = stackType;
    }

    public boolean isDetail() {
        return detail;
    }

    public void setDetail(boolean detail) {
        this.detail = detail;
    }
}
