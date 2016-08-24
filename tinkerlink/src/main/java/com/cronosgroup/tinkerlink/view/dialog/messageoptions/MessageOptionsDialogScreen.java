package com.cronosgroup.tinkerlink.view.dialog.messageoptions;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class MessageOptionsDialogScreen extends TLBaseView {

    /**
     * listeners MessageOptionsDialog's screen.
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

    @BindView(R.id.confirmMesssage)
    protected TLTextView mConfirmMesssage;

    /**
     * @param context
     */
    public MessageOptionsDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public MessageOptionsDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public MessageOptionsDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MessageOptionsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MessageOptionsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_message_options;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
    }

    private void initUI() {
        mComfirm.setText(getResources().getString(R.string.dialog_blockcontact_confirm_title));
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

    public void setTitle(String message) {
        mTitleDialog.setText(message);
    }

    public void setMessage(String message) {
        mConfirmMesssage.setText(message);
    }

    public void setActionButtonText(String actionButtonText) {
        if (actionButtonText != null) {
            mComfirm.setText(actionButtonText);
        }
    }
}
