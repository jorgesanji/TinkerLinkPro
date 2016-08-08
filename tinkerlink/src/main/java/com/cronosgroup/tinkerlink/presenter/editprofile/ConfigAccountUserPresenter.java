package com.cronosgroup.tinkerlink.presenter.editprofile;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ConfigAccountUserPresenter extends TinkerLinkPresenter<ConfigAccountUserPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Config user account actions.
     */
    public interface Actions {
        void onLaunchChangeUserPassword(Activity activity, Bundle bundle);

        void onLaunchChangeUserPhoneNumber(Activity activity, Bundle bundle);

        void onLaunchImportUserContacts(Activity activity, Bundle bundle);

        void onLaunchUserPrivacy(Activity activity, Bundle bundle);

        void onLaunchTinkerLinkHelp(Activity activity, Bundle bundle);

        void onLaunchPolicyPrivacy(Activity activity, Bundle bundle);

        void onLaunchFrequentlyQuestions(Activity activity, Bundle bundle);
    }


    /**
     * @param navigationListener
     */
    public ConfigAccountUserPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

    public void onLaunchChangePassword() {
        listener.onLaunchChangeUserPassword(getView().getActivity(), null);
    }

    public void onLaunchChangePhoneNumber() {
        listener.onLaunchChangeUserPhoneNumber(getView().getActivity(), null);
    }

    public void onLaunchImportContacts() {
        listener.onLaunchImportUserContacts(getView().getActivity(), null);
    }

    public void onLaunchPrivacy() {
        listener.onLaunchUserPrivacy(getView().getActivity(), null);
    }

    public void onLaunchHelpTinkerLink() {
        listener.onLaunchTinkerLinkHelp(getView().getActivity(), null);
    }

    public void onLaunchPolicyPrivacy() {
        listener.onLaunchPolicyPrivacy(getView().getActivity(), null);
    }

    public void onLaunchFrequentlyQuestions() {
        listener.onLaunchFrequentlyQuestions(getView().getActivity(), null);
    }
}


