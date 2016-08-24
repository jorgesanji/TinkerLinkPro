package com.cronosgroup.tinkerlink.view.login;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class LoginScreen extends TLBaseView {

    public interface Listener {
        void onLoginPressed();

        void onLoginGooglePressed();

        void onLoginFacebookPressed();
    }

    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.idUser)
    protected TLEditText mIdUser;

    @BindView(R.id.passwordUser)
    protected TLEditText mUserPassword;

    /**
     * @param context
     */
    public LoginScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public LoginScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public LoginScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoginScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_login;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.loginbt)
    protected void onLoginPressed() {
        listener.onLoginPressed();
    }

    @OnClick(R.id.googlebt)
    protected void onLoginGooglePressed() {
        listener.onLoginGooglePressed();
    }

    @OnClick(R.id.facebookbt)
    protected void onLoginFacebookPressed() {
        listener.onLoginFacebookPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getIdUser() {
        return mIdUser.getText().toString();
    }

    public String getPasswordUser() {
        return mUserPassword.getText().toString();
    }
}