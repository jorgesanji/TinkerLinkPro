package com.cronosgroup.tinkerlink.view.cardfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.utils.TLDIviderGridSpacingDecoration;
import com.cronosgroup.tinkerlink.view.cardfilter.adapter.FilterCardsAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FilterCards view.
 */
public class FilterCardsScreen extends LinearLayout {

    /**
     * listeners of the filterCards's screen.
     */
    public interface Listener {


    }

    // Vars
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;
    private FilterCardsAdapter mAdapter;

    // Views

    @BindView(R.id.filterList)
    protected TLRecyclerView mList;

    /**
     * @param context
     */
    public FilterCardsScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public FilterCardsScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public FilterCardsScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FilterCardsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public FilterCardsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_filter_cards, this);
        ButterKnife.bind(this);
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_mediun);
        mList.addItemDecoration(new TLDIviderGridSpacingDecoration(2, spacingInPixels, true, 0));
    }

    private void initRecyclerView() {
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(mLayoutManager);
        mList.setItemAnimator(new SlideInUpAnimator());
    }

    private void initAdapter() {
        this.mAdapter = new FilterCardsAdapter();
        mList.setAdapter(mAdapter);
    }

    private void initListeners() {
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                mAdapter.getItem(position).setSelected(!mAdapter.getItem(position).isSelected());
                mAdapter.notifyItemChanged(position);
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

    public void setItems(List<RestCategoria> list, StackActivity.Stack type) {
        mAdapter.setType(type);
        mAdapter.addItems(list);
    }

}