package com.cronosgroup.tinkerlink.view.tutorial;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.animation.tutorial.DepthPageTransformer;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPagerIndicator;
import com.cronosgroup.tinkerlink.view.tutorial.adapter.TutoriaItem;
import com.cronosgroup.tinkerlink.view.tutorial.adapter.TutorialAdapter;

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
        void onLoginPressed();

        void onSignPressed();

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
    protected TLViewPager mPager;

    @BindView(R.id.buttonContainer)
    protected LinearLayout mButtonContainer;

    @BindView(R.id.pageIndicator)
    protected TLViewPagerIndicator mPageIndicator;

    /**
     * @param context
     */
    public TutorialScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TutorialScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
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
        mButtonContainer.setVisibility(GONE);
        mPager.setPageTransformer(true, new DepthPageTransformer());
    }

    private void initAdapter() {
        mAdapter = new TutorialAdapter(getContext());
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

    @OnClick(R.id.logButton)
    protected void onLoginPressed() {
        listener.onLoginPressed();
    }

    @OnClick(R.id.signButton)
    protected void onSignPressed() {
        listener.onSignPressed();
    }

    // Public methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void stopTutorial() {
        mTimer.removeCallbacks(mAutomaticScroll);
    }

    public void startTutorial() {
        if (mButtonContainer.getVisibility() == GONE) {
            mTimer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!listener.isUserLoged()) {

                        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                mDisableTouchPager = false;
                                mTimer.postDelayed(mAutomaticScroll, INTERVAL_TIME);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        };

                        mButtonContainer.setVisibility(VISIBLE);
                        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_activity_up_alpha);
                        animation.setAnimationListener(animationListener);
                        animation.setInterpolator(new LinearInterpolator());
                        mButtonContainer.startAnimation(animation);

                    }
                }
            }, INTERVAL_BUTTONS_TIME);

        } else {
            mTimer.postDelayed(mAutomaticScroll, INTERVAL_TIME);
        }
    }

    public void setTutorialItems(List<TutoriaItem> list) {
        mAdapter.setTutoriaItems(list);
        mAdapter.notifyDataSetChanged();
    }
}