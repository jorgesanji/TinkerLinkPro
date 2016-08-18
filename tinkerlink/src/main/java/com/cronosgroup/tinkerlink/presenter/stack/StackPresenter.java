package com.cronosgroup.tinkerlink.presenter.stack;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
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

    public void onLaunhDetailStack() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchDetailCard(getView().getActivity(), bundle);
    }

    public void showDetailCard() {
        Bundle bundle = new Bundle();
//        bundle.putSerializable(DetailCardActivity.KEY_ITEM, getView().getItems().get(getView().getCurrentIndexPage()));
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
        navigation.onLaunchFilterCards(getView().getActivity(), bundle);
    }

    public void onWritteMessageSelected() {
        RestProfile restProfile = new RestProfile();
        restProfile.setProfession("Fontanero");

        RestUser restUser = new RestUser();
        restUser.setName("Jorge Sanmartin");
        restUser.setPhoto("https://pixabay.com/static/uploads/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        restUser.setProfile(restProfile);

        RestContact restContact = new RestContact();
        restContact.setUser(restUser);

        RestChat restChat = new RestChat();
        restChat.setUser(restContact);

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
        navigation.onLaunchUserProfile(getView().getActivity(), null);
    }
}
