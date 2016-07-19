package com.cronosgroup.tinkerlink.view.home.fragment.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.view.home.fragment.chat.adapter.viewholder.ViewHolderMessages;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/18/16.
 */
public class ChatAdapter extends BaseAdapter<ViewHolderMessages, RestChat> {

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        View view = getInflater(parent).inflate(R.layout.lay_chat_item, parent, false);
        ViewHolderMessages viewHolder = new ViewHolderMessages(view);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(ViewHolderMessages holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List<RestChat> filterBy(String query) {
        return null;
    }
}
