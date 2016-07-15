package com.cronosgroup.tinkerlink.presenter.contacts;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ContactsPresenter extends TinkerLinkPresenter<ContactsPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends Presenter.View {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
        void onNetWorkPressed(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public ContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void onLaunchNetWork() {
        listener.onNetWorkPressed(getView().getActivity(), null);
    }
}
