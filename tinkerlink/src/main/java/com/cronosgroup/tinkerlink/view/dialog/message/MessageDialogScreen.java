package com.cronosgroup.tinkerlink.view.dialog.message;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class MessageDialogScreen extends TLBaseView {

    /**
     * listeners MessageDialog screen.
     */
    public interface Listener {
        void onOkPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.titleMessage)
    protected TLTextView mTitleMessage;

    @BindView(R.id.descriptionMessage)
    protected TLTextView mDescriptionMessage;

    @BindView(R.id.iconMessage)
    protected TLImageView mIconMessage;

    /**
     * @param context
     */
    public MessageDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public MessageDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public MessageDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MessageDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MessageDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_message;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.Okbutton)
    protected void onOkPressed() {
        listener.onOkPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setTitle(String title) {
        mTitleMessage.setText(title);
    }

    public void setDescription(String description) {
        mDescriptionMessage.setText(description);
    }

    public void setIcon(int icon) {
        mIconMessage.setImageResource(icon);
    }
}
