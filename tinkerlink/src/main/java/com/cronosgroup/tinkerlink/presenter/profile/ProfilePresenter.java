package com.cronosgroup.tinkerlink.presenter.profile;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ProfilePresenter extends TinkerLinkPresenter<ProfilePresenter.View> {

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
    public ProfilePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }
}
