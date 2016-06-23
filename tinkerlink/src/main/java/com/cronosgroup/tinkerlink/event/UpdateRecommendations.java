package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;

/**
 * Created by jorgesanmartin on 3/11/16.
 */
public class UpdateRecommendations {
    private final int numberRecommendations;
    private  final RestUser restUser;

    public UpdateRecommendations(int numberRecommendations, RestUser restUser) {
        this.numberRecommendations = numberRecommendations;
        this.restUser = restUser;
    }

    public int getNumberRecommendations() {
        return numberRecommendations;
    }

    public RestUser getRestUser() {
        return restUser;
    }
}
