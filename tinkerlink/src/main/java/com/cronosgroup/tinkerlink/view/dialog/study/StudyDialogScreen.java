package com.cronosgroup.tinkerlink.view.dialog.study;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class StudyDialogScreen extends LinearLayout {

    /**
     * listeners of the StudyDialog's screen.
     */
    public interface Listener {
        void onCancelPressed();

        void onAddPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.institutionName)
    TLEditText mInstitutionName;

    @BindView(R.id.courseName)
    TLEditText mCourseName;

    @BindView(R.id.sendButton)
    TLTextView mAddButton;


    /**
     * @param context
     */
    public StudyDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
        init();
    }

    /**
     * @param context
     */
    public StudyDialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public StudyDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public StudyDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public StudyDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_study_view, this);
        ButterKnife.bind(this);
        mAddButton.setText(getResources().getString(R.string.add_button_title));
        mInstitutionName.requestFocus();
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mInstitutionName, InputMethodManager.SHOW_IMPLICIT);
    }

    @OnClick(R.id.cancelButton)
    protected void cancelPressed() {
        listener.onCancelPressed();
    }

    @OnClick(R.id.sendButton)
    protected void addPressed() {
        listener.onAddPressed();
    }

    // Public methods

    public String getCourseName() {
        return mCourseName.getText().toString();
    }

    public String getInstitutionName() {
        return mInstitutionName.getText().toString();
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
