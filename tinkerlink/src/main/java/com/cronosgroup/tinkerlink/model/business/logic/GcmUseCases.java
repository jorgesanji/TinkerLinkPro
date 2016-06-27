package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.GcmServices;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 11/6/15.
 */
public class GcmUseCases {

    public static final String KEY_REG_ID = "regId";

    public static void registerToken(String regId, Callback<Boolean, RestError> callback, Object tag) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put(KEY_REG_ID, regId);
        GcmServices.registerToken(null, parameters, callback, tag);
    }
}
