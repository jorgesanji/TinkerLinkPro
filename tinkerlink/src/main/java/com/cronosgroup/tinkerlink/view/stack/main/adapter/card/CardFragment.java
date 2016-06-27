package com.cronosgroup.tinkerlink.view.stack.main.adapter.card;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;

/**
 * Created by jorgesanmartin on 6/22/16.
 */

public class CardFragment extends MVPFragment<CardPresenter, CardPresenter.View> implements CardPresenter.View, CardScreen.Listener {

    private CardScreen cardScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        cardScreen = new CardScreen(getContext(), this);
        return cardScreen;
    }

    @Override
    protected CardPresenter createPresenter() {
        return new CardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CardPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //region **************  CardScreen.Listener **************

    @Override
    public void showDetailPressed() {
        getPresenter().onLaunhDetailStack();
    }
}
