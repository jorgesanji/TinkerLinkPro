package com.cronosgroup.tinkerlink.view.config.main.adapter.pages.useraccount;

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
public class ConfigAccountUserScreen extends RelativeLayout {

    public interface Listener {
        void onChangePasswordPressed();

        void onChangePhoneNumberPressed();

        void onImporContactsPressed();

        void onSelectPrivacyPressed();

        void onHelpTinkerLinkPressed();

        void onPrivacyPolicyPressed();

        void onFrequentlyQuestionsPressed();

        void onCloseSessionPressed();
    }


    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public ConfigAccountUserScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ConfigAccountUserScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ConfigAccountUserScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ConfigAccountUserScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_config_account_user, this);
        ButterKnife.bind(this);
    }

    // Actions

    @OnClick(R.id.changePassword)
    protected void changePasswordPressed() {
        listener.onChangePasswordPressed();
    }

    @OnClick(R.id.changePhoneNumber)
    protected void changePhoneNumberPressed() {
        listener.onChangePhoneNumberPressed();
    }

    @OnClick(R.id.importContacts)
    protected void imporContactsPressed() {
        listener.onImporContactsPressed();
    }

    @OnClick(R.id.selectPrivacy)
    protected void selectPrivacyPressed() {
        listener.onSelectPrivacyPressed();
    }

    @OnClick(R.id.helpTinkerLink)
    protected void helpTinkerLinkPressed() {
        listener.onHelpTinkerLinkPressed();
    }

    @OnClick(R.id.privacyPolicy)
    protected void privacyPolicyPressed() {
        listener.onPrivacyPolicyPressed();
    }

    @OnClick(R.id.frequentlyQuestions)
    protected void frequentlyQuestionsPressed() {
        listener.onFrequentlyQuestionsPressed();
    }

    @OnClick(R.id.closeSession)
    protected void closeSessionPressed() {

    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}