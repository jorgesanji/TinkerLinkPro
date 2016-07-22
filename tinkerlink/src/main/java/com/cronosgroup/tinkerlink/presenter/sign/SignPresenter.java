package com.cronosgroup.tinkerlink.presenter.sign;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;


/**
 * Sign presenter.
 */
public class SignPresenter extends TinkerLinkPresenter<SignPresenter.View> {


    private final Actions listener;

    /**
     * Sign listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Sign actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public SignPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************
    //endregion

    //region **************  View Actions **************
    //endregion
}
