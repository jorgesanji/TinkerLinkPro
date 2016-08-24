package com.cronosgroup.tinkerlink.view.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 8/23/16.
 */
public abstract class TLBaseView extends LinearLayout {

    public abstract int getLayout();

    public abstract void initUI(AttributeSet attributeSet);

    public TLBaseView(Context context) {
        this(context, null);
    }

    public TLBaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLBaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        int layout = getLayout();
        if (layout != 0) {
            inflate(getContext(), layout, this);
            ButterKnife.bind(this);
        }
        initUI(attrs);
    }
}
