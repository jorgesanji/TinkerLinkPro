package com.cronosgroup.tinkerlink.view.usercontacts;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.usercontacts.adapter.UserContactsAdapter;

import butterknife.BindView;

/**
 * Main  UserContacs view.
 */
public class UserContactsScreen extends TLBaseView {

    public interface Listener {
    }

    // Vars
    private Listener listener;
    private UserContactsAdapter mAdapter;

    // Views
    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    /**
     * @param context
     */
    public UserContactsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public UserContactsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UserContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserContactsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_user_contacts;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    private void initUI() {
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


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager fragmentManager) {
        mAdapter = new UserContactsAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }

}