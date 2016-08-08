package com.cronosgroup.tinkerlink.presenter.stack;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class DetailStackPresenter extends TinkerLinkPresenter<DetailStackPresenter.View> {

    private final Actions listener;

    /**
     * Message listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        boolean isUser();

        RestUser getUser();

        StackCardType getType();
    }

    /**
     * Mesage actions.
     */
    public interface Actions {

    }

    /**
     * @param navigationListener
     */
    public DetailStackPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    public void getAllCards(String offset) {

//        getView().showLoading();

//        if (getView().isUser()) {
//            CardUseCases.getUserCards(getView().getUser().getId(), getView().getTypeTinker(), offset, new Callback<List<RestPost>, RestError>() {
//
//                @Override
//                public void onResponse(List<RestPost> response) {
//                    getView().setCards(response);
//                    getView().hideLoading();
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getStatusView().showNetworkError();
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        } else {
//            CardUseCases.getAllCards(getView().getTypeTinker(), offset, new Callback<List<RestPost>, RestError>() {
//
//                @Override
//                public void onResponse(List<RestPost> response) {
//                    getView().setCards(response);
//                    getView().hideLoading();
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getStatusView().showNetworkError();
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        }
    }
}
