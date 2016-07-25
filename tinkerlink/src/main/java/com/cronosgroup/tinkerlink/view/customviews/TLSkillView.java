package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 3/11/16.
 */
public class TLSkillView extends LinearLayout {

    //Vars

    //Views
    @BindView(R.id.skillSelector)
    CheckBox mHabilitySelected;

    @BindView(R.id.titleSkill)
    TLTextView mHabilityTitle;

    /**
     * @param context
     */
    public TLSkillView(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public TLSkillView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLSkillView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
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
        init();
    }

    private void init() {
        setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
        inflate(getContext(), R.layout.lay_skills_item, this);
        ButterKnife.bind(this);
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
