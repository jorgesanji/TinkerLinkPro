package com.cronosgroup.tinkerlink.presenter.home;

/**
 * Created by jorgesanmartin on 16/10/15.
 */

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Home presenter.
 */
public class HomePresenter extends TinkerLinkPresenter<HomePresenter.View> {
    private final Actions listener;

    /**
     * Home listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Home actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public HomePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //region **************  BasePresenter **************


    //endregion

    //region **************  View Actions **************


    //endregion


}