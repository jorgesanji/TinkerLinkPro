package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * row of the recycler view.
 */

public class ViewHolderPost extends ViewHolderPostBase<RestPost> {

    //Vars

    //Views

    @BindView(R.id.containerInfocard)
    public View mContainerInfocard;

    @BindView(R.id.titleSkills)
    public TLTextView mTitleSkills;

    @BindView(R.id.containerSkills)
    public LinearLayout mContainerSkills;

    @BindView(R.id.userContainer)
    public TLUserView mUserContainer;

    @BindView(R.id.containerView)
    public View mContainerView;

    @BindView(R.id.dividerView)
    public View mDividerView;

    @BindView(R.id.iconRecommendations)
    public TLImageView mIconRecomendations;

    @BindView(R.id.cardContentDescription)
    public View mCardContentDescription;

    @BindView(R.id.typeCardTitle)
    public TLTextView mTypeCardTitle;

    @BindView(R.id.linkDescription)
    public TLTextView mLinkDescription;

    @BindView(R.id.link)
    public TLTextView mLink;

    @BindView(R.id.linkTitle)
    public TLTextView mLinkTitle;

    @BindView(R.id.userOcupation)
    public TLTextView mUserOcupation;

    @BindView(R.id.userName)
    public TLTextView mUserName;

    @BindView(R.id.userLocation)
    public TLTextView mUserLocation;

    @BindView(R.id.titleDescription)
    public TLTextView mTitleDescription;

    @BindView(R.id.cardDescription)
    public TLTextView mCardDescription;

    @BindView(R.id.cardShareImage)
    public TLImageView mCardShareImage;

    @BindView(R.id.userCardImage)
    public TLImageView mUserCardImage;

    @BindView(R.id.cardImageType)
    public TLImageView mCardImageType;

    @BindView(R.id.friendsButton)
    public TLTabItem mFriendsButton;

    @BindView(R.id.shareButton)
    public TLTabItem mShareButton;

    @BindView(R.id.views)
    public TLTabItem mViews;

    @BindView(R.id.tabActions)
    public View mTabActions;

    /**
     * @param view
     */
    public ViewHolderPost(View view) {
        super(view);
        mViews.setBackgroundColor(Color.TRANSPARENT);
        mUserCardImage.setRounded(true);
        mCardImageType.setRounded(true);
        mFriendsButton.setIcon(getContext().getResources().getDrawable(R.mipmap.newsfeed_recomendations));
    }

    // Public methods

    @Override
    public void configureItem(RestPost post) {
        super.configureItem(post);
        mCardShareImage.setImageDrawable(null);
        mUserContainer.setUserImageFromUrl(null);
        mUserCardImage.setImageDrawable(null);
        mCardImageType.setImageDrawable(null);
        mTabActions.setVisibility(isMe() ? View.GONE : View.VISIBLE);
        mDividerView.setVisibility(isMe() ? View.GONE : View.VISIBLE);
    }

    @OnClick(R.id.shareButton)
    protected void onSharePressed() {
        if (getActionButtons() != null) {
            getActionButtons().onSharePressed(getAdapterPosition());
        }
    }

    @OnClick(R.id.friendsButton)
    protected void onRecommedationPressed() {
        if (getActionButtons() != null) {
            getActionButtons().onShowRecommendationPressed(getAdapterPosition());
        }
    }
}
