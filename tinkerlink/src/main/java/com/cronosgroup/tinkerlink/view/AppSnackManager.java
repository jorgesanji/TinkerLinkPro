package com.cronosgroup.tinkerlink.view;

import com.cronosgroup.core.presenter.BasePresenter;
import com.cronosgroup.core.presenter.StatusMessageManager;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 11/19/15.
 */
public class AppSnackManager extends StatusMessageManager {

    public AppSnackManager() {
        super(null);
    }

    public AppSnackManager(BasePresenter.View presenter) {
        super(presenter);
    }

    @Override
    public int getErrorColor() {
        return R.color.errorcolor;
    }

    @Override
    public int getSucessColor() {
        return R.color.tinkercolor;
    }

    @Override
    public int getWarningColor() {
        return R.color.warningcolor;
    }

    ////// SHOW SUCCESSFULL MESSAGES

    ////// SHOW ERROR MESSAGES

    public void showNetworkError() {
        showError(R.string.error_internet_connection);
    }

    ////// SHOW INFORMATIVE MESSAGES

    public void showCardsFilterWarning(int tinkers, int cards) {
        showWarning(String.format(getContext().getString(R.string.filter_cards_message), String.valueOf(tinkers), String.valueOf(cards)));
    }

}
