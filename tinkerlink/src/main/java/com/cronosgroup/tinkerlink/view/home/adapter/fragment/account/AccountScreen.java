package com.cronosgroup.tinkerlink.view.home.adapter.fragment.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Account user view.
 */
public class AccountScreen extends RelativeLayout {

    /**
     * listeners of the  Account user's screen.
     */
    public interface Listener {
        void onEditProfilePressed();

        void onConfigProfilePressed();

        void onWatchProfilePressed();

        void onImTinkerPressed();

        void onSearchTinkerPressed();
    }


    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.userImage)
    protected TLImageView mUserImage;

    @BindView(R.id.scrollView)
    protected NestedScrollView mScrollView;

    @BindView(R.id.userJob)
    protected TLTextView mUserJob;

    @BindView(R.id.userName)
    protected TLTextView mUserName;

    @BindView(R.id.recommendationNumber)
    protected TLTextView mRecommendationNumber;


    /**
     * @param context
     */
    public AccountScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public AccountScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public AccountScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public AccountScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public AccountScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_account, this);
        ButterKnife.bind(this);
    }


    // **************  UI Actions **************

    @OnClick(R.id.editProfile)
    protected void editProfilePressed() {
        listener.onEditProfilePressed();
    }

    @OnClick(R.id.configAccount)
    protected void configAccountPressed() {
        listener.onConfigProfilePressed();
    }

    @OnClick(R.id.actionWatchProfile)
    protected void watchProfilePressed() {
        listener.onWatchProfilePressed();
    }

    @OnClick(R.id.imTinkerbt)
    protected void imTinkerPressed() {
        listener.onImTinkerPressed();
    }

    @OnClick(R.id.searchTinkerbt)
    protected void searchTinkerPressed() {
        listener.onSearchTinkerPressed();
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setUserName(String userName) {
        mUserName.setText(userName);
    }

    public void setUserJob(String userJob) {
        mUserJob.setText(userJob);
    }

    public void setUserImage(String userImage) {
        mUserImage.setImageFromUrl(userImage);
    }

    public void setUserRecommendationsNumber(String userRecommendationsNumber) {
        mRecommendationNumber.setText(userRecommendationsNumber);
    }
}