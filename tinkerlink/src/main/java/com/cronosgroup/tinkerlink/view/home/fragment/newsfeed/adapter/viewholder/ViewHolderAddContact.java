package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.utils.DateUtils;

/**
 * row of the recycler view.
 */

public class ViewHolderAddContact extends ViewHolderPost {

    /**
     * @param view
     */

    public ViewHolderAddContact(View view) {
        super(view);
        mCardShareImage.setVisibility(View.GONE);
        mCardImageType.setVisibility(View.GONE);
        mTypeCardTitle.setVisibility(View.GONE);
        mTitleDescription.setVisibility(View.GONE);
        mIconRecomendations.setVisibility(View.GONE);
        mCardDescription.setVisibility(View.GONE);
        mLinkTitle.setVisibility(View.GONE);
        mLinkDescription.setVisibility(View.GONE);
        mLink.setVisibility(View.GONE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);

        final RestUser contacto = post.getContact().getUser();
        final RestUser user = post.getUser().getUser();

        String newContact = String.format(getResources().getString(R.string.news_feed_sugerencias_new_contacts), user.getName());
        final SpannableString spannableString = new SpannableString(newContact);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, user.getName().length(), newContact.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(post.getDate(), itemView.getContext(), null));
        mUserContainer.setUserImageFromUrl( user.getPhoto());
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        String usuarioUrlImage = contacto.getPhoto();
        mUserCardImage.setImageFromUrl(usuarioUrlImage);
        mUserCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(post.getContact());
            }
        });

        mTypeCardTitle.setText(getResources().getString(R.string.detail_card_me));
        mUserOcupation.setText(contacto.getProfile().getProfession());
        mUserLocation.setText(contacto.getProfile().getLocation());
        mCardDescription.setText(post.getText());
        mTitleDescription.setVisibility(post.getText().isEmpty() ? View.GONE : View.VISIBLE);

        mFriendsButton.setText(String.valueOf(post.getNumberOfViews()));
        mShareButton.setText(String.valueOf(post.getNumberShares()));
        mViews.setText(String.valueOf(post.getNumberOfViews()));

    }
}