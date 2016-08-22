package com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;

import butterknife.BindView;
import butterknife.OnClick;

;

/**
 * row of the recycler view.
 */

public class ViewHolderRecommendation extends ViewHolderPostBase {

    @BindView(R.id.userContainer)
    public TLUserView mUserContainer;

    @BindView(R.id.userOcupation)
    public TLTextView mUserOcupation;

    @BindView(R.id.userName)
    public TLTextView mUserName;

    @BindView(R.id.userLocation)
    public TLTextView mUserLocation;

    @BindView(R.id.cardDescription)
    public TLTextView mCardDescription;

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

    @BindView(R.id.dividerView)
    public View mDividerView;

    /**
     * @param view
     */
    public ViewHolderRecommendation(View view) {
        super(view);
        mUserContainer.hideIcon(true);
        mCardImageType.setImageDrawable(getContext().getResources().getDrawable(R.mipmap.ic_recomendation));
        mFriendsButton.setIcon(getContext().getResources().getDrawable(R.mipmap.newsfeed_recomendations));
        mViews.setBackgroundColor(Color.TRANSPARENT);
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

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        mTabActions.setVisibility(isMe() ? View.GONE : View.VISIBLE);
        mDividerView.setVisibility(isMe() ? View.GONE : View.VISIBLE);

        final RestUser contacto = post.getContact().getUser();

        setUserRecommendationAction(post.getUser(), R.string.news_feed_recomendations_to);
        setInfoContact(post.getContact());

        if (post.getText().isEmpty()) {
            mCardDescription.setVisibility(View.GONE);
        } else {
            mCardDescription.setText(post.getText());
            mCardDescription.setVisibility(View.VISIBLE);
        }

        mFriendsButton.setText(String.valueOf(contacto.getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumberShares()));
        mViews.setText(String.valueOf(post.getNumberOfViews()));
    }

    protected void setUserRecommendationAction(final RestContact contacto, int text) {
        String textContat = String.format(getResources().getString(text), contacto.getUser().getName());
        int index = contacto.getUser().getName().length();
        final SpannableString spannableString = new SpannableString(textContat);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, index, textContat.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(contacto);
            }
        });
    }

    protected void setInfoContact(final RestContact contacto) {
        mUserCardImage.setImageFromUrl(contacto.getUser().getPhoto());
        mUserCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(contacto);
            }
        });

        mUserName.setText(contacto.getUser().getName());
        if (contacto.getUser().getProfile().getProfession().isEmpty()) {
            mUserOcupation.setVisibility(View.GONE);
        } else {
            mUserOcupation.setText(contacto.getUser().getProfile().getProfession());
            mUserOcupation.setVisibility(View.VISIBLE);
        }

        if (contacto.getUser().getProfile().getLocation() == null) {
            mUserLocation.setVisibility(View.GONE);
        } else {
            mUserLocation.setText(contacto.getUser().getProfile().getLocation());
            mUserLocation.setVisibility(View.VISIBLE);
        }
    }
}