package com.cronosgroup.tinkerlink.view.dialog.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Main ShareDialog view.
 */
public class ShareDialogScreen extends TLLinearLayout {

    public interface Listener {
        void onClosePressed();
    }

    //Properties

    //Vars
    private Listener listener;

    //Views

    @BindView(R.id.linkedinCheck)
    protected CheckBox mLinkedinCheck;

    @BindView(R.id.facebookCheck)
    protected CheckBox mFacebookCheck;

    @BindView(R.id.twitterCheck)
    protected CheckBox mTwitterCheck;

    @BindView(R.id.titleDialog)
    protected TLTextView mTitleDialog;

    @BindView(R.id.containerShare)
    protected View mContainerShare;

    public ShareDialogScreen(Context context) {
        super(context);
    }

    public ShareDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShareDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShareDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_share;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        initUI();
    }

    private void initUI() {
        mContainerShare.setVisibility(GONE);
        mTitleDialog.setText(getResources().getString(R.string.dialog_share_title));
    }

    // **************  UI Actions **************

    @OnClick(R.id.closeDialog)
    protected void CloseDialogPressed() {
        listener.onClosePressed();
    }

    //Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void show() {
        appear(mContainerShare);
    }
}