package com.cronosgroup.tinkerlink.view.status;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.userstatus.UserStatusPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * UserStatus Fragment
 */
public class UserStatusFragment extends MVPTinkerLinkFragment<UserStatusPresenter, UserStatusPresenter.View>
        implements UserStatusPresenter.View, UserStatusScreen.Listener {

    // Vars

    // Views
    private UserStatusScreen statusUserScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.status_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_publish_status) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        statusUserScreen = new UserStatusScreen(getActivity());
        statusUserScreen.setListener(this);
        return statusUserScreen;
    }

    @Override
    protected UserStatusPresenter createPresenter() {
        return new UserStatusPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected UserStatusPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** UserStatusPresenter.View **************

    //endregion

    //region ************** UserStatusScreen.Listener **************

    //endregion

}
