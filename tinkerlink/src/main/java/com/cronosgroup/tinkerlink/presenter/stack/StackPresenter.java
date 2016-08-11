package com.cronosgroup.tinkerlink.presenter.stack;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.view.chatuser.ChatUserActivity;
import com.cronosgroup.tinkerlink.view.detailcard.DetailCardActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class StackPresenter extends TinkerLinkPresenter<StackPresenter.View> {

    /**
     * StackCardType listeners.
     */
    public interface View extends TinkerLinkPresenterView {

        int getCurrentIndexPage();

        List<RestPost> getItems();

        void setCards(List<RestPost> cars);

        boolean isUser();

        RestUser getUser();

        StackCardType getType();
    }


    //Public methods

    public void onSelectCardsType() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, (getView().getType().getStackType() == StackCardType.LINKER.getStackType()) ? StackCardType.TINKER : StackCardType.LINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
        getView().getActivity().finish();
    }

    public void getAllCards(String offset) {

        getView().showLoading();
        AsyncLoader<List<RestPost>> asyncLoader = new AsyncLoader<List<RestPost>>() {
            @Override
            public List<RestPost> doInBackground() {

                List<RestPost> list = new ArrayList<>();
                for (int posts = 0; posts < 10; posts++) {
                    RestPost restPost = new RestPost();
                    list.add(restPost);
                }
                return list;
            }

            @Override
            public void postProcess(List<RestPost> result) {
                getView().setCards(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();
//        getView().showLoading();

//        if (getView().isUser()) {
//            CardUseCases.getUserCards(getView().getUser().getId(), getView().getType().getStackType(), offset, new Callback<List<RestPost>, RestError>() {
//
//                @Override
//                public void onResponse(List<RestPost> response) {
//                    getView().setCards(response);
//                    getView().hideLoading();
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getView().getSnackMessageManager().showNetworkError();
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        } else {
//            CardUseCases.getAllCards(getView().getType().getStackType(), offset, new Callback<List<RestPost>, RestError>() {
//
//                @Override
//                public void onResponse(List<RestPost> response) {
//                    getView().setCards(response);
//                    getView().hideLoading();
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getView().getSnackMessageManager().showNetworkError();
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        }
    }

    public void showDetailCard() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailCardActivity.KEY_ITEM, getView().getItems().get(getView().getCurrentIndexPage()));
        bundle.putBoolean(DetailCardActivity.KEY_PUBLISH, false);
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchDetailCard(getView().getActivity(), bundle);
    }

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
        navigation.onLaunchFilterCars(getView().getActivity(), bundle);
    }

    public void onWritteMessageSelected() {
        RestProfile restProfile = new RestProfile();
        restProfile.setProfession("Fontanero");

        RestUser restUser = new RestUser();
        restUser.setName("Jorge Sanmartin");
        restUser.setPhoto("https://pixabay.com/static/uploads/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        restUser.setProfile(restProfile);

        RestContacto restContacto = new RestContacto();
        restContacto.setUser(restUser);

        RestChat restChat = new RestChat();
        restChat.setUser(restContacto);

        List<RestMessage> listMessages = new ArrayList<>();

        RestMessage restMessage = new RestMessage();
        restMessage.setMensaje("Esto es una mentira");
        listMessages.add(restMessage);

        restChat.setMensajes(listMessages);

        Bundle bundle = new Bundle();
        bundle.putSerializable(ChatUserActivity.ITEMS_KEY, restChat);

        navigation.onLaunchChatUser(getView().getActivity(), bundle);
    }

    public void onWatchProfilePressed() {
        navigation.onLaunchProfile(getView().getActivity(), null);
    }
}
