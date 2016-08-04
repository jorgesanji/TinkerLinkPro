package com.cronosgroup.tinkerlink.presenter.searchnewsfeed;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class SearchNewsFeedPresenter extends TinkerLinkPresenter<SearchNewsFeedPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * SearchNewsFeed listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * SearchNewsFeed actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public SearchNewsFeedPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


