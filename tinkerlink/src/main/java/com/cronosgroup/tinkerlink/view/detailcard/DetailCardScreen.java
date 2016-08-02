package com.cronosgroup.tinkerlink.view.detailcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;

import butterknife.BindView;
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

    @BindView(R.id.updateImages)
    protected TLImageButton mUpdateImages;

    @BindView(R.id.updateSkills)
    protected TLImageButton mupdateSkills;

    @BindView(R.id.updateBudget)
    protected TLImageButton mUpdateBudget;

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

    public void setAsPublishMode(boolean publishMode) {
        mUpdateImages.setVisibility(publishMode ? VISIBLE : GONE);
        mupdateSkills.setVisibility(publishMode ? VISIBLE : GONE);
        mUpdateBudget.setVisibility(publishMode ? VISIBLE : GONE);
    }
}