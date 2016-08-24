package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.registerselector;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class RegisterSelectorScreen extends TLBaseView {

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
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public RegisterSelectorScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RegisterSelectorScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_register_selector;
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

    // Public method

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}

