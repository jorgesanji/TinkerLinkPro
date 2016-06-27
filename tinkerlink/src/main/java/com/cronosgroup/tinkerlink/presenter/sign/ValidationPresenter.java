package com.cronosgroup.tinkerlink.presenter.sign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.business.logic.UserUseCases;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCode;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Validation sign presenter.
 */
public class ValidationPresenter extends TinkerLinkPresenter<ValidationPresenter.View> {

    private final Actions listener;

    /**
     * Validation view.
     */
    public interface View extends Presenter.View {
        AppUser getFormUser();

        String getValidationCode();

        void validateUser(RestUser restUser);
    }

    /**
     * Validation actions.
     */
    public interface Actions {
        void onSuccessValidation(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public ValidationPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    //endregion

    //region **************  View Actions **************

    public void checkCode(final String code) {

        if (code.length() == 6) {
            getView().showLoading();

            UserUseCases.checkCode(code, new Callback<RestCode, RestError>() {

                @Override
                public void onResponse(RestCode restCode) {
                    getView().hideLoading();
                    getView().validateUser(restCode.getUser());
                }

                @Override
                public void onErrorResponse(RestError error) {
                    getView().hideLoading();
                    getStatusView().showNetworkError();
                }

            }, getView().getActivity());
        } else {
            getStatusView().showCodeError();
        }
    }

    public void getCode() {

        String url = getView().getFormUser().getIdUser();

        UserUseCases.getCodeAndPassword(url, new Callback<RestCode, RestError>() {

            @Override
            public void onResponse(RestCode restCode) {
                getView().hideLoading();
            }

            @Override
            public void onErrorResponse(RestError error) {
                getView().hideLoading();
                getStatusView().showNetworkError();
            }

        }, getView().getActivity());
    }

    public void onSuccessValidation() {
        listener.onSuccessValidation(getView().getActivity(), null);
    }


    //endregion
}
