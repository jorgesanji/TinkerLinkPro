package com.cronosgroup.tinkerlink.presenter.searchcard;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class SearchCardPresenter extends TinkerLinkPresenter<SearchCardPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * SearchCard listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * SearchCard actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public SearchCardPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


