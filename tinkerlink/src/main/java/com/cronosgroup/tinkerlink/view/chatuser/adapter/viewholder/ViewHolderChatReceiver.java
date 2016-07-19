package com.cronosgroup.tinkerlink.view.chatuser.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 1/7/16.
 */
public class ViewHolderChatReceiver extends BaseViewHolder<TLMessage> {

    @BindView(R.id.time)
    TLTextView mTime;

    @BindView(R.id.message)
    TLTextView mMessage;

    public ViewHolderChatReceiver(View itemView) {
        super(itemView);
    }

    @Override
    public void configureItem(TLMessage item) {
        super.configureItem(item);
        mTime.setText(DateUtils.getInterval(item.getDate(), itemView.getContext()));
        mMessage.setText(item.getMessage());
    }
}
