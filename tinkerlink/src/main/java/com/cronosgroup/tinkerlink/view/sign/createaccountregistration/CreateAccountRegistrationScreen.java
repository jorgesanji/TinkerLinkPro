package com.cronosgroup.tinkerlink.view.sign.createaccountregistration;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

/**
 * Main Verify phone registration view.
 */
public class CreateAccountRegistrationScreen extends TLBaseView {

    /**
     * listeners of the Verify phone registration's screen.
     */

    public interface Listener {
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public CreateAccountRegistrationScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CreateAccountRegistrationScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CreateAccountRegistrationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CreateAccountRegistrationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_verify_phone_registration;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // **************  UI Actions **************

    // Public Methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }



}