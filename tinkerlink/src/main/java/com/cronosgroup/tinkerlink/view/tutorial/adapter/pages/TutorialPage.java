package com.cronosgroup.tinkerlink.view.tutorial.adapter.pages;

import android.content.Context;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 8/23/16.
 */
public class TutorialPage extends TLBaseView {

    // Views

    @BindView(R.id.cardGradient)
    protected TLImageView mCardGradient;

    @BindView(R.id.cardBackground)
    protected TLImageView mCardBackground;

    @BindView(R.id.imageHeaderTutorial)
    protected TLImageView mImageHeaderTutorial;

    @BindView(R.id.nameHeaderTutorial)
    protected TLTextView mNameHeaderTutorial;

    @BindView(R.id.typeTinkerHeaderTutorial)
    protected TLTextView mTypeTinkerHeaderTutorial;

    @BindView(R.id.jobHeaderTutorial)
    protected TLTextView mJobHeaderTutorial;

    @BindView(R.id.titlePage)
    protected TLTextView mTitlePage;

    @BindView(R.id.subtitlePage)
    protected TLTextView mSubTitlePage;

    @BindView(R.id.descriptionPage)
    protected TLTextView mDescriptionPage;

    public TutorialPage(Context context) {
        super(context);
    }

    public TutorialPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TutorialPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TutorialPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_tutorial_page;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        mCardGradient.setImageBitmap(null);
    }

    // public

    public void setCarBackground(int background) {
        mCardBackground.setImageResource(background);
    }

    public void setImageHeader(int image) {
        mImageHeaderTutorial.setImageResource(image);
    }

    public void setNameHeader(String name) {
        mNameHeaderTutorial.setText(name);
    }

    public void setTypeTinkerHeader(String name) {
        mTypeTinkerHeaderTutorial.setText(name);
    }

    public void setJobHeader(String name) {
        mJobHeaderTutorial.setText(name);
    }

    public void setTitle(String name) {
        mTitlePage.setText(name);
    }

    public void setSubTitle(String name) {
        mSubTitlePage.setText(name);
        mSubTitlePage.setVisibility(name.isEmpty() ? GONE : VISIBLE);
    }

    public void setDescription(String name) {
        mDescriptionPage.setText(name);
    }

}
