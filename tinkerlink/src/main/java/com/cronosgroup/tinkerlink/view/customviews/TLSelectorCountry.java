package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 11/4/15.
 */
public class TLSelectorCountry extends LinearLayout {

    //Vars
    private String text;

    //Views
    @BindView(R.id.selectedText)
    TLTextView mText;

    @BindView(R.id.separator)
    View mSeparator;

    @BindView(R.id.decorator)
    ImageView mDecorator;

    /**
     * @param context
     */
    public TLSelectorCountry(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public TLSelectorCountry(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLSelectorCountry(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public TLSelectorCountry(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    protected void init() {
        inflate(getContext(), R.layout.lay_selector_country, this);
        ButterKnife.bind(this);
    }

    // Public methods

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        mText.setText(text);
    }
}
