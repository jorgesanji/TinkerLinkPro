package com.cronosgroup.tinkerlink.view.home.fragment.messages;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.messages.MessagesPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;


/**
 * Messages Fragment
 */
public class MessagesFragment extends MVPFragment<MessagesPresenter, MessagesPresenter.View>
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
            ((ToolBarActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
