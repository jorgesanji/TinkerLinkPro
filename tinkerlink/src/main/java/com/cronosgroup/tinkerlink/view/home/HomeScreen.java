package com.cronosgroup.tinkerlink.view.home;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLActionButton;
import com.cronosgroup.tinkerlink.view.customviews.TLMenuButton;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.home.adapter.HomeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main Home view.
 */
public class HomeScreen extends RelativeLayout {

    /**
     * listeners of the home's screen.
     */
    public interface Listener {

        void onCreateRecommendationPressed();

        void onCreateTinkerPressed();

        void onCreateLinkerPressed();
    }

    // Vars
    private Listener listener;
    private HomeAdapter mAdapter;

    // Views
    @BindView(R.id.newsfeedbt)
    protected TLActionButton newsfeedbt;

    @BindView(R.id.contactsbt)
    protected TLActionButton contactsbt;

    @BindView(R.id.messagesbt)
    protected TLActionButton mensajesbt;

    @BindView(R.id.accountbt)
    protected TLActionButton profilebt;

    @BindView(R.id.menuView)
    protected TLMenuButton mMenuView;

    @BindView(R.id.overlayMenu)
    protected View mOverlayMenu;

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    /**
     * @param context
     */
    public HomeScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public HomeScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public HomeScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public HomeScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public HomeScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_home, this);
        ButterKnife.bind(this);
        initListeners();
        initUI();
    }

    private void initUI() {
        mensajesbt.setActionStatus(true);
        mOverlayMenu.setVisibility(GONE);
        setTabSeleced(MainFragments.NEWSFEED.ordinal());
    }

    private void hideMenu(boolean hide) {
        mMenuView.setVisibility(hide ? GONE : VISIBLE);
    }

    private void initListeners() {
        mOverlayMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuView.collapseMenu();
                mOverlayMenu.setVisibility(GONE);
            }
        });

        mMenuView.setListener(new TLMenuButton.IOMenuButtonState() {
            @Override
            public void collapsed() {
                mOverlayMenu.setVisibility(GONE);
            }

            @Override
            public void expanded() {
                mOverlayMenu.setVisibility(VISIBLE);
            }
        });

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setTabSeleced(int position) {
        newsfeedbt.setSelected(false);
        contactsbt.setSelected(false);
        mensajesbt.setSelected(false);
        profilebt.setSelected(false);
        hideMenu();

        switch (position) {
            case 0:
                newsfeedbt.setSelected(true);
                showMenu();
                break;
            case 1:
                contactsbt.setSelected(true);
                mOverlayMenu.setVisibility(GONE);
                break;
            case 2:
                mensajesbt.setSelected(true);
                mOverlayMenu.setVisibility(GONE);
                break;
            case 3:
                profilebt.setSelected(true);
                showMenu();
                break;
        }
    }

    private void hideMenu() {
        hideMenu(true);
    }

    private void showMenu() {
        hideMenu(false);
    }

    // **************  UI Actions **************

    @OnClick(R.id.newsfeedbt)
    protected void newsFeedbtPressed() {
        setPageSelected(MainFragments.NEWSFEED.ordinal());
    }

    @OnClick(R.id.contactsbt)
    protected void contactsbtPressed() {
        setPageSelected(MainFragments.CONTACTS.ordinal());
    }

    @OnClick(R.id.messagesbt)
    protected void messagesPressed() {
        setPageSelected(MainFragments.CHAT.ordinal());
    }

    @OnClick(R.id.accountbt)
    protected void accountPressed() {
        setPageSelected(MainFragments.ACCOUNT.ordinal());
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

    public void initAdapter(FragmentManager manager) {
        mAdapter = new HomeAdapter(manager, getContext());
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(mAdapter.getCount());
    }

    public void setPageSelected(int position) {
        mPager.setCurrentItem(position, true);
        setTabSeleced(position);
    }

    public boolean isFirstPage() {
        return mPager.getCurrentItem() == 0;
    }
}