package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestConfigApp;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.AppGlobalConfigServices;
import com.cronosgroup.tinkerlink.utils.DateUtils;

/**
 * Created by jorgesanmartin on 11/17/15.
 */
public class AppGlobalConfigUseCases {

    public static void getAppGlobalConfig(Callback<RestConfigApp, RestError> callback, Object tag) {
        AppGlobalConfigServices.getAppGlobalConfig(RestConfigApp.class, callback, tag);
    }

    public static void updateTimezone(Callback callback, Object tag) {
        String timezone = DateUtils.getCurrentDateTime();
        AppGlobalConfigServices.updateTimezone(timezone, callback, tag);
    }
}
