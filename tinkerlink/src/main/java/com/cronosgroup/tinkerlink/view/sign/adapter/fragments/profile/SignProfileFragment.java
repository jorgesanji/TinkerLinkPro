package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.profile;

import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.interfaces.IOValidationForm;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.presenter.sign.SignProfilePresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.category.CategoryDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.study.StudyDialogFragment;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class SignProfileFragment extends MVPTinkerLinkFragment<SignProfilePresenter, SignProfilePresenter.View>
        implements SignProfilePresenter.View, SignProfileScreen.Listener, IOValidationForm {

    //Vars
    private IOFormListener mCallback;
    private AppUser appUser;

    //Views
    private SignProfileScreen profileScreen;

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
        profileScreen = new SignProfileScreen(getActivity());
        profileScreen.setListener(this);
        return profileScreen;
    }

    @Override
    protected SignProfilePresenter createPresenter() {
        return new SignProfilePresenter();
    }

    @Override
    protected SignProfilePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  SignProfilePresenter.View **************

    //endregion

    //region **************  SignProfileScreen.Listener **************

    @Override
    public void onOccupationPressed() {
        addDialogFragment(CategoryDialogFragment.class, CategoryDialogFragment.CODE);
    }

    @Override
    public void onAddPressed() {
        addDialogFragment(StudyDialogFragment.class, StudyDialogFragment.CODE);
    }

    @Override
    public void onGalleryPressed(int type) {
        getPresenter().launchGallery();
    }

    @Override
    public void onCameraPressed(int type) {
        getPresenter().launchCamera();
    }

    //endregion

    @Override
    public boolean validationForm() {
        return false;
    }

    //region **************  EventBus **************

    //endregion
}
