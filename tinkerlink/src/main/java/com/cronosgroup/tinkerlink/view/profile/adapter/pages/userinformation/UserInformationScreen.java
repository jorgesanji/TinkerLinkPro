package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userinformation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main UserActivity view.
 */
public class UserInformationScreen extends RelativeLayout {

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
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public UserInformationScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UserInformationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
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
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_information_user, this);
        ButterKnife.bind(this);
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