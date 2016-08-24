package com.cronosgroup.tinkerlink.view.config.changephonenumber;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.OnClick;


/**
 * Main Network view.
 */
public class ChangePhoneNumberScreen extends TLBaseView {

    public interface Listener {
        void onVerifyPressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public ChangePhoneNumberScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_change_phone_number;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.verifyButton)
    protected void verifyPressed() {
        listener.onVerifyPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}