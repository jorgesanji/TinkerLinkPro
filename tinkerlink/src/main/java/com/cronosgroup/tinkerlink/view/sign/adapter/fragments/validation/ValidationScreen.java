package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.validation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/28/15.
 */
public class ValidationScreen extends RelativeLayout {

    public interface Listener {
        void getCode();

        void onVeryfiedPressed();
    }

    //Variables
    private Listener listener;

    //Views
    @BindView(R.id.titleValidation)
    TLTextView mTitleValidation;

    @BindView(R.id.validationNumber)
    TLTextView mValidationNumber;

    @BindView(R.id.code)
    TLEditText mUserCode;

    /**
     * @param context
     */
    public ValidationScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ValidationScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ValidationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ValidationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_sign_validation, this);
        ButterKnife.bind(this);
    }

    // Actions
    @OnClick(R.id.verifybt)
    protected void verifyPressed() {
        listener.onVeryfiedPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setTitle(String phone) {
        String text = String.format(getResources().getString(R.string.sign_register_validation_send), phone);
        mTitleValidation.setText(text);
    }

    public String getValidationCode() {
        return mUserCode.getText().toString();
    }

    public void setCode(String code) {
        mUserCode.setText(code);
    }

}
