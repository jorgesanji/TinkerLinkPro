package com.cronosgroup.tinkerlink.view.createcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.createcard.adapter.CreateCardAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPagerIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class CreateCardScreen extends RelativeLayout {

    public interface Listener {
        void nextPage(int position);
    }

    // Vars
    private Listener listener;
    private CreateCardAdapter mAdapter;

    // Views
    @BindView(R.id.pager)
    protected TLViewPager mPager;

    @BindView(R.id.pageIndicator)
    protected TLViewPagerIndicator mPageIndicator;

    @BindView(R.id.nextPage)
    protected TLButton nextPage;

    @BindView(R.id.currentPage)
    protected TLTextView mCurrentPage;

    /**
     * @param context
     */
    public CreateCardScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public CreateCardScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CreateCardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public CreateCardScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_create_card, this);
        ButterKnife.bind(this);
        initUI();
        initListeners();
    }

    private void initUI() {
//        nextPage.setEnabled(false);
    }

    private void initListeners() {
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPageIndicator.setCurrentSelected(position);
                mCurrentPage.setText((position + 1) + "/" + mAdapter.getCount());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // Actions

    @OnClick(R.id.nextPage)
    protected void nextPagePressed() {
        listener.nextPage(mPager.getCurrentItem());
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initAdapter(FragmentManager fragmentManager) {
        mAdapter = new CreateCardAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
    }

    public void goToNextPage() {
        if ((mAdapter.getCount() - 1) == mPager.getCurrentItem()) {
            mPager.setCurrentItem(mPager.getCurrentItem() + 1);
        }
    }
}