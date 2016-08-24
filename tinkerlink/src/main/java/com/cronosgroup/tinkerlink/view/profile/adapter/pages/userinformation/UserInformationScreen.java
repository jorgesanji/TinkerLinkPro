package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userinformation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.OnClick;

/**
 * Main UserActivity view.
 */
public class UserInformationScreen extends TLBaseView {

    public interface Listener {
        void onShowAllContactsPressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public UserInformationScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public UserInformationScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UserInformationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserInformationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_information_user;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.showAllContacts)
    protected void showAllContactsPressed() {
        listener.onShowAllContactsPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}