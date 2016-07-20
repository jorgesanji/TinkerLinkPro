package com.cronosgroup.tinkerlink.view.home.fragment.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLMenuButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main Profile view.
 */
public class AccountScreen extends RelativeLayout {

    /**
     * listeners of the profile's screen.
     */
    public interface Listener {
        void onEditProfilePressed();

        void onConfigProfilePressed();

        void onWatchProfilePressed();

        void onImTinkerPressed();

        void onSearchTinkerPressed();

        void onCreateRecommendationPressed();

        void onCreateTinkerPressed();

        void onCreateLinkerPressed();
    }


    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.userImage)
    protected TLImageView mUserImage;

    @BindView(R.id.menuView)
    protected TLMenuButton mMenuView;

    @BindView(R.id.viewMenu)
    protected View mViewMenu;

    @BindView(R.id.scrollView)
    protected ScrollView mScrollView;

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
        initUI();
        initListeners();

        mUserImage.setImageFromUrl("http://qsrock.com/wp-content/uploads/2016/04/130699422.jpg");
    }

    private void initUI() {
        mViewMenu.setVisibility(VISIBLE);
    }

    private void initListeners() {
        mViewMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuView.collapseMenu();
                mViewMenu.setVisibility(GONE);
            }
        });

        mMenuView.setListener(new TLMenuButton.IOMenuButtonState() {
            @Override
            public void collapsed() {
                mViewMenu.setVisibility(GONE);
            }

            @Override
            public void expanded() {
                mViewMenu.setVisibility(VISIBLE);
            }
        });
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

    @OnClick(R.id.watchProfile)
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

    @OnClick(R.id.recommendationButton)
    protected void createRecommendationPressed() {
        listener.onCreateRecommendationPressed();
        mMenuView.collapseMenu();
    }

    @OnClick(R.id.tinkerButton)
    protected void createTinkerPressed() {
        listener.onCreateTinkerPressed();
        mMenuView.collapseMenu();
    }

    @OnClick(R.id.linkerButton)
    protected void createLinkerPressed() {
        listener.onCreateLinkerPressed();
        mMenuView.collapseMenu();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}