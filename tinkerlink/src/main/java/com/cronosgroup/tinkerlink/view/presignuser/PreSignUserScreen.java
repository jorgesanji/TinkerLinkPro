package com.cronosgroup.tinkerlink.view.presignuser;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class PreSignUserScreen extends RelativeLayout {

    public interface Listener {
        void onLoginPressed();

        void onSignPressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public PreSignUserScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public PreSignUserScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PreSignUserScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public PreSignUserScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_presignuser, this);
        ButterKnife.bind(this);
    }

    // Actions


    @OnClick(R.id.logButton)
    protected void onLoginPressed() {
        listener.onLoginPressed();
    }

    @OnClick(R.id.signButton)
    protected void onSignPressed() {
        listener.onSignPressed();
    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}