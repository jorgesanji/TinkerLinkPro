package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.mycontacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.view.customviews.TLUserContactView;
import com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.mycontacts.adapter.viewholder.ContactUserViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 8/2/16.
 */
public class MyContactsAdapter extends BaseAdapter<ContactUserViewHolder, RestContacto> {

    public interface Listener {
        void onItemPressed(int position, View view, TLUserContactView.ContactsType type);
    }

    // Vars
    private TLUserContactView.ContactsType type;
    private Listener listener;

    public MyContactsAdapter() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View view = getInflater(parent).inflate(R.layout.lay_contact_item, parent, false);
        ContactUserViewHolder viewHolder = new ContactUserViewHolder(view, getType());
        viewHolder.setClickListener(getClickListener());
        viewHolder.setListener(getListener());
        return viewHolder;
    }

    @Override
    public void configItem(ContactUserViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<RestContacto> filterBy(String query) {
        return null;
    }

    public TLUserContactView.ContactsType getType() {
        return type;
    }

    public void setType(TLUserContactView.ContactsType type) {
        this.type = type;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
