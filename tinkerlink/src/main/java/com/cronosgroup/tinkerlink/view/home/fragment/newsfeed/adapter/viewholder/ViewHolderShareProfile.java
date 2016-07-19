package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.interfaces.IOIconListener;

/**
 * row of the recycler view.
 */

public class ViewHolderShareProfile extends ViewHolderPost {

    /**
     * @param view
     */

    public ViewHolderShareProfile(View view) {
        super(view);
        mTitleSkills.setVisibility(View.GONE);
        mContainerSkills.setVisibility(View.GONE);
        mIconRecomendations.setVisibility(View.GONE);
        mCardShareImage.setVisibility(View.GONE);
        mCardImageType.setVisibility(View.GONE);
        mTypeCardTitle.setVisibility(View.GONE);
        mIconRecomendations.setVisibility(View.GONE);
        mCardDescription.setVisibility(View.GONE);
        mTypeCardTitle.setText(getResources().getString(R.string.card_me));
        mUserContainer.hideIcon(true);
        mLinkTitle.setVisibility(View.GONE);
        mLinkDescription.setVisibility(View.GONE);
        mLink.setVisibility(View.GONE);
    }

    // Public methods
    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);

        final RestUser contacto = post.getContacto().getUser();
        final RestUser usuario = post.getUser().getUser();

        String textContat = String.format(getResources().getString(R.string.news_feed_share_profile), usuario.getName(), contacto.getName());
        final SpannableString spannableString = new SpannableString(textContat);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, usuario.getName().length(), textContat.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        mUserCardImage.setImageFromUrl(getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + contacto.getPhoto());
        mUserCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(post.getContacto());
            }
        });

        mUserName.setText(contacto.getName());
        if (contacto.getProfile().getProfession().isEmpty()) {
            mUserOcupation.setVisibility(View.GONE);
        } else {
            mUserOcupation.setText(contacto.getProfile().getProfession());
            mUserOcupation.setVisibility(View.VISIBLE);
        }

        if (contacto.getProfile().getLocation() == null) {
            mUserLocation.setVisibility(View.GONE);
        } else {
            mUserLocation.setText(contacto.getProfile().getLocation());
            mUserLocation.setVisibility(View.VISIBLE);
        }

        if (post.getTexto().isEmpty()) {
            mCardDescription.setVisibility(View.GONE);
            mTitleDescription.setVisibility(View.GONE);
        } else {
            mCardDescription.setText(post.getTexto());
            mTitleDescription.setVisibility(View.VISIBLE);
        }

        mFriendsButton.setText(String.valueOf(contacto.getProfile().getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumeroShares()));
        mViews.setText(String.valueOf(post.getNumeroVisualizaciones()));
    }
}