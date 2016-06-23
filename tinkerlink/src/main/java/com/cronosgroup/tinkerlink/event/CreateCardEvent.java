package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * Created by jorgesanmartin on 22/4/16.
 */
public class CreateCardEvent {

    private final RestPost post;

    public CreateCardEvent(RestPost post) {
        this.post = post;
    }

    public RestPost getPost() {
        return post;
    }
}
