package com.cronosgroup.tinkerlink.presenter.frequentlyquestions;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class FrequentlyQuestionsPresenter extends TinkerLinkPresenter<FrequentlyQuestionsPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Config user account actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public FrequentlyQuestionsPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}


