package com.cronosgroup.tinkerlink.view.editprofile;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLStudyView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main EditProfile view.
 */
public class EditProfileScreen extends TLBaseView {

    public interface Listener {
        void onAddCoursePressed();
        void onSelectCountryPressed();
        void onSelectOccupationPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.studiesContainer)
    protected LinearLayout mStudiesContainer;

    /**
     * @param context
     */
    public EditProfileScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public EditProfileScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public EditProfileScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditProfileScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_edit_profile;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.selectorCountry)
    protected void selectCountryPressed(){
        listener.onSelectCountryPressed();
    }

    @OnClick(R.id.selectorCategory)
    protected void selectOccupationPressed(){
        listener.onSelectOccupationPressed();
    }

    @OnClick(R.id.addStudyOrCourse)
    protected void addCoursePressed() {
        listener.onAddCoursePressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void addStudy(TLStudyView studyView) {
        mStudiesContainer.addView(studyView);
    }
}