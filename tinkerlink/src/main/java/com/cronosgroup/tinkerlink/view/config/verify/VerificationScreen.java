package com.cronosgroup.tinkerlink.view.config.verify;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Verification view.
 */
public class VerificationScreen extends RelativeLayout {

    public interface Listener {
        void onSendPressed();

        void onSelectorCountryPressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public VerificationScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public VerificationScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public VerificationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public VerificationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        inflate(getContext(), R.layout.lay_verify_phone, this);
        ButterKnife.bind(this);
    }

    // Actions
    @OnClick(R.id.sendButton)
    protected void sendPressed() {
        listener.onSendPressed();
    }

    @OnClick(R.id.selectorCountry)
    protected void selectorCountryPressed() {
        listener.onSelectorCountryPressed();
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}