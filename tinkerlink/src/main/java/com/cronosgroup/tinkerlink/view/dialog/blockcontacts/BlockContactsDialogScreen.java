package com.cronosgroup.tinkerlink.view.dialog.blockcontacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class BlockContactsDialogScreen extends LinearLayout {

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

    @BindView(R.id.userConfirmMesssage)
    protected TLTextView mUserConfirmMesssage;

    @BindView(R.id.blockContact)
    protected CheckBox mBlockContact;

    @BindView(R.id.removeContact)
    protected CheckBox mRemoveContact;

    /**
     * @param context
     */
    public BlockContactsDialogScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public BlockContactsDialogScreen(Context context) {
        this(context, (AttributeSet) null);
    }

    /**
     * @param context
     * @param attrs
     */
    public BlockContactsDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public BlockContactsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BlockContactsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog_contact_locked, this);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        mTitleDialog.setText(getResources().getString(R.string.dialog_blockcontact_title));
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

    public int getActionSelected() {
        return 1;
    }

    public void setUserNameToLock(String userNameToLock) {
        mUserConfirmMesssage.setText(String.format(getResources().getString(R.string.dialog_blockcontact_confirm), userNameToLock));
    }
}
