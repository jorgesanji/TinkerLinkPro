package com.cronosgroup.tinkerlink.view.dialog.share;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.share.SharePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;


/**
 * ShareDialog Fragment
 */
public class ShareDialogFragment extends MVPTinkerLinkDialogFragment<SharePresenter, SharePresenter.View>
        implements SharePresenter.View, ShareDialogScreen.Listener {

    // Vars
    public static final int CODE = 123;

    // Views
    private ShareDialogScreen shareDialogScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        shareDialogScreen = new ShareDialogScreen(getActivity());
        shareDialogScreen.setListener(this);
        return shareDialogScreen;
    }

    @Override
    protected SharePresenter createPresenter() {
        return new SharePresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected SharePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        shareDialogScreen.show();
    }

    //endregion

    //region ************** SharePresenter.View **************


    //endregion

    //region ************** ShareDialogScreen.Listener **************

    @Override
    public void onClosePressed() {
        dismiss();
    }

    //endregion

}
