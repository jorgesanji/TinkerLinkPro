package com.cronosgroup.tinkerlink.presenter.userstatus;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserStatusPresenter extends TinkerLinkDialogPresenter<UserStatusPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * UserStatus listeners.
     */
    public interface View extends TinkerLinkDialogPresenterView {
    }

    /**
     * UserStatus actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public UserStatusPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


