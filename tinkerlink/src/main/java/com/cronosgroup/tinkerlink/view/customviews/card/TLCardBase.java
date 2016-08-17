package com.cronosgroup.tinkerlink.view.customviews.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;

/**
 * Created by jorgesanmartin on 7/29/16.
 */
public abstract class TLCardBase extends TLLinearLayout {

    public TLCardBase(Context context) {
        this(context, null);
    }

    public TLCardBase(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLCardBase(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLCardBase(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public abstract View getViewForDrag();

}
