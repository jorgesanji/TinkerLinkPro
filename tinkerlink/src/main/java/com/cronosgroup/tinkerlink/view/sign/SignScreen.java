package com.cronosgroup.tinkerlink.view.sign;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPagerIndicator;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.sign.adapter.SignAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main Sing view.
 */
public class SignScreen extends TLBaseView {

    /**
     * listeners of the Sing's screen.
     */

    public interface Listener {
        void verifiedPage(int page);
    }

    // Vars
    private Listener listener;
    private SignAdapter mAdapter;
    private FragmentManager fragmentManager;

    // Views
    @BindView(R.id.signPager)
    protected TLViewPager mPager;

    @BindView(R.id.currentPage)
    protected TLTextView mCurrentPage;

    @BindView(R.id.nextPage)
    protected TLButton mNextButton;

    @BindView(R.id.pageIndicator)
    protected TLViewPagerIndicator mPageIndicator;

    @BindView(R.id.registrationContainer)
    protected FrameLayout mRegistrationContainer;

    /**
     * @param context
     */
    public SignScreen(Context context, FragmentManager fragmentManager) {
        super(context);
        this.fragmentManager = fragmentManager;
    }

    /**
     * @param context
     */
    public SignScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SignScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SignScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SignScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_sign;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
    }

    private void initUI() {
        mPageIndicator.setNumDots(4);
        mPageIndicator.setCurrentSelected(0);
    }

    private void hideContainer(final View container) {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_activity_down);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                container.setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        container.startAnimation(animation);
    }

    private void showContainer(View container) {
        container.setVisibility(VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_activity_up);
        container.startAnimation(animation);
    }

    private boolean removeContainers() {
        if (mRegistrationContainer.getVisibility() == VISIBLE) {
            hideContainer(mRegistrationContainer);
            return true;
        }

        return false;
    }

    // **************  UI Actions **************

    @OnClick(R.id.nextPage)
    protected void onNextStepPressed() {
        listener.verifiedPage(mPager.getCurrentItem());
    }

    // Public Methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initAdapter() {
        mAdapter = new SignAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        mPager.setDisableSwipe(true);
        mPager.setOffscreenPageLimit(1);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage.setText((position + 1) + "/" + mAdapter.getCount());
                mPageIndicator.setCurrentSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public int showNextPage() {
        removeContainers();
        mPager.setCurrentItem(mPager.getCurrentItem() + 1, true);
        return mPager.getCurrentItem();
    }

    public boolean showPreviousPage() {
        if (mPager.getCurrentItem() - 1 >= 0) {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1, true);
            return true;
        }
        return false;
    }

    public boolean removeSocialNetworksPage() {
        return removeContainers();
    }
}