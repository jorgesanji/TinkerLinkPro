package com.cronosgroup.tinkerlink.view.detailcard.adapter.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Detail card view.
 */
public class DetailCardScreen extends TLBaseView {

    public interface Listener {

        void onUpdateFormPressed();

        void onNetworkPressed();
    }

    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.updateForm)
    protected TLImageButton mUpdateImages;

    /**
     * @param context
     */
    public DetailCardScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public DetailCardScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DetailCardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DetailCardScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_detail_card;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.updateForm)
    protected void onUpdateFomrPressed() {
        listener.onUpdateFormPressed();
    }

    @OnClick(R.id.networkUser)
    protected void onNetworkPressed() {
        listener.onNetworkPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setAsPublishMode(boolean publishMode) {
        mUpdateImages.setVisibility(publishMode ? VISIBLE : GONE);
    }
}