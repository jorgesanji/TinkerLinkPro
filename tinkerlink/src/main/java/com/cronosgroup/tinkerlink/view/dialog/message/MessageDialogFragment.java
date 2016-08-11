package com.cronosgroup.tinkerlink.view.dialog.message;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class MessageDialogFragment extends TinkerDialogFragment implements MessageDialogScreen.Listener {

    // Views
    private MessageDialogScreen messageDialogScreen;

    @Override
    protected void onDidAppear() {

    }

    @Override
    protected View getRootView() {
        messageDialogScreen = new MessageDialogScreen(getActivity());
        messageDialogScreen.setListener(this);

        Bundle bundle = getArguments();
        messageDialogScreen.setTitle(bundle.getString(TITLE_KEY));
        messageDialogScreen.setDescription(bundle.getString(DESCRIPTION_KEY));
        messageDialogScreen.setIcon(bundle.getInt(ICON_KEY));

        return messageDialogScreen;
    }

    @Override
    public void onOkPressed() {
        dismiss();
    }
}
