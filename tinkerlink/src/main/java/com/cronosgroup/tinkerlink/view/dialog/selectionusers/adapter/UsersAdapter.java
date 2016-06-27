package com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.core.view.sectionable.Item;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.model.EntryItem;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter.viewholder.ViewHolderSection;
import com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter.viewholder.ViewHolderUser;

import java.util.ArrayList;
import java.util.List;

/**
 * User Selector adapter.
 */
public class UsersAdapter extends BaseAdapter<BaseViewHolder, Item> {

    private static final int SECTION = 1;
    private static final int ITEM = 2;

    private List<RestUser> itemsSelected = new ArrayList<>();

    public UsersAdapter(List<Item> contacts) {
        super(contacts, true);
    }

    @Override
    public int getItemViewType(int position) {
        return getItems().get(position).isSection() ? SECTION : ITEM;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRow;
        BaseViewHolder holder;
        switch (viewType) {
            case ITEM:
                viewRow = inflater.inflate(R.layout.lay_row_contact, parent, false);
                holder = new ViewHolderUser(viewRow);
                holder.setClickListener(getClickListener());
                break;
            default:
                viewRow = inflater.inflate(R.layout.lay_section_list, parent, false);
                holder = new ViewHolderSection(viewRow);
                break;
        }

        return holder;
    }

    @Override
    public void configItem(BaseViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItems().get(position));
        if (holder instanceof ViewHolderUser) {
            EntryItem item = (EntryItem) getItem(position);
            ((ViewHolderUser) holder).showOrHideSelectedIcon((itemsSelected.contains(item.getContacto().getUser())));
        }
    }

    @Override
    public List<Item> filterBy(String query) {
        List<Item> restUsers = new ArrayList<Item>();
        if (query.length() == 0) {
            getItems().clear();
            restUsers = getAllItems();
        } else {
            for (Item item : getAllItems()) {
                if (item instanceof EntryItem) {
                    EntryItem contacto = (EntryItem) item;
                    if (contacto.getContacto().getUser().getName().toLowerCase().contains(query.toLowerCase())) {
                        restUsers.add(item);
                    }
                }
            }
        }

        return restUsers;
    }

    // Public mehthods

    public void tryItem(int position) {
        EntryItem item = (EntryItem) getItem(position);
        RestUser user = item.getContacto().getUser();
        if (existItem(user)) {
            removeItem(user);
        } else {
            addUser(user);
        }
        notifyItemChanged(position);
    }

    public boolean existItem(RestUser user) {
        return itemsSelected.contains(user);
    }

    public void addUser(RestUser user) {
        itemsSelected.add(user);
    }

    public void removeItem(RestUser user) {
        itemsSelected.add(user);
    }

    public List<RestUser> getUsersSelected() {
        return itemsSelected;
    }

    public void setItemsSelected(List<RestUser> itemsSelected) {
        this.itemsSelected = itemsSelected;
    }
}
