package com.cronosgroup.tinkerlink.view.stack.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.stack.main.adapter.StackAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DetailStack view.
 */
public class DetailStackScreen extends LinearLayout {

    /**
     * listeners of the detailstack's screen.
     */
    public interface Listener {


    }

    // Vars
    private Listener listener;
    private StackAdapter adapter;
    private StackCard stackType;
    private FragmentManager fragmentManager;

    // Views
    @BindView(R.id.detailPager)
    TLViewPager mDetailPager;

    /**
     * @param context
     */
    public DetailStackScreen(Context context, Listener listener, FragmentManager fragmentManager) {
        this(context);
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

    /**
     * @param context
     */
    public DetailStackScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public DetailStackScreen(Context context) {
        this(context, null, 0);
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
    public DetailStackScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_detailstack, this);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        // Disable clip to padding
        mDetailPager.setClipToPadding(false);
        // set padding manually, the more you set the padding the more you see of prev & next page
        mDetailPager.setPadding(100, 0, 100, 0);
        // sets a margin b/w individual pages to ensure that there is a gap b/w them
        mDetailPager.setPageMargin(0);
    }

    // **************  UI Actions **************


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initView(StackCard stackType, List<RestPost> list, int indexPage) {
        this.stackType = stackType;
        adapter = new StackAdapter(fragmentManager);
        adapter.setDetail(false);
        adapter.setStackType(stackType);
        adapter.setItems(list);
        mDetailPager.setAdapter(adapter);
        mDetailPager.setCurrentItem(indexPage);
    }

}