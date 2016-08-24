package com.cronosgroup.tinkerlink.view.dialog.validation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/28/15.
 */
public class ValidationDialogScreen extends TLLinearLayout {

    public interface Listener {

        void onVeryfiedPressed();

        void onClosePressed();
    }

    //Variables
    private Listener listener;

    //Views
    @BindView(R.id.titleValidation)
    protected TLTextView mTitleValidation;

    @BindView(R.id.validationNumber)
    protected TLTextView mValidationNumber;

    @BindView(R.id.code)
    protected TLEditText mUserCode;

    @BindView(R.id.validationContainer)
    protected View mValidationContainer;

    @BindView(R.id.progressBar)
    protected View mProgressBar;

    /**
     * @param context
     */
    public ValidationDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ValidationDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ValidationDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ValidationDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_validation;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        mValidationContainer.setVisibility(INVISIBLE);
        mProgressBar.setVisibility(GONE);
    }

    // Actions

    @OnClick(R.id.verifybt)
    protected void verifyPressed() {
        listener.onVeryfiedPressed();
    }

    @OnClick(R.id.closeDialog)
    protected void closePressed() {
        listener.onClosePressed();
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

    public void show() {
        appear(mValidationContainer);
    }

    public void dismiss() {
        dissmiss(mValidationContainer);
    }

    public void showLoader() {
        mProgressBar.setVisibility(VISIBLE);
    }

    public void hideLoader() {
        mProgressBar.setVisibility(GONE);
    }

}
