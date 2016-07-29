package com.cronosgroup.tinkerlink.presenter.dialog.country;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DialogCountryPresenter extends TinkerLinkDialogPresenter<DialogCountryPresenter.View> {

    private final Actions listener;

    /**
     * DialogCountry View.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        void setCountries(List<RestCountry> list);
    }

    /**
     * DialogCountry actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public DialogCountryPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void getCountries() {
        getView().setCountries(appCountryManager.getCountries());
    }
}

