package com.cronosgroup.tinkerlink.presenter.contacts;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ContactsPresenter extends TinkerLinkPresenter <ContactsPresenter.View>{

    private final Actions listener;


    /**
     * Message listeners.
     */
    public interface View extends Presenter.View {

    }

    /**
     * Mesage actions.
     */
    public interface Actions {

    }

    /**
     * @param navigationListener
     */
    public ContactsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }
}
