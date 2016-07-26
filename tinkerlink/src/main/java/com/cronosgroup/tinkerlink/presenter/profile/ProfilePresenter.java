package com.cronosgroup.tinkerlink.presenter.profile;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ProfilePresenter extends TinkerLinkPresenter<ProfilePresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Profile listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Profile actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public ProfilePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


