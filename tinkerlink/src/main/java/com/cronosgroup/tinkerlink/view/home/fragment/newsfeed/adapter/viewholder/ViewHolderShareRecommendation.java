package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * row of the recycler view.
 */

public class ViewHolderShareRecommendation extends ViewHolderRecommendation {

    public ViewHolderShareRecommendation(View view) {
        super(view);
    }

    // Public methods
    @Override
    public void configureItem(final RestPost post) {
        setPost(post);
        mTabActions.setVisibility(isMe() ? View.GONE : View.VISIBLE);
        mDividerView.setVisibility(isMe() ? View.GONE : View.VISIBLE);

        RestPost postShared = post.getPost();
        setUserRecommendationAction(post.getUser(), R.string.newsfeed_share_recommendations_text);
        setInfoContact(postShared.getContacto());
        if (postShared.getTexto().isEmpty()) {
            mCardDescription.setVisibility(View.GONE);
        } else {
            mCardDescription.setText(postShared.getTexto());
            mCardDescription.setVisibility(View.VISIBLE);
        }
        mFriendsButton.setText(String.valueOf(postShared.getUser().getUser().getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumeroShares()));
        mViews.setText(String.valueOf(post.getNumeroVisualizaciones()));
    }
}