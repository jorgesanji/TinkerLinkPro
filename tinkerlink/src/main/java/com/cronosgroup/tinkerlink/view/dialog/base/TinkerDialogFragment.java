package com.cronosgroup.tinkerlink.view.dialog.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class TinkerDialogFragment extends AppCompatDialogFragment {

    public static final String ACTION_DONE_KEY = "action_added";
    public static final String TITLE_KEY = "title";
    public static final String DESCRIPTION_KEY = "description";
    public static final String ACTION_BUTTON_KEY = "action_button_key";
    public static final String ICON_KEY = "icon";
    public static final String USER_NAME_KEY = "user_name";
    public static final String USER_ID_KEY = "user_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(AppCompatDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    protected void sendResult(Bundle bundle, int code) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(), code, intent);
        dismiss();
    }

}
