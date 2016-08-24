package com.cronosgroup.tinkerlink.view.dialog.report;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ReportContactDialogScreen extends TLBaseView {

    /**
     * listeners BlockContactsDialog's screen.
     */
    public interface Listener {
        void onCancelPressed();

        void onConfirmedPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.titleDialog)
    protected TLTextView mTitleDialog;

    @BindView(R.id.sendButton)
    protected TLTextView mComfirm;

    @BindView(R.id.suspectContentText)
    protected TLTextView mSuspectContentText;

    @BindView(R.id.sexualContentText)
    protected TLTextView mSexualContentText;

    @BindView(R.id.insultText)
    protected TLTextView mInsultText;

    @BindView(R.id.suspectsFiles)
    protected CheckBox mSuspectsFiles;

    @BindView(R.id.sexualPublish)
    protected CheckBox mSexualPublish;

    @BindView(R.id.insultAnyOne)
    protected CheckBox mInsultAnyOne;

    /**
     * @param context
     */
    public ReportContactDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public ReportContactDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ReportContactDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ReportContactDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ReportContactDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_report;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
    }

    private void initUI() {
        mTitleDialog.setText(getResources().getString(R.string.dialog_report_title));
        mComfirm.setText(getResources().getString(R.string.dialog_report_action_text));
    }

    // Actions

    @OnClick(R.id.cancelButton)
    protected void cancelPressed() {
        listener.onCancelPressed();
    }

    @OnClick(R.id.sendButton)
    protected void addPressed() {
        listener.onConfirmedPressed();
    }

    @OnClick(R.id.closeDialog)
    protected void closePressed() {
        listener.onCancelPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public int getActionSelected() {
        return 1;
    }

    public void setUserNameToReport(String userNameToReport) {
        mSuspectContentText.setText(String.format(getResources().getString(R.string.dialog_report_files_content), userNameToReport));
        mSexualContentText.setText(String.format(getResources().getString(R.string.dialog_report_sexual_content), userNameToReport));
        mInsultText.setText(String.format(getResources().getString(R.string.dialog_report_insult_content), userNameToReport));
    }
}
