package com.cronosgroup.tinkerlink.view.tutorial;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;
import com.cronosgroup.tinkerlink.view.animation.tutorial.ZoomOutPageTransformer;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPagerIndicator;
import com.cronosgroup.tinkerlink.view.tutorial.adapter.TutorialAdapter;
import com.cronosgroup.tinkerlink.view.tutorial.tutorialpage.TutorialItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Tutorial view.
 */
class TutorialScreen extends RelativeLayout {

    private static final int INTERVAL_TIME = 2500;
    private static final int INTERVAL_BUTTONS_TIME = 800;

    /**
     * listeners of the Tutorial's screen.
     */
    public interface Listener {
        void onStartRegistration();

        boolean isUserLoged();
    }

    // Vars
    private boolean mDisableTouchPager;
    private Listener listener;
    private TutorialAdapter mAdapter;
    private Handler mTimer = new Handler(Looper.myLooper());
    private Runnable mAutomaticScroll = new Runnable() {
        @Override
        public void run() {
            boolean isLastPage = (mPager.getCurrentItem() + 1) < mAdapter.getCount();
            int nPage = (isLastPage) ? mPager.getCurrentItem() + 1 : 0;
            mPager.setCurrentItem(nPage, true);
        }
    };

    // Views
    @BindView(R.id.pager)
    TLViewPager mPager;

    @BindView(R.id.buttonContainer)
    LinearLayout mButtonContainer;

    @BindView(R.id.pageIndicator)
    TLViewPagerIndicator mPageIndicator;

    /**
     * @param context
     */
    public TutorialScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public TutorialScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TutorialScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public TutorialScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_tutorial, this);
        ButterKnife.bind(this);
        initUI();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        mDisableTouchPager = true;
        mButtonContainer.setAlpha(0.0f);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    private void initAdapter() {
        List<TutorialItem> items = new ArrayList<TutorialItem>();
        items.add(new TutorialItem(LocaleUtils.isEN() ? R.mipmap.tutorial_copy1_en : R.mipmap.tutorial_copy1, R.mipmap.tutorial_monigote1, -1, R.color.tinkercolor));
        items.add(new TutorialItem(LocaleUtils.isEN() ? R.mipmap.tutorial_copy2_en : R.mipmap.tutorial_copy2, R.mipmap.tutorial_monigote2, R.mipmap.tutorial_cta2, R.color.linkercolor));
        items.add(new TutorialItem(LocaleUtils.isEN() ? R.mipmap.tutorial_copy3_en : R.mipmap.tutorial_copy3, R.mipmap.tutorial_monigote3, R.mipmap.tutorial_cta3, R.color.tinkercolor));
        items.add(new TutorialItem(LocaleUtils.isEN() ? R.mipmap.tutorial_copy4_en : R.mipmap.tutorial_copy4, R.mipmap.tutorial_monigote4, R.mipmap.tutorial_cta4, R.color.recommendationcolor));
        mAdapter = new TutorialAdapter(getContext());
        mAdapter.setItems(items);
        mPager.setAdapter(mAdapter);
    }

    private void initListeners() {
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPageIndicator.setCurrentSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mTimer.postDelayed(mAutomaticScroll, INTERVAL_TIME);
                } else {
                    mTimer.removeCallbacks(mAutomaticScroll);
                }
            }
        });

        mPager.setDisableSwipe(false);
        mPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (mPager.getCurrentItem() != 0) {
                    mTimer.removeCallbacks(mAutomaticScroll);
                }

                return mDisableTouchPager;
            }
        });
    }

    // **************  UI Actions **************


    @OnClick(R.id.signButton)
    protected void btnSignClicked() {
        if (listener != null) {
            listener.onStartRegistration();
        }
    }

    // Public methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void stopTutorial() {
        mTimer.removeCallbacks(mAutomaticScroll);
    }

    public void startTutorial() {
        if (mButtonContainer.getAlpha() == 0) {
            mTimer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!listener.isUserLoged()) {

                        Animator.AnimatorListener listener = new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                mDisableTouchPager = false;
                                mTimer.postDelayed(mAutomaticScroll, INTERVAL_TIME);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        };

                        mButtonContainer.animate().alpha(1.0f).setListener(listener).start();
                    }
                }
            }, INTERVAL_BUTTONS_TIME);

        } else {
            mTimer.postDelayed(mAutomaticScroll, INTERVAL_TIME);
        }
    }
}