package com.cronosgroup.tinkerlink.view.dialog.ocupation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.presenter.dialog.DialogOccupationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class OccupationDialogFragment extends MVPDialogFragment<DialogOccupationPresenter, DialogOccupationPresenter.View>
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
        if (result != null && result.length() > 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(OCCUPATION_ADDED, result);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            getTargetFragment().onActivityResult(
                    getTargetRequestCode(), OccupationDialogFragment.CODE, intent);
        }

        dismiss();
    }

    //endregion

    //region **************  DialogOccupationPresenter.View **************

    @Override
    public void setOccupations(List<String> occupations) {
        ocupationDialogScreen.setItems(occupations);
    }

    //endregion

}
