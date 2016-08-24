package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.CheckBox;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 3/11/16.
 */
public class TLSkillView extends TLBaseView {

    //Vars

    //Views
    @BindView(R.id.skillSelector)
    protected CheckBox mHabilitySelected;

    @BindView(R.id.titleSkill)
    protected TLTextView mHabilityTitle;

    /**
     * @param context
     */
    public TLSkillView(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLSkillView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLSkillView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLSkillView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(AttributeSet attrs) {
        setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
        super.init(attrs);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_skills_item;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.titleSkill)
    protected void titlePressed() {
        mHabilitySelected.setChecked(!mHabilitySelected.isChecked());
    }

    //Public methods

    public void setTitleText(String habilityName) {
        mHabilityTitle.setText(habilityName);
    }

    public void setChecked(boolean selected) {
        mHabilitySelected.setChecked(selected);
    }

    public void disableCheck(boolean selected) {
        mHabilitySelected.setEnabled(!selected);
    }

    public void setTitleSize(float size) {
        mHabilityTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setTitleColor(int color) {
        mHabilityTitle.setTextColor(color);
    }
}
