package com.cronosgroup.tinkerlink.view.status;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.presignuser.PreSignUserPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * PreSignUser Fragment
 */
public class StatusUserFragment extends MVPTinkerLinkFragment<PreSignUserPresenter, PreSignUserPresenter.View>
        implements PreSignUserPresenter.View, StatusUserScreen.Listener {

    // Vars

    // Views
    private StatusUserScreen statusUserScreen;

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
        statusUserScreen = new StatusUserScreen(getActivity());
        statusUserScreen.setListener(this);
        return statusUserScreen;
    }

    @Override
    protected PreSignUserPresenter createPresenter() {
        return new PreSignUserPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected PreSignUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** PreSignUserPresenter.View **************

    //endregion

    //region ************** PreSignUserScreen.Listener **************

    @Override
    public void onLoginPressed() {
        getPresenter().onLoginPressed();
    }

    @Override
    public void onSignPressed() {
        getPresenter().onSignPressed();
    }


    //endregion

}
