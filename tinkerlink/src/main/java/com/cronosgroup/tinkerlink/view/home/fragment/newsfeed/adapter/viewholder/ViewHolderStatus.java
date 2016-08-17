package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * row of the recycler view.
 */

public class ViewHolderStatus extends ViewHolderPostBase<RestPost> {

    @BindView(R.id.userContainer)
    public TLUserView mUserContainer;

    @BindView(R.id.dividerView)
    public View mDividerView;

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

    @BindView(R.id.cardDescription)
    public TLTextView mCardDescription;

    @BindView(R.id.cardShareImage)
    public TLImageView mCardShareImage;

    @BindView(R.id.userCardImage)
    public TLImageView mUserCardImage;

    @BindView(R.id.friendsButton)
    public TLTabItem mRecommendations;

    @BindView(R.id.shareButton)
    public TLTabItem mShareButton;

    @BindView(R.id.views)
    public TLTabItem mViews;

    @BindView(R.id.tabActions)
    public View mTabActions;

    @BindView(R.id.marginTop)
    public View mMarginTop;

    /**
     * @param view
     */

    public ViewHolderStatus(View view) {
        super(view);
        mMarginTop.setVisibility(View.GONE);
        mUserCardImage.setVisibility(View.GONE);
        mUserOcupation.setVisibility(View.GONE);
        mUserLocation.setVisibility(View.GONE);
        mUserName.setVisibility(View.GONE);
        mRecommendations.setVisibility(View.GONE);
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
        setSharedUser(post.getUser(), post.getDate(), R.string.news_feed_ready_status);
        setPostInfo(post);
        setInfoButtons(post.getUser().getUser().getRecommendations(), post.getNumberShares(), post.getNumberOfViews());
    }

    protected void setSharedUser(final RestContact contacto, Date date, int title) {
        String userStatus = String.format(getResources().getString(title), contacto.getUser().getName());
        final SpannableString spannableString = new SpannableString(userStatus);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, contacto.getUser().getName().length(), userStatus.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(date, itemView.getContext(), null));
        mUserContainer.setUserImageFromUrl(contacto.getUser().getPhoto());
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(contacto);
            }
        });
    }

    protected void setOwnerUserPost(final RestPost post) {
        final RestUser user = post.getUser().getUser();
        ImageLoader.getInstance().cancelDisplayTask(mUserCardImage);
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
    }

    protected void setInfoButtons(int recommendations, int shares, int views) {
        mRecommendations.setText(String.valueOf(recommendations));
        mShareButton.setText(String.valueOf(shares));
        mViews.setText(String.valueOf(views));
    }

    protected void setPostInfo(RestPost post) {
        mLinkTitle.setVisibility(View.GONE);
        mLinkDescription.setVisibility(View.GONE);
        mLink.setVisibility(View.GONE);

        String urlImage = "";
        if (!post.getPictures().isEmpty()) {
            urlImage = post.getPictures().get(0);
        } else if (!post.getLinkUrl().isEmpty()) {
            mLinkTitle.setVisibility(View.VISIBLE);
            mLinkDescription.setVisibility(View.VISIBLE);
            mLink.setVisibility(View.VISIBLE);
            urlImage = post.getLinkImage();
            mLinkTitle.setText(post.getLinkTitle());
            mLinkDescription.setText(post.getLinkDescription());
            mLink.setText(post.getLinkUrl());
        }

        if (post.getText().isEmpty()) {
            mCardDescription.setVisibility(View.GONE);
        } else {
            mCardDescription.setVisibility(View.VISIBLE);
            mCardDescription.setText(post.getText());
            Linkify.addLinks(mCardDescription, Linkify.WEB_URLS);
            mCardDescription.setLinkTextColor(getResources().getColor(R.color.tinkercolor));
        }

        if (!urlImage.isEmpty()) {
            mCardShareImage.setVisibility(View.VISIBLE);
            mCardShareImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mCardShareImage.setImageFromUrl(urlImage, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    mCardShareImage.setScaleType(ImageView.ScaleType.CENTER);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    mCardShareImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    mCardShareImage.setScaleType(ImageView.ScaleType.CENTER);
                }
            });

            mCardShareImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActionButtons().onUserImagePressed(getAdapterPosition());
                }
            });

        } else {
            mCardShareImage.setVisibility(View.GONE);
        }
    }
}