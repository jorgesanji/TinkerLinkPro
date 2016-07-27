package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/26/16.
 */
public class TLStudyView extends LinearLayout {

    public interface Listener {
        void onRemoveStudy();

        void onEditStudy();
    }

    //Vars
    private Listener listener;
    private boolean options;

    //Views
    @BindView(R.id.courseName)
    protected TLTextView mCourseName;

    @BindView(R.id.instituteName)
    protected TLTextView mInstituteName;

    @BindView(R.id.courseDate)
    protected TLTextView mCourseDate;

    @BindView(R.id.editStudy)
    protected TLImageButton mEditStudy;

    @BindView(R.id.removeStudy)
    protected TLImageButton mRemoveStudy;

    public TLStudyView(Context context) {
        this(context, null);
    }

    public TLStudyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLStudyView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLStudyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_study_item, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLStudyView);
                setOptions(attributes.getBoolean(R.styleable.TLStudyView_options, true));
            } catch (Exception ex) {
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    // Actions

    @OnClick(R.id.editStudy)
    protected void editStudyPressed() {
        if (listener != null) {
            listener.onEditStudy();
        }
    }

    @OnClick(R.id.removeStudy)
    protected void removeStudyPressed() {
        if (listener != null) {
            listener.onRemoveStudy();
        }
    }

    //Public methods

    public Listener getListener() {
        return listener;
    }

    public void setCourseName(String courseName) {
        mCourseName.setText(courseName);
    }

    public void setInstituteName(String instituteName) {
        mInstituteName.setText(instituteName);
    }

    public void setCourseDate(String courseDate) {
        mCourseDate.setText(courseDate);
    }

    public boolean isOptions() {
        return options;
    }

    public void setOptions(boolean options) {
        this.options = options;
        mEditStudy.setVisibility(options ? VISIBLE : GONE);
        mRemoveStudy.setVisibility(options ? VISIBLE : GONE);
    }
}
