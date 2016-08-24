package com.cronosgroup.tinkerlink.view.searchnewsfeed;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.SearchNewsFeedAdapter;

import butterknife.BindView;

/**
 * DetailStack view.
 */
public class SearchNewsFeedScreen extends TLBaseView {

    /**
     * listeners of the detailstack's screen.
     */
    public interface Listener {


    }

    // Vars
    private Listener listener;
    private SearchNewsFeedAdapter mAdapter;

    // Views

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    /**
     * @param context
     */
    public SearchNewsFeedScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public SearchNewsFeedScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SearchNewsFeedScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SearchNewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SearchNewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_search_newsfeed;
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

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager fragmentManager) {
        mAdapter = new SearchNewsFeedAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }


}