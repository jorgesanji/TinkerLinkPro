package com.cronosgroup.tinkerlink.view.detailcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCard;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.detailcard.adapter.DetailStackAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Detail card view.
 */
public class DetailStackScreen extends RelativeLayout {

    public interface Listener {

    }

    // Vars
    private Listener listener;
    private DetailStackAdapter mAdapter;

    // Views
    @BindView(R.id.pager)
    protected TLViewPager mPager;

    /**
     * @param context
     */
    public DetailStackScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public DetailStackScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DetailStackScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DetailStackScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_detail_stack, this);
        ButterKnife.bind(this);
    }

    // Actions


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager manager, int position) {
        mAdapter = new DetailStackAdapter(manager, getContext());
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(position);
    }

    public void setItems(List<RestCard> list) {
        mAdapter.getItems().addAll(list);
        mAdapter.notifyDataSetChanged();
    }

}