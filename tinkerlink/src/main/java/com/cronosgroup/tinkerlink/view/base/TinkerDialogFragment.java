package com.cronosgroup.tinkerlink.view.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dialog.category.CategoryDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class TinkerDialogFragment extends AppCompatDialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(CategoryDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
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
