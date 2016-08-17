package com.cronosgroup.tinkerlink.presenter.contacts;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.view.chatuser.ChatUserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class MyContactsPresenter extends TinkerLinkPresenter<MyContactsPresenter.View> {

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setContacts(List<RestContact> list);

        List<RestContact> getItems();
    }

    // public methods

    public void getContacts() {

        getView().showLoading();

        AsyncLoader<List<RestContact>> asyncLoader = new AsyncLoader<List<RestContact>>() {
            @Override
            public List<RestContact> doInBackground() {

                RestProfile restProfile = new RestProfile();
                restProfile.setProfession("Fontanero");
                restProfile.setCity("Barcelona");
                restProfile.setCountry("España");

                List<RestContact> list = new ArrayList<>();

                for (int contacts = 0; contacts < 20; contacts++) {

                    RestUser restUser1 = new RestUser();
                    restUser1.setName("Eddy Samaniego");
                    restUser1.setPhoto("http://qsrock.com/wp-content/uploads/2016/04/130699422.jpg");
                    restUser1.setProfile(restProfile);

                    RestContact contacto = new RestContact();
                    contacto.setUser(restUser1);

                    list.add(contacto);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestContact> result) {
                getView().setContacts(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();
    }

    public void onWritteMessageSelected(int position) {

        RestContact restContact = getView().getItems().get(position);
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


    public void launchImportContacts() {
        navigation.onLaunchImportUserContacts(getView().getActivity(), null);
    }

    public void launchSearchContacts() {
        navigation.onLaunchSearchContacts(getView().getActivity(), null);
    }

    public void launchUserProfile() {
        navigation.onLaunchUserProfile(getView().getActivity(), null);
    }
}
