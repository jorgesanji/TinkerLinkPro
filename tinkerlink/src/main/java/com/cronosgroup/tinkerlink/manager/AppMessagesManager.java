package com.cronosgroup.tinkerlink.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.event.UpdateMessagesEvent;
import com.cronosgroup.tinkerlink.model.business.logic.ChatUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.ChatManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class AppMessagesManager {
    private final Context mContext;
    private final ChatManager mManager;

    public AppMessagesManager(Context context) {
        super();
        this.mContext = context;
        this.mManager = new ChatManager();
    }

    public void getMessagesUnRead() {

        ChatUseCases.getMessageUnRead(new Callback<List<RestChat>, RestError>() {
            @Override
            public void onResponse(List<RestChat> response) {
                for (RestChat restChat : response) {
                    for (RestMessage restMensaje : restChat.getMensajes()) {
                        mManager.saveReceiverMessage(restMensaje);
                    }
                }

                long numberUnReadMessages = mManager.getUnReadMessagesCount();
                if (numberUnReadMessages > 0) {
                    EventBus.getDefault().post(new UpdateMessagesEvent(numberUnReadMessages));
                }
            }

            @Override
            public void onErrorResponse(RestError error) {

            }

        }, mContext);
    }
}
