package com.cronosgroup.tinkerlink.view.dialog.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class MessageDialogFragment extends TinkerDialogFragment implements MessageDialogScreen.Listener {

    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_ICON = "icon";

    private MessageDialogScreen messageDialogScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        messageDialogScreen = new MessageDialogScreen(getActivity());
        messageDialogScreen.setListener(this);

        Bundle bundle = getArguments();
        messageDialogScreen.setTitle(bundle.getString(KEY_TITLE));
        messageDialogScreen.setDescription(bundle.getString(KEY_DESCRIPTION));
        messageDialogScreen.setIcon(bundle.getInt(KEY_ICON));

        return messageDialogScreen;
    }

    @Override
    public void onOkPressed() {
        dismiss();
    }
}
