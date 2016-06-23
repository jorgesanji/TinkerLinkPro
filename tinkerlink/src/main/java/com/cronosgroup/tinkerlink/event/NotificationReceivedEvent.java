package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;

/**
 * Created by jorgesanmartin on 1/15/16.
 */
public class NotificationReceivedEvent {

    private final TLNotification notification;

    public NotificationReceivedEvent(TLNotification notification) {
        super();
        this.notification = notification;
    }

    public TLNotification getNotification() {
        return notification;
    }
}
