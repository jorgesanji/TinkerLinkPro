package com.cronosgroup.tinkerlink.view.dialog.recommendations;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class AcceptRecommendationsDialogScreen extends LinearLayout {

    /**
     * listeners of the Accept recommendation's screen.
     */
    public interface Listener {
        void cancelPressed();

        void acceptPressed();
    }

    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.titleRecommendation)
    TLTextView mTitle;

    @BindView(R.id.recommendationDescription)
    TLTextView mRecommendation;

    @BindView(R.id.sendButton)
    TLTextView mAcceptButton;


    /**
     * @param context
     */
    public AcceptRecommendationsDialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public AcceptRecommendationsDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public AcceptRecommendationsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public AcceptRecommendationsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_recommendation_dialog, this);
        ButterKnife.bind(this);
        mAcceptButton.setText(getResources().getString(R.string.ok_button_title));
    }


    //************** Actions ******************

    @OnClick(R.id.cancelButton)
    protected void cancelPressed() {
        listener.cancelPressed();
    }

    @OnClick(R.id.sendButton)
    protected void acceptPressed() {
        listener.acceptPressed();
    }

    //endRegion

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setNameUser(String userName) {
        String contactWith = String.format(getResources().getString(R.string.notification_recommends_to_you), userName);
        mTitle.setText(contactWith);
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            mRecommendation.setText(description);
        } else {
            mRecommendation.setVisibility(GONE);
        }
    }
}
