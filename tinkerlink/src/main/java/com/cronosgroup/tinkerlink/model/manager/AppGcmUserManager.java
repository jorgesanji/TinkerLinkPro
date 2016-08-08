package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.business.logic.GcmUseCases;
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
            GcmUseCases.registerToken(token, new Callback<Boolean, RestError>() {
                @Override
                public void onResponse(Boolean response) {
                    // Save new Token
                    if (!response) {
                        AppUserPreferences.saveRegId(context, token);
                        AppUserPreferences.savedTokenInServerSide(context);
                    }
                }

                @Override
                public void onErrorResponse(RestError error) {

                }

            }, context);
        }
    }
}
