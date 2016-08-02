package com.cronosgroup.tinkerlink.view.home;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLActionButton;
import com.cronosgroup.tinkerlink.view.customviews.TLMenuButton;

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
        void onNewsFeedPresed();

        void onContactsPresed();

        void onMessagesPresed();

        void onProfilePresed();

        void onCreateRecommendationPressed();

        void onCreateTinkerPressed();

        void onCreateLinkerPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.newsfeedbt)
    protected TLActionButton newsfeedbt;

    @BindView(R.id.contactsbt)
    protected TLActionButton contactsbt;

    @BindView(R.id.mensajesbt)
    protected TLActionButton mensajesbt;

    @BindView(R.id.profilebt)
    protected TLActionButton profilebt;

    @BindView(R.id.menuView)
    protected TLMenuButton mMenuView;

    @BindView(R.id.overlayMenu)
    protected View mOverlayMenu;

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
        initUI();
        initListeners();
    }

    private void initUI() {
        mOverlayMenu.setVisibility(GONE);
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
    }

    // **************  UI Actions **************

    @OnClick(R.id.newsfeedbt)
    protected void newsFeedbtPressed() {
        listener.onNewsFeedPresed();
    }

    @OnClick(R.id.contactsbt)
    protected void contactsbtPressed() {
        listener.onContactsPresed();
    }

    @OnClick(R.id.mensajesbt)
    protected void mensajesbtPressed() {
        if (listener != null) {
            listener.onMessagesPresed();
        }
    }

    @OnClick(R.id.profilebt)
    protected void profilebtPressed() {
        if (listener != null) {
            listener.onProfilePresed();
        }
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

    public void setItem(int position) {

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
}