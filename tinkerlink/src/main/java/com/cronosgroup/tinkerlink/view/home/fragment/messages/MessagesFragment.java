package com.cronosgroup.tinkerlink.view.home.fragment.messages;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.messages.MessagesPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;


/**
 * Messages Fragment
 */
public class MessagesFragment extends MVPTinkerLinkFragment<MessagesPresenter, MessagesPresenter.View>
        implements MessagesPresenter.View, MessagesPresenter.Actions, MessagesScreen.Listener {

    private MessagesScreen messagesScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        messagesScreen = new MessagesScreen(getActivity());
        messagesScreen.setListener(this);
        return messagesScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected MessagesPresenter createPresenter() {
        return new MessagesPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected MessagesPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //region **************  ContactsScreen.Listener **************


    //endregion

    //region **************  ContactsPresenter.View **************

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
