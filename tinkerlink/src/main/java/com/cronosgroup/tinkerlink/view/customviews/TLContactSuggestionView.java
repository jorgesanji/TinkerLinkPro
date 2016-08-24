package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLContactSuggestionView extends TLBaseView {

    public TLContactSuggestionView(Context context) {
        super(context);
    }

    public TLContactSuggestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLContactSuggestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLContactSuggestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_contact_suggestion_view;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }
}
