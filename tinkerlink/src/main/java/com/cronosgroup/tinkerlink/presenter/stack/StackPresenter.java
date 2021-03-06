package com.cronosgroup.tinkerlink.presenter.stack;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.business.logic.CardUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.view.stack.detail.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class StackPresenter extends TinkerLinkPresenter<StackPresenter.View> {

    private final Actions listener;

    /**
     * Stack listeners.
     */
    public interface View extends Presenter.View {

        int getCurrentIndexPage();

        List<RestPost> getItems();

        void setCards(List<RestPost> cars);

        boolean isUser();

        RestUser getUser();

        StackActivity.Stack getType();
    }

    /**
     * Stack actions.
     */
    public interface Actions {
        void onLaunchStack(Activity activity, Bundle bundle);
        void onLaunchDetailStack(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public StackPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Public methods

    public void onSelectCardsType() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, (getView().getType().getStackType() == StackActivity.Stack.LINKER.getStackType()) ? StackActivity.Stack.TINKER : StackActivity.Stack.LINKER);
        listener.onLaunchStack(getView().getActivity(), bundle);
        getView().getActivity().finish();
    }

    public void getAllCards(String offset) {

        getView().showLoading();

        if (getView().isUser()) {
            CardUseCases.getUserCards(getView().getUser().getId(), getView().getType().getStackType(), offset, new Callback<List<RestPost>, RestError>() {

                @Override
                public void onResponse(List<RestPost> response) {
                    getView().setCards(response);
                    getView().hideLoading();
                }

                @Override
                public void onErrorResponse(RestError error) {
                    getStatusView().showNetworkError();
                    getView().hideLoading();
                }

            }, getView().getActivity());
        } else {
            CardUseCases.getAllCards(getView().getType().getStackType(), offset, new Callback<List<RestPost>, RestError>() {

                @Override
                public void onResponse(List<RestPost> response) {
                    getView().setCards(response);
                    getView().hideLoading();
                }

                @Override
                public void onErrorResponse(RestError error) {
                    getStatusView().showNetworkError();
                    getView().hideLoading();
                }

            }, getView().getActivity());
        }
    }

    public void showDetailCards() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailStackActivity.STACK_ITEMS, (Serializable) getView().getItems());
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        bundle.putInt(DetailStackActivity.STACK_CURRENT_ITEM, getView().getCurrentIndexPage());
        listener.onLaunchDetailStack(getView().getActivity(), bundle);
    }
}
