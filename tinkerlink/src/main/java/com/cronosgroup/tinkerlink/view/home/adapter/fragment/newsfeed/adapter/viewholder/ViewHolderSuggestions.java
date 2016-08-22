package com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder;

import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.interfaces.IOAddContactListener;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;

import butterknife.BindView;

/**
 * row of the recycler view.
 */

public class ViewHolderSuggestions extends ViewHolderPostBase {

    // Views
    @BindView(R.id.suggestionsTitle)
    TLTextView mSuggestionsTitle;

    @BindView(R.id.suggestionsContainer)
    LinearLayout mSuggestionsContainer;

    /**
     * @param view
     */

    public ViewHolderSuggestions(View view) {
        super(view);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);

        final RestUser user = post.getUser().getUser();

        mSuggestionsContainer.removeAllViews();

        TLUserView userView = new TLUserView(getContext());
        userView.setTitle(user.getName());
        userView.setSubTitle(user.getProfile().getLocation());
        userView.setUserImageFromUrl(user.getPhoto());

        userView.setAddContactListener(new IOAddContactListener() {
            @Override
            public void AddContact() {
                getActionButtons().onAddContactPressed(post);
            }
        });

        userView.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        userView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        mSuggestionsContainer.addView(userView);
    }

}