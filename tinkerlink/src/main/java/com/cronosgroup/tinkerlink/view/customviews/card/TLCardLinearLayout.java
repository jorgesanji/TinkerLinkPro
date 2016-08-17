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
        this(context, null);
    }

    public TLCardLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLCardLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLCardLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setClipChildren(false);
    }
}
