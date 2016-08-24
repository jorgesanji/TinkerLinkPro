package com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchalltinkerlink;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

/**
 * DetailStack view.
 */
public class SearchAllTinkerLinkScreen extends TLBaseView {

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
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public SearchAllTinkerLinkScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SearchAllTinkerLinkScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SearchAllTinkerLinkScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_search_alltinkerlink;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

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