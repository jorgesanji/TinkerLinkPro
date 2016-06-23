package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * Created by jorgesanmartin on 1/20/16.
 */
public class DeleteCardEvent {

    private final RestPost restPost;

    public DeleteCardEvent(RestPost restPost) {
        super();
        this.restPost = restPost;
    }

    public RestPost getRestPost() {
        return restPost;
    }
}
