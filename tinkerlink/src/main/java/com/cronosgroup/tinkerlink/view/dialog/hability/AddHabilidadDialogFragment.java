package com.cronosgroup.tinkerlink.view.dialog.hability;

import android.app.Dialog;
import android.content.Intent;
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
public class AddHabilidadDialogFragment extends TinkerDialogFragment implements AddHabilidadDialogScreen.Listener {

    public static final String HABILITY_ADDED = "hability_added";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(AddHabilidadDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return new AddHabilidadDialogScreen(getActivity(), this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private void sendResult(String text) {
        Bundle bundle = new Bundle();
        bundle.putString(HABILITY_ADDED, text);
        Intent intent = new Intent();
        intent.putExtras(bundle);
//        getTargetFragment().onActivityResult(
//                getTargetRequestCode(), CreateStackPresenter.CODE_ADDED_HABILITY, intent);
    }

    @Override
    public void onAccept(String text) {
        sendResult(text);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AddHabilidadDialogFragment prev = (AddHabilidadDialogFragment) getFragmentManager().findFragmentByTag(AddHabilidadDialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    @Override
    public void onCancel() {
        dismiss();
    }
}
