package com.cronosgroup.tinkerlink.event;

import android.util.Pair;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLConversation;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage;

/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class ChatMessageReceivedEvent {

    private final Pair<TLConversation, TLMessage> pair;

    public ChatMessageReceivedEvent(Pair<TLConversation, TLMessage> pair) {
        super();
        this.pair = pair;
    }

    public Pair<TLConversation, TLMessage> getPair() {
        return pair;
    }
}
