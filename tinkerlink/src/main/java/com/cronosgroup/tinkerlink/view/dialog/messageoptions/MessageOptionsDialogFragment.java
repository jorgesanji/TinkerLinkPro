package com.cronosgroup.tinkerlink.view.dialog.messageoptions;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class MessageOptionsDialogFragment extends TinkerDialogFragment implements MessageOptionsDialogScreen.Listener {

    // Vars
    public static final int CODE = 128;

    // Views
    private MessageOptionsDialogScreen blockContactsDialogScreen;

    @Override
    protected void onDidAppear() {

    }

    @Override
    protected View getRootView() {
        blockContactsDialogScreen = new MessageOptionsDialogScreen(getActivity(), this);
        blockContactsDialogScreen.setTitle(getArguments().getString(TITLE_KEY));
        blockContactsDialogScreen.setMessage(getArguments().getString(DESCRIPTION_KEY));
        blockContactsDialogScreen.setActionButtonText(getArguments().getString(ACTION_BUTTON_KEY));
        return blockContactsDialogScreen;
    }

    @Override
    public void onCancelPressed() {
        dismiss();
    }

    @Override
    public void onConfirmedPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_ID_KEY, getArguments().getString(USER_ID_KEY));
        sendResult(bundle, MessageOptionsDialogFragment.CODE);
    }

}
