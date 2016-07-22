package com.cronosgroup.tinkerlink.view.dialog.country;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOCountrySelected;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class DialogFragment extends TinkerDialogFragment implements IOCountrySelected {

    public static final int CODE = 800;
    public static final String COUNTRY_SELECTED = "SELECTED";

    private DialogScreen DialogScreen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DialogScreen = new DialogScreen(getActivity(), this, appCountryManager);
        return DialogScreen;
    }

    @Override
    public void onCountrySelected(RestCountry country) {
        sendResult(country);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        DialogFragment prev = (DialogFragment) getFragmentManager().findFragmentByTag(DialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult(RestCountry country) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(COUNTRY_SELECTED, country);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(), CODE, intent);
    }
}
