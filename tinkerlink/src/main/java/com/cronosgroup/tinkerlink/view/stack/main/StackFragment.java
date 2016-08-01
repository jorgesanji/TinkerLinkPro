package com.cronosgroup.tinkerlink.view.stack.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.ShowDetailCardsEvent;
import com.cronosgroup.tinkerlink.event.ShowOverLaySelectorEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.animation.Animations;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Stack Fragment
 */
public class StackFragment extends MVPTinkerLinkFragment<StackPresenter, StackPresenter.View> implements StackPresenter.View, StackScreen.Listener {

    private StackScreen stackScreen;
    private StackActivity.Stack stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        stackType = (StackActivity.Stack) getArguments().getSerializable(StackActivity.STACK_TYPE);
    }

    @Override
    protected View getRootView() {
        stackScreen = new StackScreen(getActivity(), this, getFragmentManager());
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
        return new StackPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected StackPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        Animations.revealFromTop(stackScreen.getAnimableView(), stackType.getStackColor(), new Animations.Listener() {
            @Override
            public void onFinishAnimation() {
                stackScreen.animBackground();
            }
        });

        stackScreen.initView(stackType);
        getPresenter().getAllCards("0");
    }

    //region **************  StackScreen.Listener **************

    @Override
    public void onSelectCardsPressed() {
        getPresenter().onSelectCardsType();
    }

    //endregion

    //region **************  StackPresenter.View **************

    @Override
    public int getCurrentIndexPage() {
        return stackScreen.getCurrentIndexPage();
    }

    @Override
    public List<RestPost> getItems() {
        return stackScreen.getItems();
    }

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
    public StackActivity.Stack getType() {
        return stackType;
    }

    //endregion

    //region **************  EevntBus  **************

    @Subscribe
    public void onEventMainThread(ShowDetailCardsEvent event) {
        getPresenter().showDetailCards();
    }

    @Subscribe
    public void onEventMainThread(ShowOverLaySelectorEvent event) {
        stackScreen.showOverlaySelector();
    }
}
