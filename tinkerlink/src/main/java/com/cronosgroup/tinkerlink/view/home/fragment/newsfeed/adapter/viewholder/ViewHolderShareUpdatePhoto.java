package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * row of the recycler view.
 */

public class ViewHolderShareUpdatePhoto extends ViewHolderUpdatePhoto {

    /**
     * @param view
     */

    public ViewHolderShareUpdatePhoto(View view) {
        super(view);
        mUserName.setVisibility(View.VISIBLE);
        mUserCardImage.setVisibility(View.VISIBLE);
        mUserOcupation.setVisibility(View.VISIBLE);
        mUserLocation.setVisibility(View.VISIBLE);
        mMarginTop.setVisibility(View.VISIBLE);
        mMarginBottom.setVisibility(View.VISIBLE);
        mUserCardImage.setVisibility(View.VISIBLE);
        mUserContainer.hideIcon(true);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        setPost(post);
        setSharedUser(post.getUser(), post.getFecha(), R.string.newsfeed_share_updatephoto_text);
        setOwnerUserPost(post.getPost());
        setImageCard(post.getPost());
        setInfoButtons(post.getPost().getUser().getUser().getRecommendations(), post.getPost().getNumeroShares(), post.getPost().getNumeroVisualizaciones());
    }
}