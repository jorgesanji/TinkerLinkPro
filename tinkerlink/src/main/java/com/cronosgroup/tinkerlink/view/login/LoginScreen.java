package com.cronosgroup.tinkerlink.view.login;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class LoginScreen extends RelativeLayout {

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
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public LoginScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public LoginScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public LoginScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_login, this);
        ButterKnife.bind(this);
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