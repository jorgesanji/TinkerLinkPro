package com.cronosgroup.tinkerlink.view.tutorial.adapter.nextversion;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 20/7/16.
 */
public class WelcomePage extends TLBaseView {

    @BindView(R.id.titleWelcome)
    protected TLTextView mTitleWelcome;

    public WelcomePage(Context context) {
        super(context);
    }

    public WelcomePage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WelcomePage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WelcomePage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_tutorial_welcome;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
    }

    private void initUI() {
        mTitleWelcome.paintTextWithColor(getResources().getString(R.string.tutorial_welcome_title_fragment_tinker), R.color.tinkercolor);
        mTitleWelcome.paintTextWithColor(getResources().getString(R.string.tutorial_welcome_title_fragment_linker), R.color.linkercolor);
    }
}
