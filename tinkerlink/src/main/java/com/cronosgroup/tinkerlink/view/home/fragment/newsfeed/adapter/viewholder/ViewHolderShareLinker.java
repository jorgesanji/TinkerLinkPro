package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;

/**
 * row of the recycler view.
 */

public class ViewHolderShareLinker extends ViewHolderLinker {

    /**
     * @param view
     */

    public ViewHolderShareLinker(View view) {
        super(view);
        mUserContainer.setVisibility(View.VISIBLE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        RestPost postShared = post.getPost();
        setUserPostInfo(post.getUser(), R.string.newsfeed_share_linker_text, post.getFecha());
        setInfoCard(postShared, R.string.news_feed_seek, TLImageView.ImageType.LINKER);
        mFriendsButton.setText(String.valueOf(postShared.getUser().getUser().getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumeroShares()));
        mViews.setText(String.valueOf(post.getNumeroVisualizaciones()));
    }
}