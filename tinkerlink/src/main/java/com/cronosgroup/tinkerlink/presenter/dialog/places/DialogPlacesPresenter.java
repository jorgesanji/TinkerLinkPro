package com.cronosgroup.tinkerlink.presenter.dialog.places;

import android.location.Address;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;

import java.io.IOException;
import java.util.List;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DialogPlacesPresenter extends TinkerLinkDialogPresenter<DialogPlacesPresenter.View> {

    private final Actions listener;
    public static final int MAX_RESULTS = 10;

    /**
     * DialogPlaces View.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        String getTextSearchable();

        void setPlaces(List<Address> addresses);
    }

    /**
     * DialogPlaces actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public DialogPlacesPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void getPlaces() {
        getView().showLoading();
        try {
            List<Address> list = geocoder.getFromLocationName(getView().getTextSearchable(), MAX_RESULTS);
            getView().setPlaces(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getView().hideLoading();

    }
}

