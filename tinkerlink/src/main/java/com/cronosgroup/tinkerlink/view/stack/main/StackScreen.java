package com.cronosgroup.tinkerlink.view.stack.main;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.bartoszlipinski.flippablestackview.FlippableStackView;
import com.bartoszlipinski.flippablestackview.StackPageTransformer;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.stack.main.adapter.StackAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Stack view.
 */
public class StackScreen extends RelativeLayout {

    public static final int DEFAULT_PAGES = 3;
    public static final long TIME_TO_ANIMATION = 500;
    public static final long DELAY_TO_ANIMATION = 80;


    /**
     * listeners of the stack's screen.
     */
    public interface Listener {
        void onSelectCardsPressed();
    }

    // Vars
    private Listener listener;
    private StackAdapter adapter;
    private FragmentManager fragmentManager;
    private StackActivity.Stack stackType;
    private int TotalWidth;

    // Views
    @BindView(R.id.pager)
    protected FlippableStackView mPager;

    @BindView(R.id.backgroundFadeIn)
    View mBackgroundIn;

    @BindView(R.id.backgroundFadeOut)
    protected View mBackgroundOut;

    @BindView(R.id.selectCardsType)
    protected TLTextView mSelectCardsType;

    @BindView(R.id.stackIndicator)
    protected SeekBar mStackIndicator;

    @BindView(R.id.pageNumberIndicator)
    protected TLTextView mPageNumberIndicator;

    @BindView(R.id.overLaySelector)
    protected View mOverLaySelector;

    /**
     * @param context
     */
    public StackScreen(Context context, Listener listener, FragmentManager fragmentManager) {
        this(context);
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

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
        initUI();
        initListener();
    }

    private void initListener() {

        final ViewTreeObserver obs = mStackIndicator.getViewTreeObserver();
        obs.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (mStackIndicator.getViewTreeObserver().isAlive()) {
                    mStackIndicator.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                TotalWidth = mStackIndicator.getWidth();
            }
        });

        mStackIndicator.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                final float oneElementWidth = TotalWidth / adapter.getCount();
                final float currentWidthProgress = (progress * TotalWidth) / 100;
                final int currentIndex = (int) Math.ceil(currentWidthProgress / oneElementWidth) - 1;
                mPager.setCurrentItem(Math.abs(currentIndex - (adapter.getCount() - 1)), true);
                setNumberPages(adapter.getCount(), (currentIndex == -1) ? 1 : currentIndex + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initUI() {
        mPageNumberIndicator.setVisibility(INVISIBLE);
        mStackIndicator.setVisibility(INVISIBLE);
        mPager.setVisibility(INVISIBLE);
        mBackgroundIn.setAlpha(0);
        mPager.initStack(DEFAULT_PAGES,
                StackPageTransformer.Orientation.VERTICAL);
    }

    // **************  UI Actions **************

    @OnClick(R.id.selectCardsType)
    protected void selectCardsPressed() {
        listener.onSelectCardsPressed();
    }

    // Public methods

    public void setNumberPages(int numPages, int currentPage) {
        mPageNumberIndicator.setText(String.valueOf(currentPage) + " / " + String.valueOf(numPages));
    }

    public View getAnimableView() {
        return mBackgroundOut;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initView(StackActivity.Stack stackType) {
        this.stackType = stackType;
        adapter = new StackAdapter(fragmentManager);
        adapter.setStackType(stackType);
        adapter.setDetail(true);
        boolean isLinker = (stackType.getStackType() == StackActivity.Stack.LINKER.getStackType());
        int color = (isLinker) ? StackActivity.Stack.TINKER.getStackColor() : StackActivity.Stack.LINKER.getStackColor();
        int title = (isLinker) ? StackActivity.Stack.TINKER.getStackTitleAction() : StackActivity.Stack.LINKER.getStackTitleAction();
        mSelectCardsType.setTextColor(getContext().getResources().getColor(color));
        mSelectCardsType.setText(getContext().getString(title));
    }

    public void addItems(List<RestPost> restPosts) {
        if (adapter.getCount() == 0 && !restPosts.isEmpty()) {
            mPager.setVisibility(VISIBLE);
            mPageNumberIndicator.setVisibility(VISIBLE);
            mStackIndicator.setVisibility(VISIBLE);
            mPager.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_bounce));
            adapter.addItems(restPosts);
            mPager.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            adapter.addItems(restPosts);
            adapter.notifyDataSetChanged();
        }
        if (!restPosts.isEmpty()) {
            setNumberPages(adapter.getCount(), 1);
        }
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

    public List<RestPost> getItems() {
        return adapter.getItems();
    }

    public int getCurrentIndexPage() {
        return mPager.getCurrentItem();
    }

    public void showOverlaySelector() {
//        mOverLaySelector.setAlpha(0);
        mOverLaySelector.setVisibility(VISIBLE);
//        mOverLaySelector.animate().alpha(1).start();
    }
}