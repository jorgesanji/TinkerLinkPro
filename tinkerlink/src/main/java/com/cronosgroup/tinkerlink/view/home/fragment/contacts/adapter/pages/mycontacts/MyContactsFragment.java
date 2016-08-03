package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.mycontacts;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.presenter.contacts.MyContactsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.blockcontacts.BlockContactsDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.messageoptions.MessageOptionsDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class MyContactsFragment extends MVPTinkerLinkFragment<MyContactsPresenter, MyContactsPresenter.View>
        implements MyContactsPresenter.View, MyContactsScreen.Listener {

    // Vars

    // Views
    private MyContactsScreen contactsUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        contactsUserScreen = new MyContactsScreen(getActivity());
        contactsUserScreen.setListener(this);
        return contactsUserScreen;
    }

    @Override
    protected MyContactsPresenter createPresenter() {
        return new MyContactsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected MyContactsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getContacts();
    }

    //endregion

    //region ************** MyContactsPresenter.View **************

    @Override
    public void setContacts(List<RestContacto> list) {
        contactsUserScreen.setItems(list);
    }

    @Override
    public List<RestContacto> getItems() {
        return contactsUserScreen.getItems();
    }

    //endregion

    //region ************** MyContactsScreen.Listener **************

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onWriteMessagePressed(int position) {
        getPresenter().onWritteMessageSelected(position);
    }

    @Override
    public void onRemoveContactPressed(int position) {
        RestContacto restContacto = getItems().get(position);
        String userName = restContacto.getUser().getName();
        String userId = restContacto.getUser().getId();
        Bundle bundle = new Bundle();
        bundle.putString(MessageOptionsDialogFragment.USER_ID_KEY, userId);
        showDialogMessageOptions(
                getResources().getString(R.string.dialog_message_remove_user_options_title),
                String.format(getResources().getString(R.string.dialog_message_remove_user_options_message), userName),
                bundle);
    }

    @Override
    public void onBlockContactPressed(int position) {
        RestContacto restContacto = getItems().get(position);
        String userName = restContacto.getUser().getName();
        String userId = restContacto.getUser().getId();
        Bundle bundle = new Bundle();
        bundle.putString(BlockContactsDialogFragment.USER_NAME_KEY, userName);
        bundle.putString(BlockContactsDialogFragment.USER_ID_KEY, userId);
        addDialogFragment(BlockContactsDialogFragment.class, BlockContactsDialogFragment.CODE, bundle);
    }

    //endregion

}
