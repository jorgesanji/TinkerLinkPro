package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.ChatServices;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jorgesanmartin on 1/8/16.
 */
public class ChatUseCases {

    public static final String KEY_MESSAGE = "texto";

    public static void sendMessage(String idUser, String message, final Callback callback, Object tag) {

        HashMap<String, String> params = new HashMap<>();
        params.put(KEY_MESSAGE, message);

        ChatServices.sendMessage(idUser, params, RestMessage.class, callback, tag);
    }

    public static void getMessageUnRead(final Callback<List<RestChat>, RestError> callback, Object tag) {
        ChatServices.getMessagesUnRead(RestChat.class, callback, tag);
    }

    public static void removeChat(String idChat, final Callback callback, Object tag) {
        ChatServices.removeChat(idChat, callback, tag);
    }

    public static void checkAllMessages(String endpoint, final Callback callback, Object tag) {
        ChatServices.checkAllMessages(endpoint, callback, tag);
    }
}
