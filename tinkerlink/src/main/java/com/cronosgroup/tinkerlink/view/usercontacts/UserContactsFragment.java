package com.cronosgroup.tinkerlink.view.usercontacts;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.usercontacts.UserContactsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * UserContacts Fragment
 */
public class UserContactsFragment extends MVPTinkerLinkFragment<UserContactsPresenter, UserContactsPresenter.View>
        implements UserContactsPresenter.View, UserContactsScreen.Listener {

    // Vars

    // Views
    private UserContactsScreen userContactsScreen;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.contacts_search_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search_contacts) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        userContactsScreen = new UserContactsScreen(getActivity());
        userContactsScreen.setListener(this);
        return userContactsScreen;
    }

    @Override
    protected UserContactsPresenter createPresenter() {
        return new UserContactsPresenter();
    }

    @Override
    protected UserContactsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        userContactsScreen.initPager(getActivity().getSupportFragmentManager());
    }

    //endregion

    //region ************** UserContactsPresenter.View **************


    //endregion

    //region ************** UserContactsScreen.Listener **************

    //endregion

}
