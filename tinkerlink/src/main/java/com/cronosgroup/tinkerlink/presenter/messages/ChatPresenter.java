package com.cronosgroup.tinkerlink.presenter.messages;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChatPresenter extends TinkerLinkPresenter<ChatPresenter.View> {

    private final Actions listener;


    /**
     * Message listeners.
     */
    public interface View extends Presenter.View {
        void setChats(List<RestChat> list);
    }

    /**
     * Mesage actions.
     */
    public interface Actions {

    }

    /**
     * @param navigationListener
     */
    public ChatPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // Actions

    public void getChats() {

        AsyncLoader asyncLoader = new AsyncLoader<List<RestChat>>() {
            @Override
            public List<RestChat> doInBackground() {

                List<RestChat> restChatArrayList = new ArrayList<>();

                for (int i = 0; i < 20; i++) {
                    RestProfile restProfile = new RestProfile();
                    restProfile.setProfession("pintor");

                    RestUser restUser = new RestUser();
                    restUser.setName("Edgar Sanchez");
                    restUser.setPhoto("https://pixabay.com/static/uploads/photo/2016/03/28/12/35/cat-1285634_960_720.png");
                    restUser.setProfile(restProfile);

                    RestContacto restContacto = new RestContacto();
                    restContacto.setUser(restUser);

                    RestChat restChat = new RestChat();
                    restChat.setUser(restContacto);

                    List<RestMessage> listMessages = new ArrayList<>();

                    for (int j = 0; j < 50; j++) {
                        RestMessage restMessage = new RestMessage();
                        restMessage.setMensaje("Esto es una mentira");
                        listMessages.add(restMessage);
                    }

                    restChat.setMensajes(listMessages);

                    restChatArrayList.add(restChat);
                }


                return restChatArrayList;
            }

            @Override
            public void postProcess(List<RestChat> list) {
                getView().setChats(list);
            }
        };

        asyncLoader.start();


    }
}
