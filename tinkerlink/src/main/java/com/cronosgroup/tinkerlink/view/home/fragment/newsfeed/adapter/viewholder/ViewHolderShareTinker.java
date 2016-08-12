package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ImageType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * row of the recycler view.
 */

public class ViewHolderShareTinker extends ViewHolderTinker {

    /**
     * @param view
     */

    public ViewHolderShareTinker(View view) {
        super(view);
        mUserContainer.setVisibility(View.VISIBLE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        RestPost postShared = post.getPost();
        setUserPostInfo(post.getUser(), R.string.newsfeed_share_tinker_text, post.getFecha());
        setInfoCard(postShared, R.string.detail_card_user_iam, ImageType.TINKER);
        mFriendsButton.setText(String.valueOf(postShared.getUser().getUser().getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumeroShares()));
        mViews.setText(String.valueOf(post.getNumeroVisualizaciones()));
    }
}