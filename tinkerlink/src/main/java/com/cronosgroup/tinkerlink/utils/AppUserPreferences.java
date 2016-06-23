package com.cronosgroup.tinkerlink.utils;

import android.content.Context;

import com.cronosgroup.core.utils.UserPreferences;

import java.util.Date;

/**
 * Created by jorgesanmartin on 11/4/15.
 */
public class AppUserPreferences extends UserPreferences {

    private static final String REG_ID = "reg_id";
    private static final String SESSION_TOKEN = "token";
    private static final String TOKEN_SAVED = "token_saved";
    private static final String APP_CONFIG = "app_config";
    private static final String APP_UPDATE = "app_update";

    public static boolean existDateUpdate(Context context) {
        return exist(context, APP_UPDATE);
    }

    public static void saveDateUpdated(Context context, Long value) {
        saveLong(context, APP_UPDATE, value);
    }

    public static void removeDateUpdate(Context context) {
        saveLong(context, APP_UPDATE, 0);
    }

    public static Date getLastDateForUpdate(Context context) {
        return new Date(getLong(context, APP_UPDATE));
    }

    public static void saveRegId(Context context, String value) {
        saveString(context, REG_ID, value);
    }

    public static String getRegId(Context context) {
        return getString(context, REG_ID);
    }

    public static void saveAccessToken(Context context, String value) {
        saveString(context, SESSION_TOKEN, value);
    }

    public static String geAccessToken(Context context) {
        return getString(context, SESSION_TOKEN);
    }

    public static void saveAppConfig(Context context, String value) {
        saveString(context, APP_CONFIG, value);
    }

    public static String getAppConfig(Context context) {
        return getString(context, APP_CONFIG);
    }

    public static boolean isTokenSavedInServerSide(Context context) {
        return getBoolean(context, TOKEN_SAVED);
    }

    public static void savedTokenInServerSide(Context context) {
        saveBoolean(context, TOKEN_SAVED, true);
    }

    public static void removeTokenInServerSide(Context context) {
        saveBoolean(context, TOKEN_SAVED, false);
    }
}
