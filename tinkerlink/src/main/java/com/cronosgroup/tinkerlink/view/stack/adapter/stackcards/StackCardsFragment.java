package com.cronosgroup.tinkerlink.view.stack.adapter.stackcards;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackCardsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.List;

/**
 * StackCards Fragment
 */
public class StackCardsFragment extends MVPTinkerLinkFragment<StackCardsPresenter, StackCardsPresenter.View> implements StackCardsPresenter.View, StackCardsScreen.Listener {

    private StackCardsScreen stackScreen;
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
        stackScreen = new StackCardsScreen(getActivity(), this);
        return stackScreen;
    }

    @Override
    protected void onDidAppear() {
        stackScreen.initView(stackType);
        getPresenter().getAllCards("0");
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

    }

    //endregion

    //region **************  StackCardsPresenter.View **************

    @Override
    public int getCurrentIndexPage() {
        return stackScreen.getCurrentIndexPage();
    }

    @Override
    public List<RestCard> getItems() {
        return stackScreen.getItems();
    }

    @Override
    public void setCards(List<RestCard> cars) {
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
