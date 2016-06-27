package com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.model.EntryItem;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;


/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ViewHolderUser extends BaseViewHolder<EntryItem> {

    @BindView(R.id.suggestionsUserImage)
    TLImageView mUserImage;

    @BindView(R.id.suggestionsUserName)
    TLTextView mSuggestionsUserName;

    @BindView(R.id.suggestionsUserProfession)
    TLTextView mSuggestionsUserProfession;

    @BindView(R.id.addSugestions)
    TLImageButton mAddSugestions;

    @BindView(R.id.userView)
    View mUserView;

    public ViewHolderUser(View itemView) {
        super(itemView);
        mUserView.setBackgroundResource(R.drawable.list_states);
        mUserImage.setRounded(true);
    }

    @Override
    public void configureItem(EntryItem item) {
        super.configureItem(item);
        mUserImage.setImageFromUrl(item.getIcon());
        mSuggestionsUserName.setText(item.getTitle());
        mSuggestionsUserProfession.setText(item.getContacto().getUser().getProfile().getProfession());
        mAddSugestions.setVisibility(View.GONE);
    }

    public void showOrHideSelectedIcon(boolean selected) {
        mAddSugestions.setVisibility(selected ? View.VISIBLE : View.GONE);
    }
}