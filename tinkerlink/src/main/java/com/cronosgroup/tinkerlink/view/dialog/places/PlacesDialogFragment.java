package com.cronosgroup.tinkerlink.view.dialog.places;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class   PlacesDialogFragment extends TinkerDialogFragment implements PlacesDialogScreen.Listener {

    public static final String PLACE_SELECTED = "PLACE_SELECTED";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(PlacesDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return new PlacesDialogScreen(getActivity(), this);
    }

    @Override
    public void onItemSelected(Address prediction) {
        sendResult(prediction);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        PlacesDialogFragment prev = (PlacesDialogFragment) getFragmentManager().findFragmentByTag(PlacesDialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult(Address address) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PLACE_SELECTED, address);
        Intent intent = new Intent();
        intent.putExtras(bundle);
//        getTargetFragment().onActivityResult(
//                getTargetRequestCode(), CreateStackPresenter.CODE_SELECTED_PLACE, intent);
    }
}
