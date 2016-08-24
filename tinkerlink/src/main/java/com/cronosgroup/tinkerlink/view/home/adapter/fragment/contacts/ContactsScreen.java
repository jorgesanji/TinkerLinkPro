package com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.ContactsAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main contacts view.
 */
public class ContactsScreen extends TLBaseView {


    /**
     * listeners of the contacts's screen.
     */
    public interface Listener {
        void onContinuePressed();
    }

    // Vars
    private Listener listener;
    private ContactsAdapter mAdapter;

    // Views

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    @BindView(R.id.introScreen)
    protected View mIntroView;

    /**
     * @param context
     */
    public ContactsScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public ContactsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ContactsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ContactsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_contacts;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    private void initUI() {
        mPager.setDisableSwipe(true);
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

    // **************  UI Actions **************

    @OnClick(R.id.continueButton)
    protected void continuePressed() {
        listener.onContinuePressed();
        mIntroView.setVisibility(GONE);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager fragmentManager) {
        mAdapter = new ContactsAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }
}