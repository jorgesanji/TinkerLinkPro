package com.cronosgroup.tinkerlink.view.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.profile.adapter.ProfileAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Main Profile view.
 */
public class ProfileScreen extends RelativeLayout {

    public interface Listener {


    }


    // Vars
    private Listener listener;
    private ProfileAdapter mAdapter;

    // Views
    @BindView(R.id.userPager)
    protected TLViewPager mPager;

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

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
}