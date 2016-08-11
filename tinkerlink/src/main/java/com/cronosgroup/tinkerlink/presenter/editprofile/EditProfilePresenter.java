package com.cronosgroup.tinkerlink.presenter.editprofile;

import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestStudy;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.dialog.study.StudyDialogFragment;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class EditProfilePresenter extends TinkerLinkPresenter<EditProfilePresenter.View> {

    /**
     * EditProfile listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void addStudy(RestStudy restStudy);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == StudyDialogFragment.CODE) {
            Bundle bundle = data.getExtras();
            RestStudy restStudy = (RestStudy) bundle.getSerializable(StudyDialogFragment.STUDY_ADDED);
            getView().addStudy(restStudy);
        }
    }

    // public methods

}

