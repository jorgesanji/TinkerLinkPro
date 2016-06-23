package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class UpdateMessagesEvent {

    private final long messagesNumber;

    public UpdateMessagesEvent(long messagesNumber) {
        super();
        this.messagesNumber = messagesNumber;
    }

    public long getMessagesNumber() {
        return messagesNumber;
    }
}
