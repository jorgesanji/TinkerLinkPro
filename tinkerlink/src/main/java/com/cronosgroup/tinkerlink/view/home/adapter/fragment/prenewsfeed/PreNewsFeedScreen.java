package com.cronosgroup.tinkerlink.view.home.adapter.fragment.prenewsfeed;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Main PreNewsFeed view.
 */
public class PreNewsFeedScreen extends TLBaseView {

    /**
     * listeners of the PreNewsFeed's screen.
     */
    public interface Listener {
        void onCompleteProfilePressed();

        void onEmailVerifyPressed();

        void onImTinkerStackPressed();

        void onSearchTinkerStackPressed();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.messageInfo)
    protected View messageInfo;

    /**
     * @param context
     */
    public PreNewsFeedScreen(Context context) {
        super(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public PreNewsFeedScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PreNewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PreNewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_pre_newsfeed;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

    }

    // **************  UI Actions **************

    @OnClick(R.id.completeProfile)
    protected void completeProfilePressed() {
        listener.onCompleteProfilePressed();
    }

    @OnClick(R.id.emailVerify)
    protected void emailVerifyPressed() {
        listener.onEmailVerifyPressed();
    }

    @OnClick(R.id.prenewsfeed_button)
    protected void understandCardsNavigationsPressed() {
        messageInfo.setVisibility(GONE);
    }

    @OnClick(R.id.imTinkerbt)
    protected void btnImTinkerPressed() {
        listener.onImTinkerStackPressed();
    }

    @OnClick(R.id.searchTinkerbt)
    protected void btnSearchTinkerPressed() {
        listener.onSearchTinkerStackPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}