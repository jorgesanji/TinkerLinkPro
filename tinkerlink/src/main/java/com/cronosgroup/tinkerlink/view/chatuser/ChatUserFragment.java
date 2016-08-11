package com.cronosgroup.tinkerlink.view.chatuser;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.chatuser.ChatUserPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.blockcontacts.BlockContactsDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.messageoptions.MessageOptionsDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.report.ReportContactDialogFragment;


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
        Bundle bundle = new Bundle();
        bundle.putString(MessageOptionsDialogFragment.USER_ID_KEY, "111111");
        bundle.putString(BlockContactsDialogFragment.USER_NAME_KEY, "Jorge Sanmartin");
        if (id == R.id.action_remove_chat) {
            showDialogMessageOptions(
                    getResources().getString(R.string.dialog_remove_chat_title),
                    getResources().getString(R.string.dialog_remove_chat_message),
                    getResources().getString(R.string.dialog_remove_chat_action_text),
                    bundle);
        } else if (id == R.id.action_report_chat) {
            addDialogFragment(ReportContactDialogFragment.class, ReportContactDialogFragment.CODE, bundle);
        } else if (id == R.id.action_block_contact) {
            addDialogFragment(BlockContactsDialogFragment.class, BlockContactsDialogFragment.CODE, bundle);
        }
        return true;
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
        return new ChatUserPresenter();
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

}
