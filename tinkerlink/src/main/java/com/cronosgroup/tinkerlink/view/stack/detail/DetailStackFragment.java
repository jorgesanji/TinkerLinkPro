package com.cronosgroup.tinkerlink.view.stack.detail;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.DetailStackPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.List;

/**
 * Stack Fragment
 */
public class DetailStackFragment extends MVPTinkerLinkFragment<DetailStackPresenter, DetailStackPresenter.View>
        implements DetailStackPresenter.View, DetailStackPresenter.Actions, DetailStackScreen.Listener {

    private DetailStackScreen detailStackScreen;
    private StackActivity.Stack stackType;
    private List<RestPost> list;
    private int currentItem;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stackType = (StackActivity.Stack) getArguments().getSerializable(StackActivity.STACK_TYPE);
        list = (List<RestPost>) getArguments().getSerializable(DetailStackActivity.STACK_ITEMS);
        currentItem = getArguments().getInt(DetailStackActivity.STACK_CURRENT_ITEM);
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).getSupportActionBar().setTitle(getString(stackType.getStackTitle()));
        }
    }

    @Override
    protected View getRootView() {
        detailStackScreen = new DetailStackScreen(getActivity(), this, getFragmentManager());
        return detailStackScreen;
    }

    @Override
    protected void onDidAppear() {
        detailStackScreen.initView(stackType, list, currentItem);
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

    //region **************  DetailStackScreen.Listener **************


    //endregion

    //region **************  DetailStackPresenter.View **************

    @Override
    public boolean isUser() {
        return false;
    }

    @Override
    public RestUser getUser() {
        return null;
    }

    @Override
    public StackActivity.Stack getType() {
        return stackType;
    }

    //endregion
}
