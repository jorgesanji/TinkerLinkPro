package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;

/**
 * row of the recycler view.
 */

public class ViewHolderLinker extends ViewHolderTinker {

    /**
     * @param view
     */

    public ViewHolderLinker(View view) {
        super(view);
        mContainerView.setBackgroundResource(R.drawable.background_linker_card);
//        mDividerView.setBackgroundColor(itemView.getResources().getColor(R.color.linkercolor));
        mTypeCardTitle.setText(getResources().getString(R.string.card_seek));
    }

    // Public methods
    @Override
    public void configureItem(final RestPost post) {
        setPost(post);
        setInfoCard(post, R.string.news_feed_seek, TLImageView.ImageType.LINKER);
    }
}
