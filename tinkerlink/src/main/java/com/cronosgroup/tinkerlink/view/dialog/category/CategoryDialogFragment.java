package com.cronosgroup.tinkerlink.view.dialog.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CategoryDialogFragment extends TinkerDialogFragment implements CategoryDialogScreen.Listener {

    public static final int CODE = 890;
    public static final String CATEGORY_SELECTED = "CATEGORY_SELECTED";

    private CategoryDialogScreen categoryDialogScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(CategoryDialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        categoryDialogScreen = new CategoryDialogScreen(getActivity(), (getArguments().getInt(StackCard.TYPE_CARD) == StackCardActivity.TYPE_LINKER), this);
        categoryDialogScreen = new CategoryDialogScreen(getActivity(), true, this);
        return categoryDialogScreen;
    }

    @Override
    public void onItemSelected(RestCategoria categoria) {
        sendResult(categoria);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CategoryDialogFragment prev = (CategoryDialogFragment) getFragmentManager().findFragmentByTag(CategoryDialogFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult(RestCategoria country) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CATEGORY_SELECTED, country);
        Intent intent = new Intent();
        intent.putExtras(bundle);
//        getTargetFragment().onActivityResult(
//                getTargetRequestCode(), CreateStackPresenter.CODE_SELECTED_CATEGORY, intent);
    }
}
