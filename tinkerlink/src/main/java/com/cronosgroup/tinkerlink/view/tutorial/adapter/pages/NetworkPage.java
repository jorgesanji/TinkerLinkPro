package com.cronosgroup.tinkerlink.view.tutorial.adapter.pages;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class NetworkPage extends LinearLayout {

    public NetworkPage(Context context) {
        this(context, null);
    }

    public NetworkPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkPage(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NetworkPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_tutorial_network, this);
        ButterKnife.bind(this);
    }
}
