package com.cronosgroup.tinkerlink.view.stack;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.dragdrop.DragDropScreen;
import com.cronosgroup.tinkerlink.view.stack.adapter.StackAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * StackCard view.
 */
public class StackScreen extends RelativeLayout {

    public static final long TIME_TO_ANIMATION = 500;
    public static final long DELAY_TO_ANIMATION = 80;

    /**
     * listeners of the stack's screen.
     */
    public interface Listener {

    }

    // Vars
    private Listener listener;
    private StackAdapter mAdapter;

    // Views

    @BindView(R.id.tablayout)
    protected TabLayout mTab;

    @BindView(R.id.pager)
    protected TLViewPager mPager;

    @BindView(R.id.backgroundFadeIn)
    protected View mBackgroundIn;

    @BindView(R.id.backgroundFadeOut)
    protected View mBackgroundOut;

    @BindView(R.id.dragDropScreen)
    protected DragDropScreen dragDropScreen;

    /**
     * @param context
     */
    public StackScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public StackScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public StackScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public StackScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public StackScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_stack, this);
        ButterKnife.bind(this);
        mBackgroundIn.setAlpha(0);
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

    public View getAnimableView() {
        return mBackgroundOut;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setDragdropListener(DragDropScreen.Listener dragdropListener) {
        dragDropScreen.setListener(dragdropListener);
    }

    public void initPager(FragmentManager manager) {
        mAdapter = new StackAdapter(manager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
    }

    public void animBackground() {
        mBackgroundIn.animate().alpha(1).setDuration(TIME_TO_ANIMATION).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mBackgroundOut.animate().alpha(0).setDuration(TIME_TO_ANIMATION).setStartDelay(DELAY_TO_ANIMATION).setInterpolator(new AccelerateInterpolator()).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }


    public void showOverlaySelector() {
        dragDropScreen.setVisibility(VISIBLE);
    }

    public void dissmissOverlaySelector() {
        dragDropScreen.setVisibility(GONE);
    }
}