package com.cronosgroup.tinkerlink.view.home.fragment.contacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main contacts view.
 */
public class ContactsScreen extends RelativeLayout {


    /**
     * listeners of the home's screen.
     */
    public interface Listener {

        void onLaunch();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public ContactsScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public ContactsScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public ContactsScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ContactsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_contacts, this);
        ButterKnife.bind(this);
    }

    // **************  UI Actions **************

    @OnClick(R.id.launch)
    protected void onLaunch() {
        listener.onLaunch();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}