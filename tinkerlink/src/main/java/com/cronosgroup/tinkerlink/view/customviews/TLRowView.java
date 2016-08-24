package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 7/26/16.
 */
public class TLRowView extends TLBaseView {

    //Vars

    //Views
    @BindView(R.id.titleRow)
    protected TLTextView mTitleRoww;

    @BindView(R.id.subtitleRow)
    protected TLTextView mSubTitleRoww;

    public TLRowView(Context context) {
        super(context);
    }

    public TLRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void init(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.button_default_states);
        super.init(attributeSet);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_row_view;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLRowView);
                setTitle(attributes.getString(R.styleable.TLRowView_rowTitle));
                setSubTitle(attributes.getString(R.styleable.TLRowView_rowSubTitle));
            } catch (Exception ex) {
                Log.e(TLMenuItem.class.getName(), ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    //Public methods

    public void setTitle(String title) {
        mTitleRoww.setText(title);
    }

    public void setSubTitle(String subtitle) {
        mSubTitleRoww.setText(subtitle);
    }
}
