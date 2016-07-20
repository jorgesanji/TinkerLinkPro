package com.cronosgroup.tinkerlink.view.chatuser;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.chatuser.ChatUserPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Sign Fragment
 */
public class ChatUserFragment extends MVPTinkerLinkFragment<ChatUserPresenter, ChatUserPresenter.View>
        implements ChatUserPresenter.View, ChatUserScreen.Listener {

    // Vars

    // Views
    private ChatUserScreen chatUserScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.chat_user_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove_chat) {
        } else if (id == R.id.action_report_chat) {
        } else if (id == R.id.action_block_contact) {
        }

        return super.onOptionsItemSelected(item);
    }

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        chatUserScreen = new ChatUserScreen(getActivity());
        chatUserScreen.setListener(this);
        return chatUserScreen;
    }

    @Override
    protected ChatUserPresenter createPresenter() {
        return new ChatUserPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ChatUserPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ChatUserPresenter.View **************

    //endregion

    //region ************** ChatUserScreen.Listener **************

    @Override
    public void getMessages() {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void cameraPressed() {
        getPresenter().launchCamera();
    }

    @Override
    public void galleryPressed() {
        getPresenter().launchGallery();
    }

    //endregion

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
