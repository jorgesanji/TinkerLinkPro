package com.cronosgroup.tinkerlink.view.detailcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.detailcard.adapter.DetailStackAdapter;

import java.util.List;

import butterknife.BindView;


/**
 * Detail card view.
 */
public class DetailStackScreen extends TLBaseView {

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
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public DetailStackScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DetailStackScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_detail_stack;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }


    // Actions


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initPager(FragmentManager manager) {
        mAdapter = new DetailStackAdapter(manager, getContext());
        mPager.setAdapter(mAdapter);
    }

    public void setItems(List<TLCard> list) {
        mAdapter.getItems().addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void setCurrentCardVisible(int index) {
        mPager.setCurrentItem(index);
    }
}