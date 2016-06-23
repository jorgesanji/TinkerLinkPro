package com.cronosgroup.tinkerlink.view.stack.main;

import android.graphics.Color;
import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.animation.Animations;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;


/**
 * Stack Fragment
 */
public class StackFragment extends MVPFragment<StackPresenter, StackPresenter.View>
        implements StackPresenter.View, StackPresenter.Actions, StackScreen.Listener {

    private StackScreen stackScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        stackScreen = new StackScreen(getActivity());
        stackScreen.setListener(this);
        return stackScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected StackPresenter createPresenter() {
        return new StackPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected StackPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        Animations.revealFromTop(stackScreen, R.color.tinkercolor_30, Color.WHITE, null);
        stackScreen.initAdapter(getFragmentManager());
        getPresenter().getAllCards("0");
    }

    //region **************  StackScreen.Listener **************


    //endregion

    //region **************  StackPresenter.View **************

    @Override
    public void setCards(List<RestPost> cars) {
        stackScreen.addItems(cars);
    }

    @Override
    public boolean isUser() {
        return false;
    }

    @Override
    public RestUser getUser() {
        return null;
    }

    @Override
    public int getType() {
        return StackActivity.TYPE_LINKER;
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
