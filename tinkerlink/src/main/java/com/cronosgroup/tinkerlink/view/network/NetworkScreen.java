package com.cronosgroup.tinkerlink.view.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLNetworkView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Main Network view.
 */
public class NetworkScreen extends RelativeLayout {

    // Views
    @BindView(R.id.networkView)
    protected TLNetworkView networkView;

    /**
     * @param context
     */
    public NetworkScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public NetworkScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public NetworkScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public NetworkScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_network_container, this);
        ButterKnife.bind(this);
        networkView.setVisibility(INVISIBLE);
    }

    // Public methods

    public void introAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_view_up);
        networkView.startAnimation(animation);
        networkView.setVisibility(VISIBLE);
    }

    public TLNetworkView getNetworkView() {
        return networkView;
    }
}