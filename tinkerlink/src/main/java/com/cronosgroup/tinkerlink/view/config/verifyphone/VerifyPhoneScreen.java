package com.cronosgroup.tinkerlink.view.config.verifyphone;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.OnClick;


/**
 * Main Verification view.
 */
public class VerifyPhoneScreen extends TLBaseView {

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
    public VerifyPhoneScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public VerifyPhoneScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public VerifyPhoneScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VerifyPhoneScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_verify_phone;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
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