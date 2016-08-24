package com.cronosgroup.tinkerlink.view.tutorial.adapter.nextversion;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageRoundBorder;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class TinkerPage extends TLBaseView {

    // Views

    @BindView(R.id.iconTinker)
    protected FloatingActionButton iconTinker;

    @BindView(R.id.titleTinker)
    protected TLTextView titleTinker;

    @BindView(R.id.typeCardUser)
    protected TLImageRoundBorder typeCardUser;

    @BindView(R.id.typeCard)
    protected TLTextView typeCard;

    @BindView(R.id.jobCard)
    protected TLTextView jobCard;

    @BindView(R.id.backgroundCard)
    protected View backgroundCard;

    public TinkerPage(Context context) {
        super(context);
    }

    public TinkerPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TinkerPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TinkerPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_tutorial_tinker;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
    }

    private void initUI() {
        titleTinker.paintTextWithColor(getResources().getString(R.string.tutorial_tinker_name), R.color.tinkercolor);
        iconTinker.setImageResource(R.mipmap.floating_new_buscotinker);
        iconTinker.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tinkercolor)));
        typeCard.setText(getResources().getString(R.string.detail_card_me));
        jobCard.setText(getResources().getString(R.string.tutorial_tinker_job));
        backgroundCard.setBackgroundResource(R.color.tinkercolor_50);
    }
}
