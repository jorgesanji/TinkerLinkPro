package com.cronosgroup.tinkerlink.presenter.sign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.tinkerlink.model.business.logic.UserUseCases;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestSign;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.view.dialog.country.DialogFragment;

/**
 * Phone sign presenter.
 */
public class PhonePresenter extends TinkerLinkPresenter<PhonePresenter.View> {

    public static final int COUNTRY_SELECTOR = 5000;
    private final Actions listener;

    /**
     * Phone view.
     */
    public interface View extends Presenter.View {
        void setCountrySelected(RestCountry restCountry);

        AppUser getFormUser();

        void noGoToNextPage();

        String getPhone();

        String getCodePhone();
    }

    /**
     * Phone actions.
     */
    public interface Actions {
        void onGoToLogin(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public PhonePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  BasePresenter **************

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == COUNTRY_SELECTOR) {
            Bundle extras = data.getExtras();
            RestCountry country = (RestCountry) extras.getSerializable(DialogFragment.COUNTRY_SELECTED);
            getView().setCountrySelected(country);
        }
    }

    //endregion

    //region **************  View Actions **************

    public void showCountrySelector() {
        ((MVPFragment)getView().getFragment()).addDialogFragment(DialogFragment.class, COUNTRY_SELECTOR);
    }

    public void setUser() {

        if (getView().getCodePhone().isEmpty()) {
            getStatusView().showPhoneError();
            return;
        }

        AppUser user = getView().getFormUser();
        user.setPhone(getView().getPhone());
        user.setCode(getView().getCodePhone());

        getView().showLoading();

        UserUseCases.setUser(user, new Callback<RestSign, RestError>() {

            @Override
            public void onResponse(RestSign response) {
                getView().hideLoading();
                if (response.getExists() != null && response.getExists()) {
                    listener.onGoToLogin(getView().getActivity(), null);
                    getView().getActivity().finish();
                } else {
                    AppUser appUser = getView().getFormUser();
                    appUser.setIdUser(response.getUser().getId());
                    getView().noGoToNextPage();
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                getView().hideLoading();
                getStatusView().showNetworkError();
            }

        }, getView().getActivity());
    }

    public boolean validateForm() {
        if (!(getView().getPhone().length() > 1 && getView().getCodePhone().length() > 1)) {
            getStatusView().showPhoneError();
            return false;
        }
        return true;
    }

    //endregion
}
