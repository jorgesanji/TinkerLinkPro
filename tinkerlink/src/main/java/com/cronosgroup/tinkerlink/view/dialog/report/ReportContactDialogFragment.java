package com.cronosgroup.tinkerlink.view.dialog.report;

import android.os.Bundle;
import android.view.View;

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
    protected void onDidAppear() {

    }

    @Override
    protected View getRootView() {
        blockContactsDialogScreen = new ReportContactDialogScreen(getActivity(), this);
        blockContactsDialogScreen.setUserNameToReport(getArguments().getString(USER_NAME_KEY));
        return blockContactsDialogScreen;    }

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
