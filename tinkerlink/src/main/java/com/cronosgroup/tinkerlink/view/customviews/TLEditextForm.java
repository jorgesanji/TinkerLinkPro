package com.cronosgroup.tinkerlink.view.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 24/8/16.
 */
public class TLEditextForm extends TLBaseView {

    public enum ImputType {
        TEXT(0, InputType.TYPE_TEXT_VARIATION_NORMAL),
        PASSWORD(1, InputType.TYPE_TEXT_VARIATION_PASSWORD),
        EMAIL(2, InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        private final int imputType;
        private final int id;

        ImputType(int imputType, int id) {
            this.imputType = imputType;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int getImputType() {
            return imputType;
        }

        public static ImputType TypefromId(int id) {
            if (id == EMAIL.getId()) {
                return EMAIL;
            } else if (id == PASSWORD.getId()) {
                return PASSWORD;
            } else {
                return TEXT;
            }
        }
    }

    //Vars
    private String mErrorMessage;

    //Views
    @BindView(R.id.messageError)
    protected TextInputLayout mImputMessage;

    @BindView(R.id.editext)
    protected TLEditText mEditText;

    public TLEditextForm(Context context) {
        super(context);
    }

    public TLEditextForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLEditextForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TLEditextForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLEditextForm);
                setHint(attributes.getString(R.styleable.TLEditextForm_form_hint));
                setError(attributes.getString(R.styleable.TLEditextForm_form_error_message));
                setImputType(ImputType.TypefromId(attributes.getInt(R.styleable.TLEditextForm_form_imputType, ImputType.TEXT.getId())));

            } catch (Exception ex) {
                Log.e(TLEditextForm.class.getName(), ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
        mImputMessage.setErrorEnabled(true);
        hideErrorMessage();
    }

    // Public

    public void editRequestFocus() {
        mEditText.requestFocus();
    }

    public void editClearFocus() {
        mEditText.clearFocus();
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

    public void setImputType(ImputType imputType) {
        mEditText.setInputType(imputType.getImputType());
    }

    public String getText() {
        return mEditText.getText().toString();
    }

    public void setText(String text) {
        mEditText.setText(text);
    }
}
