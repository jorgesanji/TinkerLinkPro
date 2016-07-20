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
public class RecomendationPage extends LinearLayout {

    public RecomendationPage(Context context) {
        this(context, null);
    }

    public RecomendationPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecomendationPage(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RecomendationPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_tutorial_recomendation, this);
        ButterKnife.bind(this);
    }
}
