package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;

import butterknife.BindView;

/**
 * row of the recycler view.
 */

public class ViewHolderUpdateProfile extends ViewHolderPostBase<RestPost> {

    @BindView(R.id.userContainer)
    public TLUserView mUserContainer;

    @BindView(R.id.dividerView)
    public View mDividerView;

    @BindView(R.id.userOcupation)
    public TLTextView mUserOcupation;

    @BindView(R.id.userName)
    public TLTextView mUserName;

    @BindView(R.id.cardDescription)
    public TLTextView mCardDescription;

    @BindView(R.id.userLocation)
    public TLTextView mUserLocation;

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

    @BindView(R.id.containerInfocard)
    public View mContainerInfocard;

    /**
     * @param view
     */

    public ViewHolderUpdateProfile(View view) {
        super(view);
        mContainerInfocard.setVisibility(View.GONE);
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        String userStatus = String.format(getResources().getString(R.string.news_feed_update_status), post.getUser().getUser().getName());
        final SpannableString spannableString = new SpannableString(userStatus);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, post.getUser().getUser().getName().length(), userStatus.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(post.getFecha(), getContext(), null));
        mUserContainer.setUserImageFromUrl(getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + post.getUser().getUser().getPhoto());
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                if (getActionButtons() != null) {
                    getActionButtons().onIconProfilePressed(post.getUser());
                }
            }
        });
    }
}