package com.cronosgroup.tinkerlink.view.tutorial.adapter.pages;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageRoundBorder;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class TinkerPage extends LinearLayout {

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
        this(context, null);
    }

    public TinkerPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TinkerPage(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TinkerPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_tutorial_tinker, this);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        iconTinker.setImageResource(R.mipmap.newsfeed_tinkercard_net);
        iconTinker.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tinkercolor)));
        typeCard.setText(getResources().getString(R.string.card_me));
        jobCard.setText(getResources().getString(R.string.tutorial_recomendation_tinker_job));
        backgroundCard.setBackgroundResource(R.color.tinkercolor_50);
    }
}
