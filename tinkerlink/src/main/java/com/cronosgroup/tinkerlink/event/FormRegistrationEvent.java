package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.event.enums.FormState;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class FormRegistrationEvent {

    private final FormState state;

    public FormRegistrationEvent(FormState state) {
        this.state = state;
    }

    public FormState getState() {
        return state;
    }
}
