package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 8/10/16.
 */
public class TLSelectorForm extends LinearLayout {
    // Views

    @BindView(R.id.text)
    protected TLTextView mText;

    public TLSelectorForm(Context context) {
        this(context, null);
    }

    public TLSelectorForm(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLSelectorForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLSelectorForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.button_default_states);
        inflate(getContext(), R.layout.lay_selector_form, this);
        ButterKnife.bind(this);
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
