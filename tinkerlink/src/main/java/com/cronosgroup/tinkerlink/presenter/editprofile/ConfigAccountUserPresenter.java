package com.cronosgroup.tinkerlink.presenter.editprofile;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ConfigAccountUserPresenter extends TinkerLinkPresenter<ConfigAccountUserPresenter.View> {

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //Actions

    public void onLaunchChangePassword() {
        navigation.onLaunchChangeUserPassword(getView().getActivity(), null);
    }

    public void onLaunchChangePhoneNumber() {
        navigation.onLaunchChangeUserPhoneNumber(getView().getActivity(), null);
    }

    public void onLaunchImportContacts() {
        navigation.onLaunchImportUserContacts(getView().getActivity(), null);
    }

    public void onLaunchPrivacy() {
        navigation.onLaunchUserPrivacy(getView().getActivity(), null);
    }

    public void onLaunchHelpTinkerLink() {
        navigation.onLaunchTinkerLinkHelp(getView().getActivity(), null);
    }

    public void onLaunchPolicyPrivacy() {
        navigation.onLaunchPolicyPrivacy(getView().getActivity(), null);
    }

    public void onLaunchFrequentlyQuestions() {
        navigation.onLaunchFrequentlyQuestions(getView().getActivity(), null);
    }
}


