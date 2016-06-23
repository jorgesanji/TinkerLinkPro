package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.event.enums.FormState;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class FormValidationEvent {

    private final boolean validation;
    private final FormState state;

    public FormValidationEvent(FormState state, boolean validation) {
        this.validation = validation;
        this.state = state;
    }

    public boolean isValidation() {
        return validation;
    }

    public FormState getState() {
        return state;
    }
}
