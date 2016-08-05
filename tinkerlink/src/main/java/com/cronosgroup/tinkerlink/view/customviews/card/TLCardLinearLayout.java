package com.cronosgroup.tinkerlink.view.customviews.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by jorgesanmartin on 8/5/16.
 */
public class TLCardLinearLayout extends LinearLayout {
    public TLCardLinearLayout(Context context) {
        super(context);
        setClipChildren(false);
    }

    public TLCardLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClipChildren(false);
    }

    public TLCardLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClipChildren(false);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLCardLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setClipChildren(false);
    }
}
