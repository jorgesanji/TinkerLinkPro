package com.cronosgroup.tinkerlink.view.config.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.config.main.adapter.ConfigAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;


/**
 * Main Config view.
 */
public class ConfigScreen extends TLBaseView {

    public interface Listener {


    }

    // Vars
    private Listener listener;
    private ConfigAdapter mAdapter;

    // Views

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    /**
     * @param context
     */
    public ConfigScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ConfigScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ConfigScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ConfigScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_config_account;
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

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager fragmentManager) {
        mAdapter = new ConfigAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }
}