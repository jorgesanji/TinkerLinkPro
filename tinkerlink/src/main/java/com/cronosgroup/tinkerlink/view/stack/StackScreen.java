package com.cronosgroup.tinkerlink.view.stack;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.card.TLCardStack;
import com.cronosgroup.tinkerlink.view.dragdrop.DragDropScreen;
import com.cronosgroup.tinkerlink.view.stack.adapter.CardsAdapter;
import com.cronosgroup.tinkerlink.view.stack.adapter.card.CardScreen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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
        void onSelectCardsPressed();

        void onCardPressed(int position);
    }

    // Vars
    private Listener listener;

    private CardsAdapter mAdapter;
    private StackCardType stackType;

    // Views

    @BindView(R.id.backgroundFadeIn)
    protected View mBackgroundIn;

    @BindView(R.id.backgroundFadeOut)
    protected View mBackgroundOut;

    @BindView(R.id.selectCardsType)
    protected TLTextView mSelectCardsType;

    @BindView(R.id.stackIndicator)
    protected SeekBar mStackIndicator;

    @BindView(R.id.pageNumberIndicator)
    protected TLTextView mPageNumberIndicator;

    @BindView(R.id.dragDropScreen)
    protected DragDropScreen dragDropScreen;

    @BindView(R.id.cardContainer)
    protected TLCardStack<CardScreen> mPager;

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

        mPager.setSwipeListener(new TLCardStack.SwipeListener<CardScreen>() {
            @Override
            public void cardSwipedLeft(int position) {
                position++;
                setProgress(position);
            }

            @Override
            public void cardSwipedRight(int position) {
                position++;
                setProgress(position);
            }

            @Override
            public void cardsDepleted() {

            }

            @Override
            public void cardPressed(CardScreen card, int position) {
                listener.onCardPressed(position);
            }

            @Override
            public void cardOnLongPressed(CardScreen card, int position) {
                showOverlaySelector();
            }
        });

        mStackIndicator.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                setPage(progress);
                mPager.setSelection(progress);
            }
        });
    }

    private void setProgress(int position) {
        if (position < mAdapter.getCount()) {
            setPage(position);
            mStackIndicator.setProgress(position);
        }
    }

    private void initUI() {
        mAdapter = new CardsAdapter(getContext());
        mPager.setAdapter(mAdapter);
        mPager.setVisibility(INVISIBLE);

        mPageNumberIndicator.setVisibility(INVISIBLE);
        mStackIndicator.setVisibility(INVISIBLE);
        mBackgroundIn.setAlpha(0);
    }

    // **************  UI Actions **************

    @OnClick(R.id.selectCardsType)
    protected void selectCardsPressed() {
        listener.onSelectCardsPressed();
    }

    // Public methods

    public void setPage(int currentPage) {
        setNumberPages(mAdapter.getCount() - 1, (currentPage == -1) ? 0 : currentPage);
    }

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

    public void setDragdropListener(DragDropScreen.Listener dragdropListener) {
        dragDropScreen.setListener(dragdropListener);
    }

    public void initView(StackCardType stackType) {
        this.stackType = stackType;
        boolean isLinker = (stackType.getStackType() == StackCardType.LINKER.getStackType());
        int color = (isLinker) ? StackCardType.TINKER.getStackColor() : StackCardType.LINKER.getStackColor();
        int title = (isLinker) ? StackCardType.TINKER.getStackTitleAction() : StackCardType.LINKER.getStackTitleAction();
        mSelectCardsType.setTextColor(getContext().getResources().getColor(color));
        mSelectCardsType.setText(getContext().getString(title));
    }

    public void addItems(List<RestPost> restPosts) {
        if (mAdapter.getCount() == 0 && !restPosts.isEmpty()) {
            mPager.setVisibility(VISIBLE);
            mPageNumberIndicator.setVisibility(VISIBLE);
            mStackIndicator.setVisibility(VISIBLE);
            mAdapter.setItems(restPosts);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.addItems(restPosts);
            mAdapter.notifyDataSetChanged();
        }

        mStackIndicator.setMax(mAdapter.getCount() - 1);

        if (!restPosts.isEmpty()) {
            setPage(0);
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
        return mAdapter.getItems();
    }

    public int getCurrentIndexPage() {
        return mPager.getCurrentItem();
    }

    public void showOverlaySelector() {
        dragDropScreen.setVisibility(VISIBLE);
    }

    public void dissmissOverlaySelector() {
        dragDropScreen.setVisibility(GONE);
    }
}