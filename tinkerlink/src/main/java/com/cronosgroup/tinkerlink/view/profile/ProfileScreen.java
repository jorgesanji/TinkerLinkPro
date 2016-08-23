package com.cronosgroup.tinkerlink.view.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.view.customviews.TLCommonContactsView;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;
import com.cronosgroup.tinkerlink.view.customviews.TLImageRoundBorder;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLStackButton;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.profile.adapter.ProfileAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Profile view.
 */
public class ProfileScreen extends RelativeLayout {

    public interface Listener {
        void onClosePressed();

        void onImTinkerStackPressed();

        void onSearchTinkerStackPressed();
    }

    // Vars
    private Listener listener;
    private ProfileAdapter mAdapter;

    // Views
    @BindView(R.id.userPager)
    protected TLViewPager mPager;

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    @BindView(R.id.appbar)
    protected AppBarLayout mAppbar;

    @BindView(R.id.userNameToolbar)
    protected TLTextView mNameToolBar;

    @BindView(R.id.titleWelcome)
    protected TLTextView mTitleWelcome;

    @BindView(R.id.cardOverlay)
    protected TLImageView mCardOverlay;

    @BindView(R.id.titleCreateProfile)
    protected TLTextView mtTitleCreateProfile;

    @BindView(R.id.userName)
    protected TLTextView muUserName;

    @BindView(R.id.userJob)
    protected TLTextView mUserJob;

    @BindView(R.id.userCountry)
    protected TLTextView mUserCountry;

    @BindView(R.id.profileUserWallImage)
    protected TLImageButton mProfileUserWallImage;

    @BindView(R.id.profileUserImage)
    protected TLImageButton mProfileUserImage;

    @BindView(R.id.imTinkerbt)
    protected TLStackButton mImTinker;

    @BindView(R.id.searchTinkerbt)
    protected TLStackButton mSearchTinkerbt;

    @BindView(R.id.userImage)
    protected TLImageRoundBorder mUserImage;

    @BindView(R.id.contactsView)
    protected TLCommonContactsView mContactsView;

    /**
     * @param context
     */
    public ProfileScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ProfileScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ProfileScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ProfileScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_profile, this);
        ButterKnife.bind(this);
    }

    private void initUI() {

        mCardOverlay.setImageResource(R.mipmap.card_bg_shadow_white);
        mTitleWelcome.setVisibility(GONE);
        mtTitleCreateProfile.setVisibility(GONE);
        mProfileUserWallImage.setVisibility(GONE);
        mProfileUserImage.setVisibility(GONE);

        mTab.setTabTextColors(getResources().getColor(R.color.black_opaque), getResources().getColor(R.color.black_opaque));
        mTab.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        mTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    // Actions

    @OnClick(R.id.closeDialog)
    protected void closePressed() {
        listener.onClosePressed();
    }

    @OnClick(R.id.imTinkerbt)
    protected void imTinkerPressed() {
        listener.onImTinkerStackPressed();
    }

    @OnClick(R.id.searchTinkerbt)
    protected void searchTinkerPressed() {
        listener.onSearchTinkerStackPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager fragmentManager) {
        this.mAdapter = new ProfileAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }

    public void setUserName(String userName) {
        mNameToolBar.setText(userName);
        muUserName.setText(userName);
    }

    public void setUserImage(String userImage) {
        mUserImage.setImageFromUrl(userImage);
    }

    public void setUserJob(String userJob) {
        mUserJob.setText(userJob);
    }

    public void setUserCountry(String userCountry) {
        mUserCountry.setText(userCountry);
    }

    public void setContacts(List<RestContact> contacts) {
        mContactsView.setContacts(contacts);
    }
}