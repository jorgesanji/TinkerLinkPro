package com.cronosgroup.tinkerlink.view.sign.phoneregistration;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLEditextForm;
import com.cronosgroup.tinkerlink.view.customviews.TLPhonefield;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main Phone registration view.
 */
public class PhoneRegistrationScreen extends TLBaseView {

    /**
     * listeners of the Phone registration's screen.
     */

    public interface Listener {
        void onSendCodePressed();

        void onVerifyPressed();
    }

    // Vars
    private Listener listener;
    private boolean mCodeSended;

    // Views
    @BindView(R.id.phoneInput)
    protected TLPhonefield mPhoneInput;

    @BindView(R.id.sendcodebt)
    protected TLButton mSendcodebt;

    @BindView(R.id.codetd)
    protected TLEditextForm mCodetd;

    @BindView(R.id.phoneUser)
    protected TLTextView mPhoneUser;

    @BindView(R.id.retrytv)
    protected TLTextView mRetrytv;

    @BindView(R.id.verifybt)
    protected TLButton mVerifybt;

    /**
     * @param context
     */
    public PhoneRegistrationScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public PhoneRegistrationScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PhoneRegistrationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PhoneRegistrationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_phone_registration;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        enableInputCode(mCodeSended);
        mPhoneInput.hideErrorMessage();
        mPhoneInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPhoneInput.hideErrorMessage();
            }
        });
    }

    // **************  UI Actions **************

    @OnClick(R.id.sendcodebt)
    protected void sendCodePressded() {
        if (mCodeSended) {
            enableInputCode(false);
            mPhoneInput.hideErrorMessage();
        } else if (mPhoneInput.isValid()) {
            mPhoneInput.hideErrorMessage();
            enableInputCode(true);
            listener.onSendCodePressed();
            String text = mPhoneInput.getPhoneNumber();
            mPhoneUser.setText(text);
        } else {
            mPhoneInput.shoErrorMessage();
        }
    }

    @OnClick(R.id.verifybt)
    protected void verifyPressed() {
        if (mCodetd.getText().length() >= 4) {
            listener.onVerifyPressed();
        }
    }

    // Public Methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void enableInputCode(boolean enable) {
        mCodeSended = enable;
        mCodetd.setEnabled(enable);
        mCodetd.setText(null);
        if (enable) {
            mCodetd.editRequestFocus();
        } else {
            mCodetd.editClearFocus();
        }
        mVerifybt.setTextColor(getResources().getColor(!enable ? R.color.text_black_gray : R.color.white));
        mVerifybt.setEnabled(enable);

        mPhoneUser.setVisibility(enable ? VISIBLE : GONE);
        mPhoneInput.setVisibility(!enable ? VISIBLE : GONE);
        mRetrytv.setVisibility(enable ? VISIBLE : GONE);

        mSendcodebt.setText(enable ? R.string.sign_phone_register_phone_edit_phone : R.string.sign_phone_register_phone_send_code);
        mSendcodebt.setBackgroundResource(enable ? R.drawable.button_sign_disable_states : R.drawable.button_sign_states);
        mSendcodebt.setTextColor(getResources().getColor(enable ? R.color.text_black_gray : R.color.white));
    }

    public String getPhoneNumber() {
        return mPhoneInput.getPhoneNumber();
    }

    public String getCode() {
        return mCodetd.getText().toString();
    }

    public void setCode(String code) {
        mCodetd.setText(code);
    }
}