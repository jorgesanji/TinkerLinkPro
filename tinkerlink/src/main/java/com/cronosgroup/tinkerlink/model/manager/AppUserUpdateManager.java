package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.business.logic.ProfileUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;

/**
 * Created by jorgesanmartin on 1/11/16.
 */
public class AppUserUpdateManager {

    private Context mContext;

    public AppUserUpdateManager(Context context) {
        super();
        this.mContext = context;
    }

    public void updateProfileData(String idUser, final Callback<RestUser, RestError> callback) {

        ProfileUseCases.getProfile(idUser, new Callback<RestContact, RestError>() {
            @Override
            public void onResponse(RestContact response) {
                if (callback != null) {
                    if (response.getUser().isActive()) {
                        callback.onResponse(response.getUser());
                    } else {
                        callback.onResponse(null);
                    }
                }
            }

            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }

        }, mContext);
    }
}
