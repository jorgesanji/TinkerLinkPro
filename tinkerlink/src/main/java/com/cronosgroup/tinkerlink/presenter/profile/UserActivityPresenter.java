package com.cronosgroup.tinkerlink.presenter.profile;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserActivityPresenter extends TinkerLinkPresenter<UserActivityPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * UserActivity listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * UserActivity actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public UserActivityPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


