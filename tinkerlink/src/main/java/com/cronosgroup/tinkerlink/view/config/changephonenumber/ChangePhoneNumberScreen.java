package com.cronosgroup.tinkerlink.view.config.changephonenumber;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class ChangePhoneNumberScreen extends RelativeLayout {

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
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ChangePhoneNumberScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_change_phone_number, this);
        ButterKnife.bind(this);
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