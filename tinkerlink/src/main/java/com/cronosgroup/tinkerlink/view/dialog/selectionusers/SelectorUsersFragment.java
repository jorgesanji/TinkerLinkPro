package com.cronosgroup.tinkerlink.view.dialog.selectionusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class SelectorUsersFragment extends TinkerDialogFragment implements SelectorUsersScreen.Listener {

    public static final String USERS_SELECTED = "users_selected";

    private SelectorUsersScreen selectorUsersScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(SelectorUsersFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        selectorUsersScreen = new SelectorUsersScreen(getActivity(), TinkerLinkApplication.getApp().getTinkerLinkContacts());
        selectorUsersScreen.setListener(this);
        return selectorUsersScreen;
    }

    private void dissmiss() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        SelectorUsersFragment prev = (SelectorUsersFragment) getFragmentManager().findFragmentByTag(SelectorUsersFragment.class.toString());
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
        ft.addToBackStack(null);
    }

    private void sendResult() {
        List<RestUser> restUserList = selectorUsersScreen.getUsersSelected();
        Bundle bundle = new Bundle();
        bundle.putSerializable(USERS_SELECTED, (ArrayList) restUserList);
        Intent intent = new Intent();
        intent.putExtras(bundle);
//        getTargetFragment().onActivityResult(
//                getTargetRequestCode(), RequestRecommendationPresenter.CODE_RECOMMENDATION, intent);
    }

    //region **************  SelectorUsersScreen.CLickListener **************

    @Override
    public void onCancelPressed() {
        dissmiss();
    }

    @Override
    public void onAcceptPressed() {
        sendResult();
        dissmiss();
    }

    //endregion

}
