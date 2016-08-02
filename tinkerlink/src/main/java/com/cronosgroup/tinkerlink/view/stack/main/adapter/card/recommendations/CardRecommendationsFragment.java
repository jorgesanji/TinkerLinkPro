package com.cronosgroup.tinkerlink.view.stack.main.adapter.card.recommendations;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.presenter.stack.CardRecommendationsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.List;

/**
 * Stack Fragment
 */
public class CardRecommendationsFragment extends MVPTinkerLinkFragment<CardRecommendationsPresenter, CardRecommendationsPresenter.View> implements CardRecommendationsPresenter.View, CardRecommnedationsScreen.Listener {

    private CardRecommnedationsScreen cardRecommnedationsScreen;
    private StackActivity.Stack stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        stackType = (StackActivity.Stack) getArguments().getSerializable(StackActivity.STACK_TYPE);
    }

    @Override
    protected View getRootView() {
        cardRecommnedationsScreen = new CardRecommnedationsScreen(getActivity(), this);
        return cardRecommnedationsScreen;
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected CardRecommendationsPresenter createPresenter() {
        return new CardRecommendationsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CardRecommendationsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getRecommendations();
    }

    //region **************  CardRecommendationsScreen.Listener **************

    @Override
    public void onItemPressed(int position) {

    }

    //endregion

    //region **************  CardRecommendationsPresenter.View **************

    @Override
    public void setRecommendationsList(List<RestRecomendacion> list) {
        cardRecommnedationsScreen.setItems(list);
    }

    //endregion
}
