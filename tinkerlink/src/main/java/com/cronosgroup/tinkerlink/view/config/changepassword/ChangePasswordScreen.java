package com.cronosgroup.tinkerlink.view.config.changepassword;

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
public class ChangePasswordScreen extends TLBaseView {

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
    }

    /**
     * @param context
     * @param attrs
     */
    public ChangePasswordScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChangePasswordScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_change_password;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
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