package com.cronosgroup.tinkerlink.view.tutorial.pages;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by jorgesanmartin on 20/7/16.
 */
public class WelcomePage extends RelativeLayout {

    public WelcomePage(Context context) {
        this(context, null);
    }

    public WelcomePage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WelcomePage(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WelcomePage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

    }


}
