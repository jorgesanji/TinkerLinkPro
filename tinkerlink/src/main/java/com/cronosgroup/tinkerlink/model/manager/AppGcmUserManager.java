package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.tinkerlink.utils.AppUserPreferences;

/**
 * Created by jorgesanmartin on 11/9/15.
 */
public class AppGcmUserManager {

    /**
     * @param context
     */
    public static void updateGcmId(Context context) {
        sendToken(context, AppUserPreferences.getRegId(context));
    }

    private static void sendToken(final Context context, final String token) {
        if (token != null) {

        }
    }
}
