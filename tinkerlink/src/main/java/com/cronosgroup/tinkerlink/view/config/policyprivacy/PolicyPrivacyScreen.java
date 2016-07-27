package com.cronosgroup.tinkerlink.view.config.policyprivacy;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;


/**
 * Main Network view.
 */
public class PolicyPrivacyScreen extends RelativeLayout {

    public interface Listener {

    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public PolicyPrivacyScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public PolicyPrivacyScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PolicyPrivacyScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public PolicyPrivacyScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_privacy_policy, this);
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
}