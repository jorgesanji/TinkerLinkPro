package com.cronosgroup.tinkerlink.view.createcard;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.event.UpdateInfoCardEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.createcard.CreateCardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Create card Fragment
 */
public class CreateCardFragment extends MVPTinkerLinkFragment<CreateCardPresenter, CreateCardPresenter.View>
        implements CreateCardPresenter.View, CreateCardScreen.Listener {

    // Vars
    private StackCardType type;

    // Views
    private CreateCardScreen createCardScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = (StackCardType) getArguments().getSerializable(StackActivity.STACK_TYPE);
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

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        createCardScreen = new CreateCardScreen(getActivity());
        createCardScreen.setListener(this);
        return createCardScreen;
    }

    @Override
    protected CreateCardPresenter createPresenter() {
        return new CreateCardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CreateCardPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        createCardScreen.initAdapter(getActivity().getSupportFragmentManager(), type);
    }

    //endregion

    //region ************** CreateCardPresenter.View **************

    @Override
    public RestPost getCardData() {
        return null;
    }

    //endregion

    //region ************** CreateCardScreen.Listener **************

    @Override
    public void nextPage(int position) {
        createCardScreen.goToNextPage();
    }

    @Override
    public void onPrevisualizePressed() {
        getPresenter().onPrevisualizedPressed();
    }

    //endregion

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(UpdateInfoCardEvent event) {
        createCardScreen.moveToPage(event.getPage());
    }

    //endregion

    public boolean onBackPressed() {
        return createCardScreen.showPreviousPage();
    }

}
