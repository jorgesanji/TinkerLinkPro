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
        void onLaunchChangePassword(Activity activity, Bundle bundle);

        void onLaunchChangePhoneNumber(Activity activity, Bundle bundle);

        void onLaunchImportContacts(Activity activity, Bundle bundle);

        void onLaunchPrivacy(Activity activity, Bundle bundle);

        void onLaunchHelpTinkerLink(Activity activity, Bundle bundle);

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
        listener.onLaunchChangePassword(getView().getActivity(), null);
    }

    public void onLaunchChangePhoneNumber() {
        listener.onLaunchChangePhoneNumber(getView().getActivity(), null);
    }

    public void onLaunchImportContacts() {
        listener.onLaunchImportContacts(getView().getActivity(), null);
    }

    public void onLaunchPrivacy() {
        listener.onLaunchPrivacy(getView().getActivity(), null);
    }

    public void onLaunchHelpTinkerLink() {
        listener.onLaunchHelpTinkerLink(getView().getActivity(), null);
    }

    public void onLaunchPolicyPrivacy() {
        listener.onLaunchPolicyPrivacy(getView().getActivity(), null);
    }

    public void onLaunchFrequentlyQuestions() {
        listener.onLaunchFrequentlyQuestions(getView().getActivity(), null);
    }
}


