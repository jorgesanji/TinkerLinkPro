package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.adapter.viewholder.ContactUserViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 8/2/16.
 */
public class ContactsUserAdapter extends BaseAdapter<ContactUserViewHolder, RestContacto> {

    public ContactsUserAdapter() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void configItem(ContactUserViewHolder holder, int position, boolean isLastItem) {

    }

    @Override
    public List<RestContacto> filterBy(String query) {
        return null;
    }
}
