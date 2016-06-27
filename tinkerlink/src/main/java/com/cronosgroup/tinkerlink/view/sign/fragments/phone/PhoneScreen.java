package com.cronosgroup.tinkerlink.view.sign.fragments.phone;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLSelectorCountry;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class PhoneScreen extends RelativeLayout {

    public interface Listener {
        void showCountrySelector();

        void onSetUser();
    }

    //Vars
    private Listener listener;

    //Views
    @BindView(R.id.countrySelected)
    TLSelectorCountry mCountrySelected;

    @BindView(R.id.countryCodeSelected)
    TLTextView mCountryCodeSelected;

    @BindView(R.id.phoneNumber)
    TLEditText mPhoneNumber;

    /**
     * @param context
     */
    public PhoneScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public PhoneScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PhoneScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public PhoneScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_sign_phone, this);
        ButterKnife.bind(this);
        mPhoneNumber.setImeOptions(EditorInfo.IME_ACTION_DONE);
        mPhoneNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    listener.onSetUser();
                }
                return false;
            }
        });
    }


    @OnClick(R.id.countrySelected)
    protected void showCountrySelector() {
        listener.showCountrySelector();
    }

    // Public method

    public void currentCountry(String country, String code) {
        mCountrySelected.setText(country);
        mCountryCodeSelected.setText("+" + code);
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getPhone() {
        return mPhoneNumber.getText().toString().replace("-", "");
    }

    public String getCountryCode() {
        return mCountryCodeSelected.getText().toString().replace("+", "");
    }
}

