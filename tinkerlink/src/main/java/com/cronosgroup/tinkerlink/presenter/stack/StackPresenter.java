package com.cronosgroup.tinkerlink.presenter.stack;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

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
        void setCards(List<RestPost> cars);

        boolean isUser();

        RestUser getUser();

        int getType();
    }

    /**
     * Stack actions.
     */
    public interface Actions {

    }

    /**
     * @param navigationListener
     */
    public StackPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    public void getAllCards(String offset) {

//        getView().showLoading();
//
//        if (getView().isUser()) {
//            CardUseCases.getUserCards(getView().getUser().getId(), getView().getType(), offset, new Callback<List<RestPost>, RestError>() {
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
//            CardUseCases.getAllCards(getView().getType(), offset, new Callback<List<RestPost>, RestError>() {
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
