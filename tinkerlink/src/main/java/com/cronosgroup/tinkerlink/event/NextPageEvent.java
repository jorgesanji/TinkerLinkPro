package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.event.enums.FormState;

/**
 * Created by jorgesanmartin on 2/1/16.
 */
public class NextPageEvent {

    private final FormState state;

    public NextPageEvent(FormState state) {
        this.state = state;
    }

    public FormState getState() {
        return state;
    }
}
