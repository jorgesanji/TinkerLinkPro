package com.cronosgroup.tinkerlink.view.cardfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.utils.TLDIviderGridSpacingDecoration;
import com.cronosgroup.tinkerlink.view.cardfilter.adapter.FilterCardsAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import java.util.List;

import butterknife.BindView;

/**
 * FilterCards view.
 */
public class FilterCardsScreen extends TLBaseView {

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
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public FilterCardsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public FilterCardsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FilterCardsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_filter_cards;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
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

    public void setItems(List<RestCategory> list, StackCardType type) {
        mAdapter.setType(type);
        mAdapter.addItems(list);
    }

}