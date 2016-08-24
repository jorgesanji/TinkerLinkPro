package com.cronosgroup.tinkerlink.view.searchcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

/**
 * DetailStack view.
 */
public class SearchCardScreen extends TLBaseView {

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
    public SearchCardScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public SearchCardScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SearchCardScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SearchCardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SearchCardScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_search_cards;
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