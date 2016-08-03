package com.cronosgroup.tinkerlink.view.dialog.messageoptions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
