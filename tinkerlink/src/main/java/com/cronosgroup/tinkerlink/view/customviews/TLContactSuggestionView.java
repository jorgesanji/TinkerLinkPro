package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLContactSuggestionView extends LinearLayout {

    public TLContactSuggestionView(Context context) {
        this(context, null);
    }

    public TLContactSuggestionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLContactSuggestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLContactSuggestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_contact_suggestion_view, this);
        ButterKnife.bind(this);
    }
}
