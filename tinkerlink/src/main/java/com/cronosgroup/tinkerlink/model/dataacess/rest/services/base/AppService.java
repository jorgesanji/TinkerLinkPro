package com.cronosgroup.tinkerlink.model.dataacess.rest.services.base;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.utils.AppUserPreferences;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jorgesanmartin on 14/10/15.
 */
public class AppService {

    private static final String KEY_ACCESS_TOKEN = "x-access-token";
    private static final String KEY_LANGUAGE = "accept-language";

    // Request

    public static void PUT(String url, Callback callback, Object tag) {
        PUT(url, null, null, callback, tag);
    }

    public static void PUT(String url, Map<String, String> params, Callback callback, Object tag) {
        PUT(url, params, null, callback, tag);
    }

    public static void PUT(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        AppRestManager.sharedManager().PUT(url, params, headers, callback, tag);
    }

    public static void DELETE(String url, Callback callback, Object tag) {
        DELETE(url, null, null, callback, tag);
    }

    public static void DELETE(String url, Map<String, String> params, Callback callback, Object tag) {
        DELETE(url, params, null, callback, tag);
    }

    public static void DELETE(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        AppRestManager.sharedManager().DELETE(url, params, headers, callback, tag);
    }

    public static void GET(String url, Callback callback, Object tag) {
        GET(url, null, null, callback, tag);
    }

    public static void GET(String url, Map<String, String> params, Callback callback, Object tag) {
        GET(url, params, null, callback, tag);
    }

    public static void GET(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        AppRestManager.sharedManager().GET(url, params, headers, callback, tag);
    }

    public static void POST(String url, Callback callback, Object tag) {
        POST(url, null, null, callback, tag);
    }

    public static void POST(String url, Map<String, String> params, Callback callback, Object tag) {
        POST(url, params, null, callback, tag);
    }

    public static void POST(String url, Map<String, String> params, Map<String, String> headers, Callback callback, Object tag) {
        AppRestManager.sharedManager().POST(url, params, headers, callback, tag);
    }

    // Mapping Json to Model

    protected static Object mappingJson(JsonElement jsonObject, Class clazz) {
        return AppRestManager.sharedManager().mapping.mappingJson(jsonObject, clazz);
    }

    protected static Object mappingJson(JsonObject jsonObject, Class clazz) {
        return AppRestManager.sharedManager().mapping.mappingJson(jsonObject, clazz);
    }

    protected static Object mappingJson(String stringJson, Class clazz) {
        return AppRestManager.sharedManager().mapping.mappingJson(stringJson, clazz);
    }

    protected static Object mappingJson(String stringJson, String rootKey, Class clazz) {
        return AppRestManager.sharedManager().mapping.mappingJson(stringJson, rootKey, clazz);
    }

    protected static Object mappingJson(String stringJson, String rootKey, Type type) {
        return AppRestManager.sharedManager().mapping.mappingJson(stringJson, rootKey, type);
    }

    protected static void mappingJsonInBackground(JsonObject jsonObject, Class clazz, JsonToModel.Listener callback) {
        AppRestManager.sharedManager().mapping.mappingJsonInBackground(jsonObject, clazz, callback);
    }

    protected static void mappingJsonInBackground(String stringJson, Class clazz, JsonToModel.Listener callback) {
        AppRestManager.sharedManager().mapping.mappingJsonInBackground(stringJson, clazz, callback);
    }

    protected static <T> void mappingListInBackground(String json, String rootPath, Class<T> model, JsonToModel.Listener callback) {
        AppRestManager.sharedManager().mapping.mappingListInBackground(json, rootPath, model, callback);
    }

    // AcessToken saved and retrieved

    public static void saveSessionToken(String token) {
        // Save token
        AppUserPreferences.saveAccessToken(AppRestManager.sharedManager().getContext(), token);
    }

    public static String getSessionToken() {
        return AppUserPreferences.geAccessToken(AppRestManager.sharedManager().getContext());
    }

    // HEADERS

    public static HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        if (getSessionToken() != null && getSessionToken().length() != 0) {
            headers.put(KEY_ACCESS_TOKEN, getSessionToken());
        }
        headers.put(KEY_LANGUAGE, LocaleUtils.getCurrentLanguage());
        return headers;
    }
}
