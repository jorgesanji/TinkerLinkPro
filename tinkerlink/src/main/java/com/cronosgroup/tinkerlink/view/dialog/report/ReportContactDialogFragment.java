package com.cronosgroup.tinkerlink.view.dialog.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ReportContactDialogFragment extends TinkerDialogFragment implements ReportContactDialogScreen.Listener {

    // Vars
    public static final int CODE = 128;

    // Views
    private ReportContactDialogScreen blockContactsDialogScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        blockContactsDialogScreen = new ReportContactDialogScreen(getActivity(), this);
        blockContactsDialogScreen.setUserNameToReport(getArguments().getString(USER_NAME_KEY));
        return blockContactsDialogScreen;
    }

    @Override
    public void onCancelPressed() {
        dismiss();
    }

    @Override
    public void onConfirmedPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ACTION_DONE_KEY, blockContactsDialogScreen.getActionSelected());
        bundle.putString(ACTION_DONE_KEY, getArguments().getString(USER_ID_KEY));
        sendResult(bundle, ReportContactDialogFragment.CODE);
    }

}
