package com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.view.customviews.TLCommonContactsView;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLScrollView;
import com.cronosgroup.tinkerlink.view.customviews.TLSkillView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.card.TLCardView;
import com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.card.recommendations.CardRecommnedationsScreen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main Card view.
 */
public class CardScreen extends TLLinearLayout implements TLCardView {

    public static final String TAG_SCREEN = "screen";

    // Views

    @BindView(R.id.cardBackground)
    protected TLImageView mCardBackground;

    @BindView(R.id.cardOverlay)
    protected TLImageView mCardOverlay;

    @BindView(R.id.userCardImage)
    protected TLImageView mUserCardImage;

    @BindView(R.id.userName)
    protected TLTextView mUserName;

    @BindView(R.id.userCardType)
    protected TLTextView mUserCardType;

    @BindView(R.id.userJob)
    protected TLTextView mUserJob;

    @BindView(R.id.userCardLocation)
    protected TLTextView mUserCardLocation;

    @BindView(R.id.userStatusContact)
    protected TLImageView mUserStatusContact;

    @BindView(R.id.contactsView)
    protected TLCommonContactsView mContactsView;

    @BindView(R.id.containerSkills)
    protected LinearLayout mContainerSkills;

    @BindView(R.id.descriptionTitle)
    protected TLTextView mDescriptionTitle;

    @BindView(R.id.descriptionText)
    protected TLTextView mDescriptionText;

    @BindView(R.id.touchView)
    protected View mTouchView;

    @BindView(R.id.scrollView)
    protected TLScrollView mScrollView;

    @BindView(R.id.recommendationNumber)
    protected TLTextView mRecommendationNumber;

    @BindView(R.id.recommendationContainer)
    protected View mRecommendationContainer;

    @BindView(R.id.cardRecommendations)
    protected CardRecommnedationsScreen mCardRecommnedationsScreen;

    @BindView(R.id.containerRecommendation)
    protected View mRecommendationsButton;

    @BindView(R.id.cardGradient)
    protected TLImageView mGradient;

    @BindView(R.id.imageContainer)
    protected View mImageContainer;

    @BindView(R.id.cardType)
    protected TLImageView mcardType;

    /**
     * @param context
     */
    public CardScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public CardScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CardScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_card, this);
        ButterKnife.bind(this);
        mImageContainer.setTag(TAG_SCREEN);
        mCardOverlay.setImageResource(R.mipmap.card_bg_shadow_white);

    }

    // **************  UI Actions **************

    @OnClick(R.id.containerRecommendation)
    protected void showRecommendationsPressed() {
        appear(mRecommendationContainer);
        mRecommendationsButton.setVisibility(INVISIBLE);
    }

    @OnClick(R.id.closeRecommendations)
    protected void closeRecommendationsPressed() {
        dissmiss(mRecommendationContainer);
        mRecommendationsButton.setVisibility(VISIBLE);
    }

    // Public methods

    public void setCardType(int type) {
        mcardType.setImageResource(type);
    }

    public void setStyleByStackType(int gradient) {
        mGradient.setImageResource(gradient);
    }

    public void setUserImageUrl(String urlUser) {
        mUserCardImage.setImageFromUrl(urlUser);
    }

    public void setUserName(String userName) {
        mUserName.setText(userName);
    }

    public void setUserCardType(String userCardType) {
        mUserCardType.setText(userCardType);
    }

    public void setUserLocation(String userLocation) {
        mUserCardLocation.setText(userLocation);
    }

    public void setUserSkills(List<String> userSkills) {
        if (userSkills != null && userSkills.size() > 0) {
            for (String habilidad : userSkills) {
                TLSkillView view = new TLSkillView(getContext());
                view.setTitleText(habilidad);
                view.setEnabled(false);
                view.setChecked(true);
                mContainerSkills.addView(view);
            }
        }
    }

    public void setUserCommonContacts(List<RestContact> userCommonContacts) {
        mContactsView.setContacts(userCommonContacts);
    }

    public void setUserCardDescription(String userCardDescription) {
        if (userCardDescription != null && userCardDescription.isEmpty()) {
            mDescriptionText.setText(userCardDescription);
        } else {
            mDescriptionTitle.setVisibility(GONE);
        }
    }

    public void setIconContactStatus(int iconContactStatus) {
        mUserStatusContact.setImageResource(iconContactStatus);
    }

    public void setUserCardJob(String userCardJob) {
        mUserJob.setText(userCardJob);
    }

    public void showDetail(boolean showDetail) {
        mTouchView.setVisibility(showDetail ? VISIBLE : GONE);
        mScrollView.setScrollingEnabled(!showDetail);
        mScrollView.setVerticalScrollBarEnabled(!showDetail);
        mScrollView.setHorizontalScrollBarEnabled(!showDetail);
    }

    public void setStatus(RestContact contacto) {
        if (!contacto.getUser().isMe()) {
            if (contacto.isAccepted()) {
                mUserStatusContact.setImageResource(R.mipmap.ic_contact);
            } else if (contacto.meRequestedLikeContact()) {
                mUserStatusContact.setImageResource(R.mipmap.ic_contact_sent);
            } else if (contacto.wasRequestedToMeLikeContact()) {
                mUserStatusContact.setImageResource(R.mipmap.ic_contact_accept);
            } else {
                mUserStatusContact.setImageResource(R.mipmap.ic_contact_add);
            }
        }
    }

    public void setUserNumberRecommendations(String userNumberRecommendations) {
        mRecommendationNumber.setText(userNumberRecommendations);
    }

    public void setRecommendationItems(List<RestRecommendation> list) {
        mCardRecommnedationsScreen.setItems(list);
    }

    @Override
    public View getViewForDrag() {
        return mImageContainer;
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void showCardType() {
        mcardType.setVisibility(VISIBLE);
    }

    @Override
    public void hideCardType() {
        mcardType.setVisibility(GONE);
    }
}