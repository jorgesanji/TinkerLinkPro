package com.cronosgroup.tinkerlink.view.config.main.adapter.pages.usernotifications;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;


/**
 * Main UserNotifications  view.
 */
public class UserNotificationsScreen extends TLBaseView {

    public interface Listener {


    }


    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public UserNotificationsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public UserNotificationsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UserNotificationsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserNotificationsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_config_notifications;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}