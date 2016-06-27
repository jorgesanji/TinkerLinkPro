package com.cronosgroup.tinkerlink.view.dialog.recommendations;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 2/5/16.
 */
public class AcceptRecommendationsFragment extends TinkerDialogFragment implements AcceptRecommendationsDialogScreen.Listener {

    public static final String ID_NOTIFICATION = "id_notification";
    public static final String INDEX_NOTIFICATION = "index";

    public static final String STATUS = "status";

    // Vars
    private RestNotificacion restNotificacion;
    private AcceptRecommendationsDialogScreen recommendationsDialogScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(RecommendationsDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
        restNotificacion = (RestNotificacion) getArguments().getSerializable(ID_NOTIFICATION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recommendationsDialogScreen = new AcceptRecommendationsDialogScreen(getActivity());
        recommendationsDialogScreen.setListener(this);
        return recommendationsDialogScreen;
    }

    @Override
    public void onResume() {
        super.onResume();
        recommendationsDialogScreen.setNameUser(restNotificacion.getUser().getUser().getName());
        recommendationsDialogScreen.setDescription(restNotificacion.getTexto());
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    //*********** AcceptRecommendationsDialogScreen.Listener ********

    @Override
    public void cancelPressed() {
        closeAndResult(false);
    }

    @Override
    public void acceptPressed() {
        closeAndResult(true);
    }

    //EndRegion

    private void closeAndResult(boolean accept) {
        sendResult(accept);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AcceptRecommendationsFragment prev = (AcceptRecommendationsFragment) getFragmentManager().findFragmentByTag(AcceptRecommendationsFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult(boolean accept) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(STATUS, accept);
        bundle.putSerializable(ID_NOTIFICATION, restNotificacion);
        Intent intent = new Intent();
        intent.putExtras(bundle);
//        getTargetFragment().onActivityResult(
//                getTargetRequestCode(), NotificationsPresenter.CODE_NOTIFICATION, intent);
    }
}
