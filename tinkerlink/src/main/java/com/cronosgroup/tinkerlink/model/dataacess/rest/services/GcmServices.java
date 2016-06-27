package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 11/6/15.
 */
public class GcmServices extends AppService {

    private static final String URL_REGISTER_GCM = "gcm/register/";

    public static void registerToken(String params, HashMap<String, String> parameters, final Callback callback, Object tag) {

        String url = URL_REGISTER_GCM;
        if (params != null) {
            url += params;
        }

        PUT(url, parameters, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null) {
                        callback.onResponse(response.getError().hasError());
                    } else {
                        callback.onErrorResponse(RestError.getMappingError());
                    }
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }

        }, tag);
    }
}
