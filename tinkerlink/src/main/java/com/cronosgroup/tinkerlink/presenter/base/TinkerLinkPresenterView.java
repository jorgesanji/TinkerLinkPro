package com.cronosgroup.tinkerlink.presenter.base;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.view.AppSnackManager;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public interface TinkerLinkPresenterView extends Presenter.View {

    /**
     * remove current activity with delay
     */
    void removeActivityDelay();

    /**
     * Get messages handler
     */
    AppSnackManager getMessagesHandler();

    /**
     * Show custom dialog
     */
    void showDialogMessage(String title, String description, int icon);

    /**
     * Show custom dialog
     */
    void showDialogMessage(int title, int description, int icon);

}
