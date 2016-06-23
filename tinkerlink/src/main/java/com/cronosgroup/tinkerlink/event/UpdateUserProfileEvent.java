package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class UpdateUserProfileEvent {
    private final RestUser restUser;

    public UpdateUserProfileEvent(RestUser restUser) {
        this.restUser = restUser;
    }

    public RestUser getRestUser() {
        return restUser;
    }
}
