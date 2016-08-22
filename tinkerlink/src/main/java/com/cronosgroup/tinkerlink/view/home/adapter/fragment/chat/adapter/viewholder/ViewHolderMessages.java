package com.cronosgroup.tinkerlink.view.home.adapter.fragment.chat.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * row of the recycler view.
 */

public class ViewHolderMessages extends BaseViewHolder<RestChat> {

    /**
     * @param view
     */

    @BindView(R.id.backgrondChatItem)
    protected View mBackgrondChatItem;

    @BindView(R.id.userChat)
    protected TLUserView mUserChat;

    public ViewHolderMessages(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    // Public methods

    @Override
    public void configureItem(final RestChat chat) {
        final RestUser user = chat.getUser().getUser();
        mUserChat.setUserImageFromUrl(user.getPhoto());
        mUserChat.setTitle(user.getName());
        mUserChat.setSubTitle(user.getProfile().getProfession());
        mUserChat.setTime("12:40");
        mBackgrondChatItem.setBackgroundColor(getContext().getResources().getColor((getAdapterPosition() % 2 == 0) ? R.color.gray_50 : R.color.white));
    }
}