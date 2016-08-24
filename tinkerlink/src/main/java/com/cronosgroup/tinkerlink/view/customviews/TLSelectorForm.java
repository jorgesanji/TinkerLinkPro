package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 8/10/16.
 */
public class TLSelectorForm extends TLBaseView {

    // Views

    @BindView(R.id.text)
    protected TLTextView mText;

    public TLSelectorForm(Context context) {
        super(context);
    }

    public TLSelectorForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLSelectorForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLSelectorForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void init(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.button_default_states);
        super.init(attributeSet);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_selector_form;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLSelectorForm);
                setHint(attributes.getString(R.styleable.TLSelectorForm_hintText));
            } catch (Exception ex) {
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    // Public methods

    public void setHint(String hint) {
        mText.setHint(hint);
    }

    public void setText(String text) {
        mText.setText(text);
    }
}
