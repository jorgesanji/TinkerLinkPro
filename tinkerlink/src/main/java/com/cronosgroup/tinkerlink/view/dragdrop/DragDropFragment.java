package com.cronosgroup.tinkerlink.view.dragdrop;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.dragdrop.DrargDropPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * DragDrop Fragment
 */
public class DragDropFragment extends MVPTinkerLinkFragment<DrargDropPresenter, DrargDropPresenter.View>
        implements DrargDropPresenter.View, DragDropScreen.Listener {

    // Vars

    // Views
    private DragDropScreen editProfileScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        editProfileScreen = new DragDropScreen(getActivity());
        editProfileScreen.setListener(this);
        return editProfileScreen;
    }

    @Override
    protected DrargDropPresenter createPresenter() {
        return new DrargDropPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DrargDropPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** DrargDropPresenter.View **************

    //endregion

    //region ************** DrargDropScreen.Listener **************

    @Override
    public void onWatchNetwork() {
        getPresenter().onLaunchWatchNetwork();
    }

    @Override
    public void onWatchProfile() {
        getPresenter().onLaunchWatchProfile();
    }

    @Override
    public void onShare() {
        getPresenter().onLaunchShare();
    }

    @Override
    public void onSendMessage() {
        getPresenter().onLaunchSendMessage();
    }

    //endregion

}
