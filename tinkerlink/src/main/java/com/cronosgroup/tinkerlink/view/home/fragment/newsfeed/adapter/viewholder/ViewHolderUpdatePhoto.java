package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * row of the recycler view.
 */

public class ViewHolderUpdatePhoto extends ViewHolderPostBase<RestPost> {

    @BindView(R.id.userContainer)
    public TLUserView mUserContainer;

    @BindView(R.id.dividerView)
    public View mDividerView;

    @BindView(R.id.userOcupation)
    public TLTextView mUserOcupation;

    @BindView(R.id.userName)
    public TLTextView mUserName;

    @BindView(R.id.userLocation)
    public TLTextView mUserLocation;

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

    @BindView(R.id.marginBottom)
    public View mMarginBottom;


    /**
     * @param view
     */

    public ViewHolderUpdatePhoto(View view) {
        super(view);
        mMarginBottom.setVisibility(View.GONE);
        mMarginTop.setVisibility(View.GONE);
        mUserName.setVisibility(View.GONE);
        mUserCardImage.setVisibility(View.GONE);
        mUserOcupation.setVisibility(View.GONE);
        mUserLocation.setVisibility(View.GONE);
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
        setSharedUser(post.getUser(), post.getFecha(), R.string.news_feed_update_photo);
        setImageCard(post);
        setInfoButtons(post.getUser().getUser().getRecommendations(), post.getNumeroShares(), post.getNumeroVisualizaciones());
    }

    protected void setSharedUser(final RestContacto contacto, Date date, int title) {
        String userStatus = String.format(getResources().getString(title), contacto.getUser().getName());
        final SpannableString spannableString = new SpannableString(userStatus);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, contacto.getUser().getName().length(), userStatus.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(date, itemView.getContext(), null));
        mUserContainer.setUserImageFromUrl(getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + contacto.getUser().getPhoto());
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(contacto);
            }
        });
    }

    protected void setOwnerUserPost(final RestPost post) {
        final RestUser user = post.getUser().getUser();
        mUserCardImage.setImageFromUrl(getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + user.getPhoto());
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

    protected void setImageCard(final RestPost post) {
        mCardShareImage.setScaleType(ImageView.ScaleType.CENTER);
        mCardShareImage.setImageFromUrl(getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE) + post.getUser().getUser().getPhoto(), new ImageLoadingListener() {
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
    }

    protected void setInfoButtons(int recommendations, int shares, int views) {
        mRecommendations.setText(String.valueOf(recommendations));
        mShareButton.setText(String.valueOf(shares));
        mViews.setText(String.valueOf(views));
    }

}