package com.cronosgroup.tinkerlink.view.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 24/8/16.
 */
public class TLEditTextForm extends TLBaseView {

    public enum InputType {
        TEXT(0, android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_NORMAL),
        PASSWORD(1, android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD),
        EMAIL(2, android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS),
        DATE(3, android.text.InputType.TYPE_CLASS_DATETIME | android.text.InputType.TYPE_DATETIME_VARIATION_DATE);

        private final int imputType;
        private final int id;

        InputType(int id, int imputType) {
            this.id = id;
            this.imputType = imputType;
        }

        public int getId() {
            return id;
        }

        public int getImputType() {
            return imputType;
        }

        public static InputType TypefromId(int id) {
            if (id == EMAIL.getId()) {
                return EMAIL;
            } else if (id == PASSWORD.getId()) {
                return PASSWORD;
            } else if (id == DATE.getId()) {
                return DATE;
            } else {
                return TEXT;
            }
        }
    }

    //Vars
    private String mErrorMessage;
    private int maxLength;

    //Views
    @BindView(R.id.messageError)
    protected TextInputLayout mImputMessage;

    @BindView(R.id.editext)
    protected TLEditText mEditText;

    public TLEditTextForm(Context context) {
        super(context);
    }

    public TLEditTextForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLEditTextForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TLEditTextForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_edit_form;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLEditTextForm);
                setHint(attributes.getString(R.styleable.TLEditTextForm_form_hint));
                setError(attributes.getString(R.styleable.TLEditTextForm_form_error_message));
                setImputType(InputType.TypefromId(attributes.getInt(R.styleable.TLEditTextForm_form_imputType, InputType.TEXT.getId())));
                setMaxLength(attributes.getInt(R.styleable.TLEditTextForm_form_max_length, Integer.MAX_VALUE));
            } catch (Exception ex) {
                Log.e(TLEditTextForm.class.getName(), ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
        mImputMessage.setErrorEnabled(true);
        hideErrorMessage();
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hideErrorMessage();
            }
        });
    }

    // Public

    public void editRequestFocus() {
        mEditText.requestFocus();
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                .showSoftInput(mEditText, InputMethodManager.SHOW_FORCED);
    }

    public void editClearFocus() {
        mEditText.clearFocus();
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mEditText.setEnabled(enabled);
    }

    public void setError(String error) {
        this.mErrorMessage = error;
        mImputMessage.setError(error);
    }

    public void showErrorMessage() {
        mImputMessage.setError(mErrorMessage);
    }

    public void hideErrorMessage() {
        mImputMessage.setError(null);
    }

    public void setHint(String hint) {
        mEditText.setHint(hint);
    }

    public void setImputType(InputType imputType) {
        mEditText.setInputType(imputType.getImputType());
    }

    public String getText() {
        return mEditText.getText().toString().trim();
    }

    public void setText(String text) {
        mEditText.setText(text);
        if (text != null) {
            mEditText.setSelection(text.length());
        }
    }

    public void setMaxLength(int length) {
        this.maxLength = length;
        mEditText.setMaxLength(length);
    }
}
