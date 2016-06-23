package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class UpdateNotificationsEvent {

    private final long notificationsNumber;

    public UpdateNotificationsEvent(long notificationsNumber) {
        super();
        this.notificationsNumber = notificationsNumber;
    }

    public long getNotificationsNumber() {
        return notificationsNumber;
    }
}
