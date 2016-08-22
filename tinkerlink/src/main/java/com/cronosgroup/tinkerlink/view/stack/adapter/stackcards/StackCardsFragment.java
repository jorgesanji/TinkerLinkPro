package com.cronosgroup.tinkerlink.view.stack.adapter.stackcards;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackCardsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.dialog.network.NetworkDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.share.ShareDialogFragment;
import com.cronosgroup.tinkerlink.view.dragdrop.DragAndDropScreen;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.List;

/**
 * StackCards Fragment
 */
public class StackCardsFragment extends MVPTinkerLinkFragment<StackCardsPresenter, StackCardsPresenter.View> implements
        StackCardsPresenter.View, StackCardsScreen.Listener, DragAndDropScreen.Listener {

    // Vars
    private StackCardType stackType;

    // Views
    private StackCardsScreen stackScreen;
    private DragAndDropScreen dragAndDropScreen;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stackType = (StackCardType) getArguments().getSerializable(StackActivity.STACK_TYPE);
    }

    @Override
    protected View getRootView() {
        addDragAndDropOverlay();
        stackScreen = new StackCardsScreen(getActivity(), this);
        return stackScreen;
    }

    @Override
    protected void onDidAppear() {
        stackScreen.initView(stackType);
        getPresenter().getAllCards("0");
    }

    @Override
    public void showLoading() {
        stackScreen.showLoading();
    }

    @Override
    public void hideLoading() {
        stackScreen.hideLoading();
    }

    private void addDragAndDropOverlay() {
        dragAndDropScreen = (DragAndDropScreen) ((TinkerLinkActivity) getActivity()).addOverLayView(new DragAndDropScreen(getActivity()), false);
        dragAndDropScreen.setListener(this);
    }

    private void showOverLay() {
        ((TinkerLinkActivity) getActivity()).showOverLayView();
    }

    private void hideOverLay() {
        ((TinkerLinkActivity) getActivity()).hideOverLayView();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected StackCardsPresenter createPresenter() {
        return new StackCardsPresenter();
    }

    @Override
    protected StackCardsPresenter.View getPresenterView() {
        return this;
    }

    //region **************  StackCardsScreen.Listener **************

    @Override
    public void onCardPressed(int position) {
        getPresenter().onLaunhDetailStack();
    }

    @Override
    public void onShowOverLaySelector(int position) {
        showOverLay();
    }

    //endregion

    //region **************  DragAndDropScreen.Listener **************

    @Override
    public void onWatchNetwork() {
        addDialogFragment(NetworkDialogFragment.class, NetworkDialogFragment.CODE);
    }

    @Override
    public void onWatchProfile() {
        getPresenter().onLaunchProfilePressed();
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
        hideOverLay();
    }

    //endregion

    //region **************  StackCardsPresenter.View **************

    @Override
    public int getCurrentIndexPage() {
        return stackScreen.getCurrentIndexPage();
    }

    @Override
    public List<TLCard> getItems() {
        return stackScreen.getItems();
    }

    @Override
    public void setCards(List<TLCard> cars) {
        stackScreen.addItems(cars);
    }

    @Override
    public boolean isFromUser() {
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
}
