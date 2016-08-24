package com.cronosgroup.tinkerlink.view.config.main.adapter.pages.useraccount;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.OnClick;


/**
 * Main Network view.
 */
public class ConfigAccountUserScreen extends TLBaseView {

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
    }

    /**
     * @param context
     * @param attrs
     */
    public ConfigAccountUserScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ConfigAccountUserScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public int getLayout() {
        return R.layout.lay_config_account_user;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

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
        listener.onCloseSessionPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}