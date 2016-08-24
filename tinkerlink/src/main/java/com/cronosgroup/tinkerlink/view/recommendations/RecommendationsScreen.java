package com.cronosgroup.tinkerlink.view.recommendations;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.recommendations.adapter.RecommendationsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main  Recommendations view.
 */
public class RecommendationsScreen extends TLBaseView {

    public interface Listener {
        void onItemPressed(int position);

        void onGiveRecommendationPressed();
    }

    // Vars
    private Listener listener;
    private RecommendationsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    // Views
    @BindView(R.id.recommendationList)
    protected TLRecyclerView mList;

    /**
     * @param context
     */
    public RecommendationsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public RecommendationsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RecommendationsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_recommendations;
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
        mAdapter = new RecommendationsAdapter();
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
                listener.onItemPressed(position);
            }
        });
    }

    // Actions

    @OnClick(R.id.writteRecommendation)
    protected void writteRecommendationPressed() {
        listener.onGiveRecommendationPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<RestRecommendation> list) {
        mAdapter.addItems(list);
    }
}