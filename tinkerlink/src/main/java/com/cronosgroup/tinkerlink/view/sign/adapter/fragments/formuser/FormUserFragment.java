package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.formuser;

import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.presenter.sign.FormUserPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.country.DialogFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class FormUserFragment extends MVPTinkerLinkFragment<FormUserPresenter, FormUserPresenter.View>
        implements FormUserPresenter.View, FormUserScreen.Listener {

    //Vars
    private IOFormListener mCallback;

    //Views
    private FormUserScreen formUserScreen;

    //region **************  Fragment **************

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (IOFormListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement IOFormListener");
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        formUserScreen = new FormUserScreen(getActivity());
        formUserScreen.setListener(this);
        return formUserScreen;
    }

    @Override
    protected FormUserPresenter createPresenter() {
        return new FormUserPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected FormUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  FormUserPresenter.View **************
    //endregion

    //region **************  FormUserScreen.Listener **************
    @Override
    public void onSelectCountry() {
        addDialogFragment(DialogFragment.class, DialogFragment.CODE);
    }
    //endregion

}
