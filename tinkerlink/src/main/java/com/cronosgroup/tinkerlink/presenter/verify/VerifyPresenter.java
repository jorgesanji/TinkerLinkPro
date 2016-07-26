package com.cronosgroup.tinkerlink.presenter.verify;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class VerifyPresenter extends TinkerLinkPresenter<VerifyPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Verify user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Verify user account actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public VerifyPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


