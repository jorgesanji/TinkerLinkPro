package com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchalltinkerlink;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * DetailStack view.
 */
public class SearchAllTinkerLinkScreen extends LinearLayout {

    /**
     * listeners of the detailstack's screen.
     */
    public interface Listener {


    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public SearchAllTinkerLinkScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public SearchAllTinkerLinkScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public SearchAllTinkerLinkScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SearchAllTinkerLinkScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public SearchAllTinkerLinkScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_search_alltinkerlink, this);
        ButterKnife.bind(this);
    }

    // **************  UI Actions **************

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}