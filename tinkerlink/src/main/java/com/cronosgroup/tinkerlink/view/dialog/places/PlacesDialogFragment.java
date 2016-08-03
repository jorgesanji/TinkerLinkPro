package com.cronosgroup.tinkerlink.view.dialog.places;

import android.location.Address;
import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.presenter.dialog.places.DialogPlacesPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class PlacesDialogFragment extends MVPTinkerLinkDialogFragment<DialogPlacesPresenter, DialogPlacesPresenter.View>
        implements DialogPlacesPresenter.View, PlacesDialogScreen.Listener {

    public static final String PLACE_SELECTED = "PLACE_SELECTED";
    public static final int CODE = 234;

    //Views
    private PlacesDialogScreen placesDialogScreen;

    //region **************  MVPFragment **************

    @Override
    protected DialogPlacesPresenter createPresenter() {
        return new DialogPlacesPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DialogPlacesPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  Fragment.View  **************

    @Override
    protected void onDidAppear() {
        placesDialogScreen.show();
    }

    @Override
    protected View getRootView() {
        placesDialogScreen = new PlacesDialogScreen(getContext(), this);
        return placesDialogScreen;
    }

    @Override
    public void showLoading() {
        placesDialogScreen.showLoader();
    }

    @Override
    public void hideLoading() {
        placesDialogScreen.hideLoader();
    }

    //endregion

    //region **************  DialogPlacesPresenter.View  **************

    @Override
    public String getTextSearchable() {
        return placesDialogScreen.getSearchableText();
    }

    @Override
    public void setPlaces(List<Address> addresses) {
        placesDialogScreen.setItems(addresses);
    }

    //endregion

    //region **************  DialogPlacesScreen.View  **************

    @Override
    public void onItemSelected(Address prediction) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PLACE_SELECTED, prediction);
        sendResult(bundle, CODE);
    }

    @Override
    public void onClosePressed() {
        dismiss();
    }

    @Override
    public void onSearchPressed() {
        getPresenter().getPlaces();
    }

    //endregion

}
