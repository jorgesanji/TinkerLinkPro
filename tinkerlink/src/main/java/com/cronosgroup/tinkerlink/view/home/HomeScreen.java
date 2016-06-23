package com.cronosgroup.tinkerlink.view.home;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main Home view.
 */
public class HomeScreen extends RelativeLayout {


    /**
     * listeners of the home's screen.
     */
    public interface Listener {
        void onNewsFeedPresed();

        void onContactsPresed();

        void onMessagesPresed();

        void onProfilePresed();

    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.newsfeedbt)
    TLActionButton newsfeedbt;

    @BindView(R.id.contactsbt)
    TLActionButton contactsbt;

    @BindView(R.id.mensajesbt)
    TLActionButton mensajesbt;

    @BindView(R.id.profilebt)
    TLActionButton profilebt;

    /**
     * @param context
     */
    public HomeScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public HomeScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public HomeScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public HomeScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public HomeScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_home, this);
        ButterKnife.bind(this);
    }

    // **************  UI Actions **************

    @OnClick(R.id.newsfeedbt)
    protected void newsFeedbtPressed() {
        listener.onNewsFeedPresed();
    }

    @OnClick(R.id.contactsbt)
    protected void contactsbtPressed() {
        listener.onContactsPresed();
    }

    @OnClick(R.id.mensajesbt)
    protected void mensajesbtPressed() {
        if (listener != null) {
            listener.onMessagesPresed();
        }
    }

    @OnClick(R.id.profilebt)
    protected void profilebtPressed() {
        if (listener != null) {
            listener.onProfilePresed();
        }
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}