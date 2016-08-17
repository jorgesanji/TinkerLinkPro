package com.cronosgroup.tinkerlink.view.config.main.adapter.pages.useraccount;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.editprofile.ConfigAccountUserPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Config Account Fragment
 */
public class ConfigAccountUserFragment extends MVPTinkerLinkFragment<ConfigAccountUserPresenter, ConfigAccountUserPresenter.View>
        implements ConfigAccountUserPresenter.View, ConfigAccountUserScreen.Listener {

    // Vars

    // Views
    private ConfigAccountUserScreen configAccountUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        configAccountUserScreen = new ConfigAccountUserScreen(getActivity());
        configAccountUserScreen.setListener(this);
        return configAccountUserScreen;
    }

    @Override
    protected ConfigAccountUserPresenter createPresenter() {
        return new ConfigAccountUserPresenter();
    }

    @Override
    protected ConfigAccountUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ConfigPresenter.View **************

    //endregion

    //region ************** ConfigScreen.Listener **************

    @Override
    public void onChangePasswordPressed() {
        getPresenter().onLaunchChangePassword();
    }

    @Override
    public void onChangePhoneNumberPressed() {
        getPresenter().onLaunchChangePhoneNumber();
    }

    @Override
    public void onImporContactsPressed() {
        getPresenter().onLaunchImportContacts();
    }

    @Override
    public void onSelectPrivacyPressed() {
        getPresenter().onLaunchPrivacy();
    }

    @Override
    public void onHelpTinkerLinkPressed() {
        getPresenter().onLaunchHelpTinkerLink();
    }

    @Override
    public void onPrivacyPolicyPressed() {
        getPresenter().onLaunchPolicyPrivacy();
    }

    @Override
    public void onFrequentlyQuestionsPressed() {
        getPresenter().onLaunchFrequentlyQuestions();
    }

    @Override
    public void onCloseSessionPressed() {

    }

    //endregion

}
