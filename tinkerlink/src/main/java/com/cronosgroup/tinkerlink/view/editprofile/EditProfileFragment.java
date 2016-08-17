package com.cronosgroup.tinkerlink.view.editprofile;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestStudy;
import com.cronosgroup.tinkerlink.presenter.editprofile.EditProfilePresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.customviews.TLStudyView;
import com.cronosgroup.tinkerlink.view.dialog.country.CountryDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.occupation.OccupationDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.study.StudyDialogFragment;


/**
 * Sign Fragment
 */
public class EditProfileFragment extends MVPTinkerLinkFragment<EditProfilePresenter, EditProfilePresenter.View>
        implements EditProfilePresenter.View, EditProfileScreen.Listener {

    // Vars

    // Views
    private EditProfileScreen editProfileScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        editProfileScreen = new EditProfileScreen(getActivity());
        editProfileScreen.setListener(this);
        return editProfileScreen;
    }

    @Override
    protected EditProfilePresenter createPresenter() {
        return new EditProfilePresenter();
    }

    @Override
    protected EditProfilePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** EditProfilePresenter.View **************

    @Override
    public void addStudy(RestStudy restStudy) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TLStudyView studyView = new TLStudyView(getContext());
        studyView.setLayoutParams(params);

        studyView.setCourseName(restStudy.getCourse());
        studyView.setInstituteName(restStudy.getSchool());
        studyView.setCourseDate("Marzo 2016");

        editProfileScreen.addStudy(studyView);
    }

    //endregion

    //region ************** EditProfileScreen.Listener **************

    @Override
    public void onAddCoursePressed() {
        addDialogFragment(StudyDialogFragment.class, StudyDialogFragment.CODE);
    }

    @Override
    public void onSelectCountryPressed() {
        addDialogFragment(CountryDialogFragment.class, CountryDialogFragment.CODE);
    }

    @Override
    public void onSelectOccupationPressed() {
        addDialogFragment(OccupationDialogFragment.class, OccupationDialogFragment.CODE);
    }

    //endregion

}
