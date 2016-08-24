package com.cronosgroup.tinkerlink.view.stack;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.stack.adapter.StackAdapter;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * StackCard view.
 */
public class StackScreen extends TLBaseView {

    public static final long TIME_TO_ANIMATION = 100;

    /**
     * listeners of the stack's screen.
     */
    public interface Listener {
        void onCreateCardPressed();
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


    /**
     * @param context
     */
    public StackScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public StackScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public StackScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public StackScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_stack;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        mBackgroundIn.setAlpha(0);
        mPager.setDisableSwipe(true);
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


    // **************  UI Actions **************

    @OnClick(R.id.createCardButton)
    protected void createCardPressed() {
        listener.onCreateCardPressed();
    }

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

    public void initPager(final FragmentManager manager, final StackCardType type) {
        mAdapter = new StackAdapter(manager, getContext());
        mPager.setAdapter(mAdapter);
        initUI();
        mPager.setCurrentItem(type.getStackType());
    }

    public void animBackground() {
        mBackgroundIn.animate().alpha(1).setDuration(TIME_TO_ANIMATION).setInterpolator(new LinearInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mBackgroundOut.animate().alpha(0).setDuration(TIME_TO_ANIMATION).setInterpolator(new LinearInterpolator()).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }
}