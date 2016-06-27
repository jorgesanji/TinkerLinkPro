package com.cronosgroup.tinkerlink.manager;

import android.content.Context;
import android.content.Intent;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.core.rest.SessionStatus;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.ChatManager;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.NotificationsManager;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.UserManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;
import com.cronosgroup.tinkerlink.utils.AppUserPreferences;
import com.cronosgroup.tinkerlink.view.tutorial.TutorialActivity;

/**
 * Created by jorgesanmartin on 1/15/16.
 */
public class AppUserSessionManager implements SessionStatus {

    public interface IOSessionCallback {
        void onSessionStatus(RestUser.UserStatus status);
    }

    private final Context mContext;
    private TLUser currentUser;
    private UserManager mManager;
    private AppUserUpdateManager appUserManager;
    private AppFacebookManager appFacebookManager;

    public AppUserSessionManager(Context context) {
        super();
        this.mContext = context;
        this.mManager = new UserManager();
        this.currentUser = mManager.getCurrentUser();
        this.appUserManager = new AppUserUpdateManager(context);
        this.appFacebookManager = new AppFacebookManager(mContext);
    }

    public void logout() {

        // Cancel all requests
        AppRestManager.sharedManager().cancelAllRequest();

        // Remove current user from database
        TLUser user = getCurrentUser();
        if (user != null) {
            user.delete();
        }

        // Remove user reference
        setCurrentUser(null);

        // Remove last access token from user
        AppService.saveSessionToken(null);

        // Change flag(GCM) default value
        AppUserPreferences.removeTokenInServerSide(mContext);

        // Time to update re init
        AppUserPreferences.removeDateUpdate(mContext);

        // Remove all chats from Database
        ChatManager chatManager = new ChatManager();
        chatManager.deleteAll();

        // Remove all Notifications from database
        NotificationsManager notificationsManager = new NotificationsManager();
        notificationsManager.deleteAll();

        // Delete all users from database
        mManager.deleteAll();

        //Logout from facebook
        appFacebookManager.logout();

        //Return to Tutorial activity
        Intent openIntent = new Intent(mContext, TutorialActivity.class);
        openIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        //Start new activity
        mContext.startActivity(openIntent);
    }

    public void login(RestUser restUser) {
        // Save user to database
        UserManager manager = new UserManager();

        setCurrentUser(manager.saveUser(restUser));

        // Save GCM REG ID in server side
        AppGcmUserManager.updateGcmId(mContext);

        // Get contacts
        TinkerLinkApplication.getApp().AppUpdateData();
    }

    public TLUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(TLUser currentUser) {
        this.currentUser = currentUser;
    }

    public void checkUserStatus(final IOSessionCallback callback) {

        final TLUser user = getCurrentUser();

        if (user == null) {
            if (callback != null) {
                callback.onSessionStatus(RestUser.UserStatus.NONE);
            }
        } else {
            appUserManager.updateProfileData(user.getIdUser(), new Callback<RestUser, RestError>() {
                @Override
                public void onResponse(RestUser response) {
                    if (callback != null) {
                        if (response != null && response.isActive()) {
                            user.setName(response.getName());
                            user.setPhoto(response.getPhoto());
                            user.setBirthday(response.getBirthday());
                            user.setEmail(response.getEmail());
                            user.setVisibility(response.getVisibility());
                            user.setCategory(response.getProfile().getCategory());
                            user.setOcupation(response.getProfile().getProfession());
                            user.setJobDescription(response.getProfile().getDescripcion());
                            user.setEducation(AppRestManager.mapping.mappingToStringJson(response.getProfile().getStudies()));
                            user.save();

                            callback.onSessionStatus(RestUser.UserStatus.ACTIVE);
                        } else {
                            callback.onSessionStatus(RestUser.UserStatus.INACTIVE);
                        }
                    }
                }

                @Override
                public void onErrorResponse(RestError error) {
                    if (callback != null) {
                        callback.onSessionStatus(RestUser.UserStatus.NONE);
                    }
                }
            });
        }
    }

    @Override
    public void endSession() {
        logout();
    }
}
