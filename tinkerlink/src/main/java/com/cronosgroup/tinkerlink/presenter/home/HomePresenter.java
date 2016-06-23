package com.cronosgroup.tinkerlink.presenter.home;

/**
 * Created by jorgesanmartin on 16/10/15.
 */

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Home presenter.
 */
public class HomePresenter extends TinkerLinkPresenter<HomePresenter.View> {
    private final Actions listener;

    /**
     * Home listeners.
     */
    public interface View extends Presenter.View {

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