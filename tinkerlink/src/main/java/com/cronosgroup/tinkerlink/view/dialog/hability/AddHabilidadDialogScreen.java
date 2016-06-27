package com.cronosgroup.tinkerlink.view.dialog.hability;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class AddHabilidadDialogScreen extends LinearLayout {

    /**
     * listeners of the AddHabilidadDialogScreen's screen.
     */
    public interface Listener {
        void onAccept(String text);

        void onCancel();
    }

    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.hability)
    TLEditText mHability;

    @BindView(R.id.sendButton)
    TLTextView mAddButton;

    /**
     * @param context
     */
    public AddHabilidadDialogScreen(Context context, Listener listener) {
        this(context, null, 0);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public AddHabilidadDialogScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public AddHabilidadDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public AddHabilidadDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public AddHabilidadDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_hability_dialog, this);
        ButterKnife.bind(this);
        mAddButton.setText(getResources().getString(R.string.add_button_title));
        mHability.requestFocus();
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mHability, InputMethodManager.SHOW_IMPLICIT);
    }

    @OnEditorAction(R.id.hability)
    protected boolean sendAction(int actionId) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            handled = true;
            onSendButtonPressed();
        }
        return handled;
    }

    @OnClick(R.id.sendButton)
    protected void onSendButtonPressed() {
        if (getListener() != null) {
            if (mHability.getText().toString().length() == 0) {
                mHability.setError(getResources().getString(R.string.create_use_profile_added_hability_error));
                return;
            }
            getListener().onAccept(mHability.getText().toString());
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mHability.getWindowToken(), 0);
        }
    }

    @OnClick(R.id.cancelButton)
    protected void onCancelPressed() {
        if (getListener() != null) {
            getListener().onCancel();
        }
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
