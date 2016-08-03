package com.cronosgroup.tinkerlink.view.dialog.country;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.presenter.dialog.country.DialogCountryPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CountryDialogFragment extends MVPTinkerLinkDialogFragment<DialogCountryPresenter, DialogCountryPresenter.View>
        implements DialogCountryPresenter.View, CountryDialogScreen.Listener {

    public static final int CODE = 800;
    public static final String COUNTRY_SELECTED = "SELECTED";

    private CountryDialogScreen countryDialogScreen;

    //region **************  Fragment.View **************

    @Override
    protected View getRootView() {
        countryDialogScreen = new CountryDialogScreen(getActivity(), this);
        return countryDialogScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getCountries();
        countryDialogScreen.show();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected DialogCountryPresenter createPresenter() {
        return new DialogCountryPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DialogCountryPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  CountryDialogScreen.Listener **************

    @Override
    public void onCountrySelected(RestCountry country) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(COUNTRY_SELECTED, country);
        sendResult(bundle, CODE);
    }

    @Override
    public void onClosePressed() {
        dismiss();
    }

    //endregion

    //region **************  CountryDialogPresenter.View **************

    @Override
    public void setCountries(List<RestCountry> list) {
        countryDialogScreen.setItems(list);
    }

    //endregion

}
