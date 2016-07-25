package com.cronosgroup.tinkerlink.view.stack.main.adapter.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.view.customviews.TLCommonContactsView;
import com.cronosgroup.tinkerlink.view.customviews.TLSkillView;
import com.cronosgroup.tinkerlink.view.customviews.TLImageRoundBorder;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLScrollView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main contacts view.
 */
public class CardScreen extends RelativeLayout {

    /**
     * listeners of the Card's screen.
     */
    public interface Listener {
        void showDetailPressed();

        void showRecommendationPressed();
    }

    // Vars
    private Listener listener;
    private AppConfigManager appConfigManager;

    // Properties
    private String urlUser;
    private String userName;
    private String userCardJob;
    private String userCardType;
    private String userLocation;
    private List<String> userSkills;
    private List<RestContacto> userCommonContacts;
    private String userCardDescription;
    private int iconContactStatus;
    private int overlayColor;
    private String userNumberRecommendations;

    // Views

    @BindView(R.id.cardBackground)
    TLImageView mCardBackground;

    @BindView(R.id.cardOverlay)
    TLImageView mCardOverlay;

    @BindView(R.id.userCardImage)
    TLImageRoundBorder mUserCardImage;

    @BindView(R.id.userName)
    TLTextView mUserName;

    @BindView(R.id.userCardType)
    TLTextView mUserCardType;

    @BindView(R.id.userJob)
    TLTextView mUserJob;

    @BindView(R.id.userCardLocation)
    TLTextView mUserCardLocation;

    @BindView(R.id.userStatusContact)
    TLImageView mUserStatusContact;

    @BindView(R.id.contactsView)
    TLCommonContactsView mContactsView;

    @BindView(R.id.containerSkills)
    LinearLayout mContainerSkills;

    @BindView(R.id.descriptionTitle)
    TLTextView mDescriptionTitle;

    @BindView(R.id.descriptionText)
    TLTextView mDescriptionText;

    @BindView(R.id.touchView)
    View mTouchView;

    @BindView(R.id.scrollView)
    TLScrollView mScrollView;

    @BindView(R.id.recommendationNumber)
    TLTextView mRecommendationNumber;

    /**
     * @param context
     */
    public CardScreen(Context context, Listener listener, AppConfigManager appConfigManager) {
        this(context);
        this.listener = listener;
        this.appConfigManager = appConfigManager;
    }


    /**
     * @param context
     */
    public CardScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

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
    }

    // **************  UI Actions **************


    @OnClick(R.id.containerRecommendation)
    protected void showRecommendationsPressed() {

    }

    @OnClick(R.id.touchView)
    protected void showDetailPressed() {
        listener.showDetailPressed();
    }

    private void setStatusIcon(int resource) {
        mUserStatusContact.setImageResource(resource);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getUrlUser() {
        return urlUser;
    }

    public void setUrlUser(String urlUser) {
        this.urlUser = urlUser;
        mUserCardImage.setImageUrl(urlUser);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        mUserName.setText(userName);
    }

    public String getUserCardType() {
        return userCardType;
    }

    public void setUserCardType(String userCardType) {
        this.userCardType = userCardType;
        mUserCardType.setText(userCardType);
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
        mUserCardLocation.setText(userLocation);
    }

    public List<String> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<String> userSkills) {
        this.userSkills = userSkills;
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

    public List<RestContacto> getUserCommonContacts() {
        return userCommonContacts;
    }

    public void setUserCommonContacts(List<RestContacto> userCommonContacts) {
        this.userCommonContacts = userCommonContacts;
        mContactsView.setContacts(userCommonContacts, appConfigManager);
    }

    public String getUserCardDescription() {
        return userCardDescription;
    }

    public void setUserCardDescription(String userCardDescription) {
        this.userCardDescription = userCardDescription;
        if (userCardDescription != null && userCardDescription.isEmpty()) {
            mDescriptionText.setText(userCardDescription);
        } else {
            mDescriptionTitle.setVisibility(GONE);
        }
    }

    public int getIconContactStatus() {
        return iconContactStatus;
    }

    public void setIconContactStatus(int iconContactStatus) {
        this.iconContactStatus = iconContactStatus;
        mUserStatusContact.setImageResource(iconContactStatus);
    }

    public String getUserCardJob() {
        return userCardJob;
    }

    public void setUserCardJob(String userCardJob) {
        this.userCardJob = userCardJob;
        mUserJob.setText(userCardJob);
    }

    public int getOverlayColor() {
        return overlayColor;
    }

    public void setOverlayColor(int overlayColor) {
        this.overlayColor = overlayColor;
        mCardOverlay.setImageResource(overlayColor);
    }

    public void showDetail(boolean showDetail) {
        mTouchView.setVisibility(showDetail ? VISIBLE : GONE);
        mScrollView.setScrollingEnabled(!showDetail);
        mScrollView.setVerticalScrollBarEnabled(!showDetail);
        mScrollView.setHorizontalScrollBarEnabled(!showDetail);
    }

    public void setStatus(RestContacto contacto) {
        if (!contacto.getUser().isMe()) {
            if (contacto.isAccepted()) {
                setStatusIcon(R.mipmap.profile_contactoagregado);
            } else if (contacto.meRequestedLikeContact()) {
                setStatusIcon(R.mipmap.profile_solicitudenviada);
            } else if (contacto.wasRequestedToMeLikeContact()) {
                setStatusIcon(R.mipmap.profile_solicitudenviada);
            } else {
                setStatusIcon(R.mipmap.profile_agregarcontacto);
            }
        }
    }

    public String getUserNumberRecommendations() {
        return userNumberRecommendations;
    }

    public void setUserNumberRecommendations(String userNumberRecommendations) {
        this.userNumberRecommendations = userNumberRecommendations;
        mRecommendationNumber.setText(userNumberRecommendations);

    }
}