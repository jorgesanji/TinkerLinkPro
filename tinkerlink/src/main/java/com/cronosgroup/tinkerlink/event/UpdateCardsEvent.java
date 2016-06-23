package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * Created by jorgesanmartin on 2/9/16.
 */
public class UpdateCardsEvent {

    private final RestPost restPost;

    public UpdateCardsEvent(RestPost restPost) {
        this.restPost = restPost;
    }

    public RestPost getRestPost() {
        return restPost;
    }
}
