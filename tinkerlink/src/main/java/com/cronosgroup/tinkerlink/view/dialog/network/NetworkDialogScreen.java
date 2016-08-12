package com.cronosgroup.tinkerlink.view.dialog.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.Font;
import com.cronosgroup.tinkerlink.utils.DimenUtils;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLNetworkConnectionView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class NetworkDialogScreen extends TLLinearLayout {

    public interface Listener {
        void onClosePressed();

        void onShowContactsPressed();

        void onLoadTinkerPressed();

        void onLoadLinkerPressed();
    }

    //Properties

    private String userImage;
    private String contactName;
    private String contactImage;
    private String numberCommonContacts;

    //Vars
    private Listener listener;

    //Views

    @BindView(R.id.containerNetwork)
    protected View mContainerNetwork;

    @BindView(R.id.titleNetwork)
    protected TLTextView mTitleNetwork;

    @BindView(R.id.contactsContainer)
    protected View mContactsContainer;

    @BindView(R.id.contactImage)
    protected TLImageView mContactImage;

    @BindView(R.id.contactName)
    protected TLTextView mContactName;

    @BindView(R.id.contactsConnection)
    protected TLNetworkConnectionView mContactsConnection;

    @BindView(R.id.commonContacts)
    protected TLTextView mCommonContacts;

    @BindView(R.id.contactsInfoContainer)
    protected View mContactsInfoContainer;

    @BindView(R.id.contactFriendImage)
    protected TLImageView mContactFriendImage;

    @BindView(R.id.contactFriendName)
    protected TLTextView mContactFriendName;

    @BindView(R.id.contactFriendProffesion)
    protected TLTextView mContactFriendProffesion;

    @BindView(R.id.contactFriendImage2)
    protected TLImageView mContactFriendImag2;

    @BindView(R.id.contactFriendImage3)
    protected TLImageView mContactFriendImag3;

    @BindView(R.id.contactFriendImage4)
    protected TLImageView mContactFriendImag4;

    @BindView(R.id.tinkerNetwork)
    protected TLImageView mTinkerNetwork;

    @BindView(R.id.linkerNetwork)
    protected TLImageView mLinkerNetwork;

    @BindView(R.id.tinkerContainer)
    protected View mTinkerContainer;

    @BindView(R.id.linkerContainer)
    protected View mLinkerContainer;

    @BindView(R.id.tinkerNetworkContainer)
    protected View mTinkerNetworkContainer;

    @BindView(R.id.linkerCategoryContainer)
    protected LinearLayout mLinkerCategoryContainer;

    @BindView(R.id.tinkerCategoryContainer)
    protected LinearLayout mTinkerCategoryContainer;

    @BindView(R.id.currentUserImage)
    protected TLImageView mCurrentUserImage;

    @BindView(R.id.currentUserName)
    protected TLTextView mCurrentUserName;

    @BindView(R.id.progressBar)
    protected ProgressBar mProgressBar;

    @BindView(R.id.loadTinkerCategories)
    protected View mTinkerLoader;

    @BindView(R.id.loadLinkerCategories)
    protected View mLinkerLoader;

    public NetworkDialogScreen(Context context) {
        this(context, null);
    }

    public NetworkDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NetworkDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_network, this);
        ButterKnife.bind(this);
        mContainerNetwork.setVisibility(INVISIBLE);
        if (attributeSet != null) {
        }
    }

    private void validateContainers(View containerNetwork, View container) {
        if (container.getVisibility() == GONE) {
            container.setVisibility(VISIBLE);
        }

        if (containerNetwork.getVisibility() == GONE) {
            containerNetwork.setVisibility(VISIBLE);
        }
    }

    private void addCategoryToContainer(String category, LinearLayout container, int textColor, int background) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DimenUtils.getIntPixelsFromDp(getContext(), 40));
        params.bottomMargin = DimenUtils.getIntPixelsFromDp(getContext(), 10);

        TLTextView categoryView = new TLTextView(getContext());
        categoryView.setText(category);
        categoryView.setGravity(Gravity.CENTER);
        categoryView.setTextColor(getResources().getColor(textColor));
        categoryView.setBackgroundResource(background);
        categoryView.setLayoutParams(params);
        categoryView.setFontName(Font.BOLD.getType());

        //Add container
        container.addView(categoryView);
    }

    // **************  UI Actions **************

    @OnClick(R.id.closeNetwork)
    protected void onClosePressed() {
        if (listener != null) {
            listener.onClosePressed();
        }
    }

    @OnClick(R.id.contactsFriendContainer)
    protected void onContactsPressed() {
        if (listener != null) {
            listener.onShowContactsPressed();
        }
    }

    @OnClick(R.id.loadTinkerCategories)
    protected void onLoadTinkerPressed() {
        if (listener != null) {
            listener.onLoadTinkerPressed();
        }
    }

    @OnClick(R.id.loadLinkerCategories)
    protected void onLoadLinkerPressed() {
        if (listener != null) {
            listener.onLoadLinkerPressed();
        }
    }

    //Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void show() {
        appear(mContainerNetwork);
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
        mCurrentUserImage.setImageFromUrl(userImage);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
        mContactName.setText(contactName);
        mTitleNetwork.setText(String.format(getResources().getString(R.string.network_title_network), contactName));
    }

    public String getContactImage() {
        return contactImage;
    }

    public void setContactImage(String contactImage) {
        this.contactImage = contactImage;
        mContactImage.setImageFromUrl(contactImage);
    }

    public String getNumberCommonContacts() {
        return numberCommonContacts;
    }

    public void setNumberCommonContacts(String numberCommonContacts) {
        this.numberCommonContacts = numberCommonContacts;
        mCommonContacts.setText(getResources().getString(R.string.network_common_contacts) + " (" + numberCommonContacts + ")");
    }

    public void addLinkerCategory(String category) {
        validateContainers(mTinkerNetworkContainer, mLinkerContainer);
        addCategoryToContainer(category, mLinkerCategoryContainer, R.color.linkercolor, R.drawable.background_linker_category);
    }

    public void addTinkerCategory(String category) {
        validateContainers(mTinkerNetworkContainer, mTinkerContainer);
        addCategoryToContainer(category, mTinkerCategoryContainer, R.color.tinkercolor, R.drawable.background_tinker_category);
    }

    public void addContactFriend(String image, String name, String profession) {

        if (mContactsInfoContainer.getVisibility() == GONE) {
            mContactsInfoContainer.setVisibility(VISIBLE);
        }

        if (!mContactsConnection.isConnectionEnable()) {
            mContactsConnection.setConnectionEnable(true);
        }

        if (mContactFriendImage.getVisibility() == GONE && mContactFriendName.getVisibility() == GONE && mContactFriendProffesion.getVisibility() == GONE) {
            mContactFriendImage.setImageFromUrl(image);
            mContactFriendName.setText(name);
            mContactFriendProffesion.setText(profession);
            mContactFriendImage.setVisibility(VISIBLE);
            mContactFriendName.setVisibility(VISIBLE);
            mContactFriendProffesion.setVisibility(profession != null && !profession.isEmpty() ? VISIBLE : GONE);
        } else {
            if (mContactFriendImag2.getVisibility() == GONE) {
                mContactFriendImag2.setImageFromUrl(image);
                mContactFriendImag2.setVisibility(VISIBLE);
            } else if (mContactFriendImag3.getVisibility() == GONE) {
                mContactFriendImag3.setImageFromUrl(image);
                mContactFriendImag3.setVisibility(VISIBLE);
            } else {
                mContactFriendImag4.setImageFromUrl(image);
                mContactFriendImag4.setVisibility(VISIBLE);
            }
        }
    }

    public void removeLoader() {
        mProgressBar.setVisibility(GONE);
    }

    public void showLoader() {
        mProgressBar.setVisibility(VISIBLE);
    }

    public void removeTinkerLoader() {
        mTinkerLoader.setVisibility(GONE);
    }

    public void removeLinkerLoader() {
        mLinkerLoader.setVisibility(GONE);
    }
}