package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.enums.FormState;

/**
 * Created by jorgesanmartin on 2/1/16.
 */
public class RegistrationStepsEvent {

    private final FormState state;

    public RegistrationStepsEvent() {
        this.state = null;
    }

    public RegistrationStepsEvent(FormState state) {
        this.state = state;
    }

    public FormState getState() {
        return state;
    }
}
