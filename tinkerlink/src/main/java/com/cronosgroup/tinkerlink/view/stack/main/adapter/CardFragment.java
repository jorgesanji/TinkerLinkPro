package com.cronosgroup.tinkerlink.view.stack.main.adapter;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;

/**
 * Created by jorgesanmartin on 6/22/16.
 */

public class CardFragment extends MVPFragment<CardPresenter, CardPresenter.View> implements CardPresenter.View, CardScreen.Listener {

    @Override
    protected View getRootView() {
        return new CardScreen(getContext());
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
}
