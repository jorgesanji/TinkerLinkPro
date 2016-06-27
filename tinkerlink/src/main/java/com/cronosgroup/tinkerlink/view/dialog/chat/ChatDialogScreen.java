package com.cronosgroup.tinkerlink.view.dialog.chat;

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
public class ChatDialogScreen extends LinearLayout {

    /**
     * listeners of the chatDialog's screen.
     */
    public interface Listener {
         void onSendChat(String chat);

         void onCancelChat();
    }

    // Vars
    private Listener listener;
    private String mUserName;

    // Views
    @BindView(R.id.contactWith)
    TLTextView mContactWith;

    @BindView(R.id.textChat)
    TLEditText mChatMessage;

    /**
     * @param context
     */
    public ChatDialogScreen(Context context, String userName, Listener listener) {
        super(context);
        this.listener = listener;
        this.mUserName = userName;
        init();
    }

    /**
     * @param context
     */
    public ChatDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
        init();
    }

    /**
     * @param context
     */
    public ChatDialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ChatDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChatDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ChatDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_chat_dialog, this);
        ButterKnife.bind(this);
        String contactWith = String.format(getResources().getString(R.string.share_contact_with), mUserName);
        mContactWith.setText(contactWith);

        mChatMessage.requestFocus();
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mChatMessage, InputMethodManager.SHOW_IMPLICIT);
    }

    @OnEditorAction(R.id.textChat)
    protected boolean sendAction(int actionId) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_SEND) {
            handled = true;
            onSendButtonPressed();
        }
        return handled;
    }

    @OnClick(R.id.sendButton)
    protected void onSendButtonPressed() {
        if (getListener() != null) {

            if (mChatMessage.getText().toString().length() == 0) {
                mChatMessage.setError(getResources().getString(R.string.newsFeed_send_chat));
                return;
            }

            getListener().onSendChat(mChatMessage.getText().toString());
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mChatMessage.getWindowToken(), 0);
        }
    }

    @OnClick(R.id.cancelButton)
    protected void onCancelPressed() {
        if (getListener() != null) {
            getListener().onCancelChat();
        }
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
