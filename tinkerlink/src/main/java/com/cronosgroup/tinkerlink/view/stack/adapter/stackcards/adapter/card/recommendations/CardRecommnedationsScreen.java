package com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.card.recommendations;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.adapter.card.recommendations.adapter.CardRecommendationsAdapter;

import java.util.List;

import butterknife.BindView;


/**
 * CardRecommnedations view.
 */
public class CardRecommnedationsScreen extends TLBaseView {

    /**
     * listeners of the CardRecommnedation's screen.
     */
    public interface Listener {
        void onItemPressed(int position);
    }

    // Vars
    private Listener listener;
    private CardRecommendationsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    // Views
    @BindView(R.id.recommendationsList)
    protected TLRecyclerView mList;

    @BindView(R.id.progressBar)
    protected ProgressBar mProgressBar;

    /**
     * @param context
     */
    public CardRecommnedationsScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public CardRecommnedationsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CardRecommnedationsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CardRecommnedationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CardRecommnedationsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_card_recommendations;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        mList.addItemDecoration(new TLDividerItemDecoration(getContext(), R.drawable.line_divider_contacts));
    }

    private void initAdapter() {
        mAdapter = new CardRecommendationsAdapter();
        mList.setAdapter(mAdapter);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mList.setLayoutManager(mLayoutManager);
        mList.setItemAnimator(new SlideInUpAnimator());
    }

    private void initListeners() {
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                if (listener != null) {
                    listener.onItemPressed(position);
                }
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

    public void setItems(List<RestRecommendation> list) {
        mAdapter.addItems(list);
        mProgressBar.setVisibility(GONE);
    }
}