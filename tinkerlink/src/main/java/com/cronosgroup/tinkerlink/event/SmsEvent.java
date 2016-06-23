package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 11/5/15.
 */
public class SmsEvent {
    private final String code;

    public SmsEvent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
