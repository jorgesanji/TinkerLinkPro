package com.cronosgroup.tinkerlink.view.dialog.study;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestStudy;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class StudyDialogFragment extends TinkerDialogFragment implements StudyDialogScreen.Listener {

    public static final int CODE = 679;
    public static final String STUDY_ADDED = "study_added";
    private StudyDialogScreen studyDialogScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        studyDialogScreen = new StudyDialogScreen(getActivity());
        studyDialogScreen.setListener(this);
        return studyDialogScreen;
    }

    @Override
    public void onCancelPressed() {
        dismiss();
    }

    @Override
    public void onAddPressed() {
        sendResult();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        StudyDialogFragment prev = (StudyDialogFragment) getFragmentManager().findFragmentByTag(StudyDialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult() {
        if (studyDialogScreen.getCourseName().length() > 0 && studyDialogScreen.getInstitutionName().length() > 0) {
            RestStudy estudio = new RestStudy();
            estudio.setCourse(studyDialogScreen.getCourseName());
            estudio.setSchool(studyDialogScreen.getInstitutionName());
            Bundle bundle = new Bundle();
            bundle.putSerializable(STUDY_ADDED, estudio);
            sendResult(bundle, StudyDialogFragment.CODE);
        }
    }
}
