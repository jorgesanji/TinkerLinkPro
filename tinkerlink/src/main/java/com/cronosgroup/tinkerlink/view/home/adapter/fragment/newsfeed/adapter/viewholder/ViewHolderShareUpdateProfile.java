package com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder;

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

public class ViewHolderShareUpdateProfile extends ViewHolderUpdateProfile {

    /**
     * @param view
     */

    public ViewHolderShareUpdateProfile(View view) {
        super(view);
        mContainerInfocard.setVisibility(View.VISIBLE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        final RestUser user = post.getUser().getUser();
        RestPost postShared = post.getPost();
        configUpdateProfile(postShared);
        String textContat = String.format(getResources().getString(R.string.newsfeed_share_updateprofile_text), user.getName());
        final SpannableString spannableString = new SpannableString(textContat);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, user.getName().length(), textContat.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(post.getDate(), itemView.getContext(), null));
        mUserContainer.setUserImageFromUrl(user.getPhoto());
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        mRecommendations.setText(String.valueOf(postShared.getUser().getUser().getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumberShares()));
        mViews.setText(String.valueOf(post.getNumberOfViews()));
    }


    private void configUpdateProfile(final RestPost post) {

        final RestUser user = post.getUser().getUser();

        mUserCardImage.setImageFromUrl(user.getPhoto());
        mUserCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        mUserName.setText(user.getName());
        if (user.getProfile().getProfession().isEmpty()) {
            mUserOcupation.setVisibility(View.GONE);
        } else {
            mUserOcupation.setText(user.getProfile().getProfession());
            mUserOcupation.setVisibility(View.VISIBLE);
        }

        if (user.getProfile().getLocation() == null) {
            mUserLocation.setVisibility(View.GONE);
        } else {
            mUserLocation.setText(user.getProfile().getLocation());
            mUserLocation.setVisibility(View.VISIBLE);
        }

        if (post.getText().isEmpty()) {
            mCardDescription.setVisibility(View.GONE);
        } else {
            mCardDescription.setText(post.getText());
            mCardDescription.setVisibility(View.VISIBLE);
        }
    }
}