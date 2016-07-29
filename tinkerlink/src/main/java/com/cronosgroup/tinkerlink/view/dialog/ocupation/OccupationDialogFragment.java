package com.cronosgroup.tinkerlink.view.dialog.ocupation;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.presenter.dialog.occupation.DialogOccupationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class OccupationDialogFragment extends MVPTinkerLinkDialogFragment<DialogOccupationPresenter, DialogOccupationPresenter.View>
        implements DialogOccupationPresenter.View, OccupationDialogScreen.Listener {

    // Vars
    public static final int CODE = 820;
    public static final String OCCUPATION_ADDED = "occupation_added";

    //Views
    private OccupationDialogScreen ocupationDialogScreen;

    //region **************  Fragment.View **************

    @Override
    protected void onDidAppear() {
        getPresenter().getOccupations();
    }

    @Override
    protected View getRootView() {
        ocupationDialogScreen = new OccupationDialogScreen(getActivity());
        ocupationDialogScreen.setListener(this);
        return ocupationDialogScreen;
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected DialogOccupationPresenter createPresenter() {
        return new DialogOccupationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DialogOccupationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  DialogOccupationScreen.Listener **************

    @Override
    public void onAddPressed(String result) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(OCCUPATION_ADDED, result);
        sendResult(bundle, CODE);
    }

    @Override
    public void onClosePressed() {
        dismiss();
    }

    //endregion

    //region **************  DialogOccupationPresenter.View **************

    @Override
    public void setOccupations(List<String> occupations) {
        ocupationDialogScreen.setItems(occupations);
        ocupationDialogScreen.show();
    }

    //endregion

}
