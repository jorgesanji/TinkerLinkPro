package com.cronosgroup.tinkerlink.view.detailcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Detail card view.
 */
public class DetailCardScreen extends RelativeLayout {

    public interface Listener {
        void onUpdateBudgetPressed();

        void onUpdateSkillsPressed();

        void onUpdateImagesPressed();

        void onNetworkPressed();
    }

    // Vars
    private Listener listener;

    // Views


    /**
     * @param context
     */
    public DetailCardScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public DetailCardScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DetailCardScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
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
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_detail_card, this);
        ButterKnife.bind(this);
    }

    // Actions

    @OnClick(R.id.updateBudget)
    protected void onUpdateBudgetPressed() {
        listener.onUpdateBudgetPressed();
    }

    @OnClick(R.id.updateSkills)
    protected void onUpdateSkillsPressed() {
        listener.onUpdateSkillsPressed();
    }

    @OnClick(R.id.updateImages)
    protected void onUpdateImagesPressed() {
        listener.onUpdateImagesPressed();
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
}