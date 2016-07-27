package com.cronosgroup.tinkerlink.view.chatuser.adapter.viewholder;

import android.view.View;
import android.widget.ProgressBar;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 1/7/16.
 */
public class ViewHolderChatSender extends BaseViewHolder<TLMessage> {

    @BindView(R.id.time)
    TLTextView mTime;

    @BindView(R.id.message)
    TLTextView mMessage;

    @BindView(R.id.sendedMessage)
    TLImageView mSendedMessage;

    @BindView(R.id.loadMessage)
    ProgressBar mLoadMessage;

    public ViewHolderChatSender(View itemView) {
        super(itemView);
    }

    @Override
    public void configureItem(TLMessage item) {
        super.configureItem(item);
        mTime.setText(DateUtils.getInterval(item.getDate(), itemView.getContext(), null));
        mMessage.setText(item.getMessage());

        mSendedMessage.setVisibility(item.isSended() ? View.VISIBLE : View.GONE);
        mLoadMessage.setVisibility(item.isSended() ? View.GONE : View.VISIBLE);

    }
}
