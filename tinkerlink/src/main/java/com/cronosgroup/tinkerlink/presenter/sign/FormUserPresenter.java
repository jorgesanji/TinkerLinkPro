package com.cronosgroup.tinkerlink.presenter.sign;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Facebook sign presenter.
 */
public class FormUserPresenter extends TinkerLinkPresenter<FormUserPresenter.View> {

    private final Actions listener;

    /**
     * FormUser view.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * FormUser actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public FormUserPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************
    //endregion

    //region **************  View Actions **************


    //endregion

}
