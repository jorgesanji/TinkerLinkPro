package com.cronosgroup.tinkerlink.presenter.contacts;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ContactsPresenter extends TinkerLinkPresenter<ContactsPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
        void onLaunchNetWork(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public ContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void onLaunchNetWork() {
        listener.onLaunchNetWork(getView().getActivity(), null);
    }
}
