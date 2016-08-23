package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
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


    }
}
