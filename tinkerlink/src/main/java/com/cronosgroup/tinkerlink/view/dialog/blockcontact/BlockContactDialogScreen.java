package com.cronosgroup.tinkerlink.view.dialog.blockcontact;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class BlockContactDialogScreen extends LinearLayout {

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
    public BlockContactDialogScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public BlockContactDialogScreen(Context context) {
        this(context, (AttributeSet) null);
    }

    /**
     * @param context
     * @param attrs
     */
    public BlockContactDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public BlockContactDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BlockContactDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog_message, this);
        ButterKnife.bind(this);
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
