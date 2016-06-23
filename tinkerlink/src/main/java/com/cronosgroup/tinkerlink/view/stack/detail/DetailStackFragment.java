package com.cronosgroup.tinkerlink.view.stack.detail;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.DetailStackPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.List;


/**
 * Stack Fragment
 */
public class DetailStackFragment extends MVPFragment<DetailStackPresenter, DetailStackPresenter.View>
        implements DetailStackPresenter.View, DetailStackPresenter.Actions, DetailStackScreen.Listener {

    private DetailStackScreen detailStackScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        detailStackScreen = new DetailStackScreen(getActivity(), this);
        return detailStackScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected DetailStackPresenter createPresenter() {
        return new DetailStackPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DetailStackPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //region **************  DetailStackScreen.Listener **************


    //endregion

    //region **************  DetailStackPresenter.View **************

    @Override
    public void setCards(List<RestPost> cars) {

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
