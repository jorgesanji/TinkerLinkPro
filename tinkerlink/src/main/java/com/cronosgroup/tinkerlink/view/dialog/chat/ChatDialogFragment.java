package com.cronosgroup.tinkerlink.view.dialog.chat;

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
public class ChatDialogFragment extends TinkerDialogFragment implements ChatDialogScreen.Listener {

    public static final int CHAT_CODE = 7000;

    public static final String TEXT_TO_SEND = "text_to_send";
    public static final String ID_USER = "id_user";
    public static final String NAME_USER = "name_user";

    private String mIdUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(ChatDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
        mIdUser = getArguments().getString(ID_USER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return new ChatDialogScreen(getActivity(), getArguments().getString(NAME_USER), this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onSendChat(String chat) {
        sendResult(chat);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ChatDialogFragment prev = (ChatDialogFragment) getFragmentManager().findFragmentByTag(ChatDialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    @Override
    public void onCancelChat() {
        dismiss();
    }

    private void sendResult(String text) {
        Bundle bundle = new Bundle();
        bundle.putString(TEXT_TO_SEND, text);
        bundle.putString(ID_USER, mIdUser);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(), CHAT_CODE, intent);
    }

}
