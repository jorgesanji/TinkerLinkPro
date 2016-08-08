package com.cronosgroup.tinkerlink.view.dialog.study;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

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
    @BindView(R.id.instituteName)
    protected TLEditText mInstitutionName;

    @BindView(R.id.titleName)
    protected TLEditText mCourseName;

    @BindView(R.id.sendButton)
    protected TLTextView mAddButton;

    @BindView(R.id.selectMonth)
    protected Spinner mSelectMonth;

    @BindView(R.id.selectYear)
    protected Spinner mSelectYear;

    /**
     * @param context
     */
    public StudyDialogScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public StudyDialogScreen(Context context) {
        this(context, (AttributeSet) null);
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
        this(context, attrs, defStyleAttr, 0);
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
        inflate(getContext(), R.layout.lay_dialog_study, this);
        ButterKnife.bind(this);
        mSelectMonth.setPrompt(getResources().getString(R.string.sign_select_dateBird_month));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.months_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSelectMonth.setAdapter(adapter);

        mSelectYear.setPrompt(getResources().getString(R.string.sign_select_dateBird_year));
        adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.years_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSelectYear.setAdapter(adapter);

        mAddButton.setText(getResources().getString(R.string.add_title));
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

    @OnClick(R.id.close)
    protected void closePressed() {
        listener.onCancelPressed();
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
