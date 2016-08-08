package com.cronosgroup.tinkerlink.event.enums;

/**
 * Created by jorgesanmartin on 2/1/16.
 */
public enum FormState {
    SOCIALNETWORK_REGISTRATION(0),
    PHONE(1),
    VALIDATION(2);

    private final int index;

    FormState(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static FormState stateFromIndex(int index) {
        switch (index) {
            case 0:
                return SOCIALNETWORK_REGISTRATION;
            case 1:
                return PHONE;
            default:
                return VALIDATION;
        }
    }
}