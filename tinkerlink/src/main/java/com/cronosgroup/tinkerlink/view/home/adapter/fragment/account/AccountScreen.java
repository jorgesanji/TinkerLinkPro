package com.cronosgroup.tinkerlink.view.home.adapter.fragment.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Account user view.
 */
public class AccountScreen extends TLBaseView {

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
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public AccountScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public AccountScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public AccountScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_account;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
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