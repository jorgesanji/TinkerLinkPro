package com.cronosgroup.tinkerlink.view.home.fragment.chat;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.presenter.messages.ChatPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;


/**
 * Messages Fragment
 */
public class ChatFragment extends MVPTinkerLinkFragment<ChatPresenter, ChatPresenter.View>
        implements ChatPresenter.View, ChatScreen.Listener {

    private ChatScreen chatScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        chatScreen = new ChatScreen(getActivity(), this);
        return chatScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected ChatPresenter createPresenter() {
        return new ChatPresenter();
    }

    @Override
    protected ChatPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getChats();
    }

    //region **************  Chatcreen.Listener **************

    @Override
    public void onItemClicked(int position) {
        getPresenter().onItemClicked(position);
    }

    //endregion

    //region **************  ChatPresenter.View **************

    @Override
    public void setChats(List<RestChat> list) {
        chatScreen.setChats(list);
    }

    @Override
    public List<RestChat> getItems() {
        return chatScreen.getItems();
    }

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
