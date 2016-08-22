package com.cronosgroup.tinkerlink.model.dataacess.rest.manager;

import android.content.Context;

import com.android.volley.VolleyLog;
import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.ConfigRestService;
import com.cronosgroup.core.rest.RestManager;
import com.cronosgroup.core.rest.SessionStatus;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

/**
 * Created by jorgesanmartin on 15/10/15.
 */

public class AppRestManager extends RestManager {

    private static String FORMATT_DATE = "yyyy-MM-dd H:mm:ss.s Z";
    private static AppRestManager manager = null;

    // Public Methods

    public static JsonToModel mapping = new JsonToModel(AppRestManager.getMapperUsed());

    public static synchronized AppRestManager sharedManager() {
        if (manager == null) {
            throw new IllegalArgumentException("please set to configureRestManager");
        }
        return manager;
    }

    public static void configureRestManager(ConfigRestService configRestService, SessionStatus listener) {
        if (configRestService != null) {
            manager = new AppRestManager(configRestService.getContext(), configRestService.getCurrentUrl());
            manager.setSessionStatusListener(listener);
            manager.setMapper(getMapperUsed());
            VolleyLog.DEBUG = (configRestService.getCurrentMode() == ConfigRestService.Mode.DEVELOP) || (configRestService.getCurrentMode() == ConfigRestService.Mode.QA);
        }
    }

    public AppRestManager(Context context, String baseUrl) {
        super(context, baseUrl);
    }

    public static Gson getMapperUsed() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(FORMATT_DATE);
        gsonBuilder.registerTypeAdapter(String.class, new JsonToModel.StringDeserializer());
        Gson mGson = gsonBuilder.create();

        return mGson;
    }

    public void PUT(String url, Callback callback, Object tag) {
        putRequest(url, null, RestResponse.class, callback, tag);
    }

    public void PUT(String url, Map<String, String> params, Callback callback, Object tag) {
        putRequest(url, params, RestResponse.class, callback, tag);
    }

    public void PUT(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        putRequest(url, params, headers, RestResponse.class, callback, tag);
    }

    public void DELETE(String url, Callback callback, Object tag) {
        deleteRequest(url, null, RestResponse.class, callback, tag);
    }

    public void DELETE(String url, Map<String, String> params, Callback callback, Object tag) {
        deleteRequest(url, params, RestResponse.class, callback, tag);
    }

    public void DELETE(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        deleteRequest(url, params, headers, RestResponse.class, callback, tag);
    }

    public void GET(String url, Callback callback, Object tag) {
        getRequest(url, RestResponse.class, callback, tag);
    }

    public void GET(String url, Map<String, String> params, Callback callback, Object tag) {
        getRequest(url, params, null, RestResponse.class, callback, tag);
    }

    public void GET(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        getRequest(url, params, headers, RestResponse.class, callback, tag);
    }

    public void POST(String url, Callback callback, Object tag) {
        postRequest(url, RestResponse.class, callback, tag);
    }

    public void POST(String url, Map<String, String> params, Callback callback, Object tag) {
        postRequest(url, params, null, RestResponse.class, callback, tag);
    }

    public void POST(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        postRequest(url, params, headers, RestResponse.class, callback, tag);
    }
}
