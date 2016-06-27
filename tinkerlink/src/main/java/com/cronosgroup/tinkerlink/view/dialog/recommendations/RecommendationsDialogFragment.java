package com.cronosgroup.tinkerlink.view.dialog.recommendations;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOLoadRecomendations;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class RecommendationsDialogFragment extends TinkerDialogFragment implements IOLoadRecomendations {

    public static final String ID_USER = "id_user";
    public static final String NAME_USER = "name_user";

    // Vars
    private String mIdUser;
    private RecommendationsDialogScreen recommendationsDialogScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(RecommendationsDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
        mIdUser = getArguments().getString(ID_USER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recommendationsDialogScreen = new RecommendationsDialogScreen(getActivity(), getArguments().getString(NAME_USER));
        return recommendationsDialogScreen;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onLoadRecommendations(List<RestRecomendacion> list) {
        if (list == null) {
            dismiss();
        } else {
            recommendationsDialogScreen.setRecommendations(list);
        }
    }
}
