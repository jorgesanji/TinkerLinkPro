package com.cronosgroup.tinkerlink.presenter.stack;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.event.ShowDetailCardsEvent;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by jorgesanmartin on 6/22/16.
 */
public class CardPresenter extends TinkerLinkPresenter<CardPresenter.View> {

    private final Actions listener;

    /**
     * Card listeners.
     */
    public interface View extends Presenter.View {
        StackActivity.Stack getType();
    }

    /**
     * Card actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public CardPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //Actions

    public void onLaunhDetailStack() {
        EventBus.getDefault().post(new ShowDetailCardsEvent());
    }

}
