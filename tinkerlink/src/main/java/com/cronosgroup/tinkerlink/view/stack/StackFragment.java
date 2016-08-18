package com.cronosgroup.tinkerlink.view.stack;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.animation.RevealAnimation;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.event.ShowDetailCardsEvent;
import com.cronosgroup.tinkerlink.event.ShowOverLaySelectorEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.network.NetworkDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.share.ShareDialogFragment;
import com.cronosgroup.tinkerlink.view.dragdrop.DragDropScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * StackCardType Fragment
 */
public class StackFragment extends MVPTinkerLinkFragment<StackPresenter, StackPresenter.View> implements StackPresenter.View, StackScreen.Listener, DragDropScreen.Listener {

    private StackScreen stackScreen;
    private StackCardType stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        stackType = (StackCardType) getArguments().getSerializable(StackActivity.STACK_TYPE);
    }

    @Override
    protected View getRootView() {
        stackScreen = new StackScreen(getActivity(), this);
        stackScreen.setDragdropListener(this);
        return stackScreen;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.stack_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_stack_search) {
            getPresenter().onSearchCardsPressed();
            return true;
        } else if (id == R.id.action_stack_add_card) {
            getPresenter().onCreateCardsPressed();
            return true;
        } else if (id == R.id.action_stack_filter) {
            getPresenter().onFilterCardsPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected StackPresenter createPresenter() {
        return new StackPresenter();
    }

    @Override
    protected StackPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        RevealAnimation.revealFromBottom(stackScreen.getAnimableView(), stackType.getStackColor(), new RevealAnimation.Listener() {
            @Override
            public void onFinishAnimation() {
                stackScreen.animBackground();
            }
        });

        stackScreen.initPager(getActivity().getSupportFragmentManager());
    }

    //region **************  DragDropScreen.Listener **************

    @Override
    public void onWatchNetwork() {
        addDialogFragment(NetworkDialogFragment.class, NetworkDialogFragment.CODE);
    }

    @Override
    public void onWatchProfile() {
        getPresenter().onWatchProfilePressed();
    }

    @Override
    public void onShare() {
        addDialogFragment(ShareDialogFragment.class, ShareDialogFragment.CODE);
    }

    @Override
    public void onWritteMessage() {
        getPresenter().onWritteMessageSelected();
    }

    @Override
    public void onCloseDragView() {
        stackScreen.dissmissOverlaySelector();
    }


    //endregion

    //region **************  StackPresenter.View **************


    @Override
    public boolean isUser() {
        return false;
    }

    @Override
    public RestUser getUser() {
        return null;
    }

    @Override
    public StackCardType getType() {
        return stackType;
    }

    //endregion

    //region **************  EevntBus  **************

    @Subscribe
    public void onEventMainThread(ShowDetailCardsEvent event) {
        getPresenter().showDetailCard();
    }

    @Subscribe
    public void onEventMainThread(ShowOverLaySelectorEvent event) {
        stackScreen.showOverlaySelector();
    }
}
