package com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ImageType;
import com.cronosgroup.tinkerlink.interfaces.IOIconListener;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTabItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * row of the recycler view.
 */

public class ViewHolderTinker extends ViewHolderPostBase<RestPost> {

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

//    @BindView(R.id.dividerView)
//    public View mDividerView;

    @BindView(R.id.typeCardTitle)
    public TLTextView mTypeCardTitle;

    @BindView(R.id.containerView)
    public View mContainerView;

    /**
     * @param view
     */

    public ViewHolderTinker(View view) {
        super(view);
        mUserContainer.hideIcon(true);
        mUserContainer.setVisibility(View.GONE);
//        mContainerView.setBackgroundResource(R.drawable.background_tinker_card);
//        mDividerView.setBackgroundColor(itemView.getResources().getColor(R.color.tinkercolor));
        mFriendsButton.setIcon(getContext().getResources().getDrawable(R.mipmap.newsfeed_recomendations));
        mTypeCardTitle.setText(getResources().getString(R.string.detail_card_me));
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

    protected void setInfoCard(final RestPost post, int title, ImageType imageType) {
        final RestUser user = post.getUser().getUser();

        mUserCardImage.setImageFromUrl(user.getPhoto(), ImageType.USER);
        mUserCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActionButtons().onIconProfilePressed(post.getUser());
            }
        });

        String urlImageType = "";
        mCardImageType.setImageFromUrl(urlImageType, imageType);
        mCardImageType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcLickListener().onItemSelected(getAdapterPosition());
            }
        });

        mUserName.setText(user.getName());
//        mUserOcupation.setText(post.getProfession().toUpperCase());
//        mUserLocation.setText(post.getLocation());
//        String description = String.format(getResources().getString(title), post.getProfession() + " " + post.getTimeByProject().toLowerCase());
//        mCardDescription.setText(description);
        mFriendsButton.setText(String.valueOf(user.getRecommendations()));
        mShareButton.setText(String.valueOf(post.getNumberShares()));
        mViews.setText(String.valueOf(post.getNumberOfViews()));
    }


    protected void setUserPostInfo(final RestContact contacto, int message, Date fecha) {
        String textContat = String.format(getResources().getString(message), contacto.getUser().getName());
        final SpannableString spannableString = new SpannableString(textContat);
        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.news_feed_detail_info));
        spannableString.setSpan(color, contacto.getUser().getName().length(), textContat.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserContainer.setTitle(spannableString);
        mUserContainer.setSubTitle(DateUtils.getInterval(fecha, itemView.getContext(), null));
        mUserContainer.setListener(new IOIconListener() {
            @Override
            public void onIconPressed() {
                getActionButtons().onIconProfilePressed(contacto);
            }
        });
    }

    // Public methods

    @Override
    public void configureItem(final RestPost post) {
        super.configureItem(post);
        setInfoCard(post, R.string.detail_card_user_iam, ImageType.TINKER);
    }
}