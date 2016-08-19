package com.cronosgroup.tinkerlink.presenter.stack;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class StackPresenter extends TinkerLinkPresenter<StackPresenter.View> {

    /**
     * StackCardType listeners.
     */
    public interface View extends TinkerLinkPresenterView {

        boolean isUser();

        RestUser getUser();

        StackCardType getType();
    }

    //Public methods

    public void onSearchCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchCardsSearch(getView().getActivity(), bundle);
    }

    public void onCreateCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchCreateCard(getView().getActivity(), bundle);
    }

    public void onFilterCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchFilterCards(getView().getActivity(), bundle);
    }

}
