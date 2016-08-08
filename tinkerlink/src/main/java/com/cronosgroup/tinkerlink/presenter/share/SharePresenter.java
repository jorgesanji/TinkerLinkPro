package com.cronosgroup.tinkerlink.presenter.share;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class SharePresenter extends TinkerLinkDialogPresenter<SharePresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * Share listeners.
     */
    public interface View extends TinkerLinkDialogPresenterView {
    }

    /**
     * Share actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public SharePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

}

