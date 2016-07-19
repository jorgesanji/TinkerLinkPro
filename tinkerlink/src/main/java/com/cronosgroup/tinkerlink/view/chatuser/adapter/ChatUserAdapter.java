package com.cronosgroup.tinkerlink.view.chatuser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.view.chatuser.adapter.viewholder.ViewHolderChatReceiver;
import com.cronosgroup.tinkerlink.view.chatuser.adapter.viewholder.ViewHolderChatSender;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/19/16.
 */
public class ChatUserAdapter extends BaseAdapter<BaseViewHolder, RestMessage> {

    public static final int SENDER = 1;
    public static final int RECEIVER = 2;

    @Override
    public int getItemViewType(int position) {
//        return getItems().get(position).isMe() ? SENDER : RECEIVER;
        return (position % 2 == 0) ? SENDER : RECEIVER;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {

        BaseViewHolder viewHolder;
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == SENDER) {
            view = inflater.inflate(R.layout.lay_chat_sender, parent, false);
            viewHolder = new ViewHolderChatSender(view);
        } else {
            view = inflater.inflate(R.layout.lay_chat_receiver, parent, false);
            viewHolder = new ViewHolderChatReceiver(view);
        }

        return viewHolder;
    }

    @Override
    public void configItem(BaseViewHolder holder, int position, boolean isLastItem) {
        holder.configureItem(getItem(position));
    }

    @Override
    public List filterBy(String query) {
        return null;
    }

}
