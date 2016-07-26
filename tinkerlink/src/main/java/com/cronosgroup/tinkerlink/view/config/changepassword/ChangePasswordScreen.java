package com.cronosgroup.tinkerlink.view.config.changepassword;

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
public class ChangePasswordScreen extends RelativeLayout {

    public interface Listener {
        void onRecoveryPressed();
    }

    // Vars
    private Listener listener;

    // Views


    /**
     * @param context
     */
    public ChangePasswordScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ChangePasswordScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChangePasswordScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ChangePasswordScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_change_password, this);
        ButterKnife.bind(this);
    }

    // Actions

    @OnClick(R.id.saveButton)
    protected void savePressed() {

    }

    @OnClick(R.id.recoveryButton)
    protected void recoveryPressed() {
        listener.onRecoveryPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}