package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.registerselector;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class RegisterSelectorScreen extends RelativeLayout {

    public interface Listener {
        void onLoginPressed();

        void onLoginGooglePressed();

        void onLoginFacebookPressed();
    }

    //Vars
    private Listener listener;

    //Views
    @BindView(R.id.loginbt)
    protected TLButton mLoginBt;

    @BindView(R.id.googlebt)
    protected TLButton mGoogleBt;

    @BindView(R.id.facebookbt)
    protected TLButton mFacebookBt;


    /**
     * @param context
     */
    public RegisterSelectorScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public RegisterSelectorScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RegisterSelectorScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RegisterSelectorScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_register_selector, this);
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

    // Public method

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}

