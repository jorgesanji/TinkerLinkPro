package com.cronosgroup.tinkerlink.view.stack;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.animation.RevealAnimation;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * StackScreen Fragment
 */
public class StackFragment extends MVPTinkerLinkFragment<StackPresenter, StackPresenter.View> implements StackPresenter.View, StackScreen.Listener {

    private StackScreen stackScreen;
    private StackCardType stackType;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        stackScreen = new StackScreen(getActivity(), this);
        return stackScreen;
    }

    @Override
    protected void onDidAppear() {
        RevealAnimation.revealFromBottom(stackScreen.getAnimableView(), stackType.getStackColor(), new RevealAnimation.Listener() {
            @Override
            public void onFinishAnimation() {
                stackScreen.animBackground();
            }
        });

        stackScreen.initPager(getActivity().getSupportFragmentManager(), getType());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        stackType = (StackCardType) getArguments().getSerializable(StackActivity.STACK_TYPE);
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
        } else if (id == R.id.action_stack_filter) {
            getPresenter().onFilterCardsPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    //region **************  StackScreen.View **************

    @Override
    public void onCreateCardPressed() {
        getPresenter().onCreateCardsPressed();
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

}
