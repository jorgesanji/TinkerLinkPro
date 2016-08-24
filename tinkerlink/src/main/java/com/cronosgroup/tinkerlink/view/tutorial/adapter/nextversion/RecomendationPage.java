package com.cronosgroup.tinkerlink.view.tutorial.adapter.nextversion;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class RecomendationPage extends TLBaseView {

    public RecomendationPage(Context context) {
        super(context);
    }

    public RecomendationPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecomendationPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RecomendationPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_tutorial_recomendation;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }
}
