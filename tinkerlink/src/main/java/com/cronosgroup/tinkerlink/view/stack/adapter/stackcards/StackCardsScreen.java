package com.cronosgroup.tinkerlink.view.stack.adapter.stackcards;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.customviews.card.TLCardStack;
import com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.CardsAdapter;
import com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.card.CardScreen;

import java.util.List;

import butterknife.BindView;


/**
 * StackCard view.
 */
public class StackCardsScreen extends TLBaseView {

    private static final float DEFAULT_ALPHA = 0.6f;

    /**
     * listeners of the StackCard's screen.
     */
    public interface Listener {
        void onCardPressed(int position);

        void onShowOverLaySelector(int position);
    }

    // Vars
    private Listener listener;
    private CardsAdapter mAdapter;
    private StackCardType stackType;

    // Views

    @BindView(R.id.stackIndicator)
    protected SeekBar mStackIndicator;

    @BindView(R.id.pageNumberIndicator)
    protected TLTextView mPageNumberIndicator;

    @BindView(R.id.cardContainer)
    protected TLCardStack<CardScreen> mPager;

    @BindView(R.id.progressBar)
    protected View mLoader;

    /**
     * @param context
     */
    public StackCardsScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public StackCardsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public StackCardsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public StackCardsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StackCardsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_stack_card;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
        initListener();
    }

    private void initListener() {

        mPager.setListener(new TLCardStack.SwipeListener<CardScreen>() {
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
                listener.onShowOverLaySelector(position);
            }
        });

        mStackIndicator.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mPager.setAlpha(DEFAULT_ALPHA);
                    mPager.setEnabled(false);
                }
                setPage(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                setPage(progress);
                mPager.setAlpha(1);
                mPager.setEnabled(true);
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
    }

    // **************  UI Actions **************

    // Public methods

    public void setPage(int currentPage) {
        setNumberPages(mAdapter.getCount() - 1, (currentPage == -1) ? 0 : currentPage);
    }

    public void setNumberPages(int numPages, int currentPage) {
        mPageNumberIndicator.setText(String.valueOf(currentPage) + " / " + String.valueOf(numPages));
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    public void initView(StackCardType stackType) {
        this.stackType = stackType;
        mAdapter.setType(stackType);
    }

    public void addItems(List<TLCard> restPosts) {
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

    public List<TLCard> getItems() {
        return mAdapter.getItems();
    }

    public int getCurrentIndexPage() {
        return mPager.getCurrentItem();
    }

    public void showLoading() {
        mLoader.setVisibility(VISIBLE);
    }

    public void hideLoading() {
        mLoader.setVisibility(GONE);
    }
}