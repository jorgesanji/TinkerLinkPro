package com.cronosgroup.tinkerlink.presenter.createcard;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class SkillSelectionPresenter extends TinkerLinkPresenter<SkillSelectionPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public SkillSelectionPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods


}
