package com.cronosgroup.tinkerlink.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.model.manager.AppGcmUserManager;
import com.cronosgroup.tinkerlink.model.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.utils.AppUserPreferences;
import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class GcmRegistrationDevice extends IntentService {

    private static final String TAG = GcmRegistrationDevice.class.toString();
    private static final String[] TOPICS = {"global"};

    @Inject
    AppUserSessionManager mUserSessionManager;

    public GcmRegistrationDevice() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        TinkerLinkApplication.getApp().getComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            // Get token from GCM
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(getString(R.string.google_gcm_id_sender),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            // Register to backend
            sendRegistrationToServer(token);

            // Subscribe to topic channels
            subscribeTopics(token);

        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
        }
    }

    /**
     * Persist registration to third-party servers.
     * <p/>
     * Modify this method to associate the user's GCM registration token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */

    private void sendRegistrationToServer(final String token) {
        if (!AppUserPreferences.getRegId(this).equalsIgnoreCase(token) || !AppUserPreferences.isTokenSavedInServerSide(this)) {

            AppUserPreferences.removeTokenInServerSide(this);

            // Get current user from database
            TLUser user = mUserSessionManager.getCurrentUser();
            // User logged
            if (user != null && user.getLoged()) {
                //Udate GCM ID IN SERVER SIDE
                AppGcmUserManager.updateGcmId(this);
            }

            // Save GCM ID
            AppUserPreferences.saveRegId(getApplicationContext(), token);
        }
    }

    /**
     * Subscribe to any GCM topics of interest, as defined by the TOPICS constant.
     *
     * @param token GCM token
     * @throws IOException if unable to reach the GCM PubSub service
     */

    private void subscribeTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }
}
