package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * row of the recycler view.
 */

public class ViewHolderShareStatus extends ViewHolderStatus {

    /**
     * @param view
     */

    public ViewHolderShareStatus(View view) {
        super(view);
        mUserCardImage.setVisibility(View.VISIBLE);
        mUserName.setVisibility(View.VISIBLE);
        mUserContainer.hideIcon(true);
        mMarginTop.setVisibility(View.VISIBLE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        setPost(post);
        RestPost postShared = post.getPost();
        setSharedUser(post.getUser(), post.getDate(), R.string.newsfeed_share_status_text);
        setOwnerUserPost(postShared);
        setPostInfo(postShared);
        setInfoButtons(postShared.getUser().getUser().getRecommendations(), postShared.getNumberShares(), postShared.getNumberOfViews());
    }
}