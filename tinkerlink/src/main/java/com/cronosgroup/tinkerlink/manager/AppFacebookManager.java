package com.cronosgroup.tinkerlink.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class AppFacebookManager {

    private static final String TAG = AppFacebookManager.class.toString();

    private static final int SIZE_PROFILE_IMAGE = 320;

    public interface IOFacebookCallBack<T> {
        void onResponse(T response);

        void onError(Object response);
    }

    private CallbackManager callbackManager = CallbackManager.Factory.create();
    private Gson mGson = new Gson();
    private final Context mContext;

    public AppFacebookManager(Context context) {
        this.mContext = context;
    }

    private void makeRequestLogin(final IOFacebookCallBack callBack) {

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (callBack != null) {
                    callBack.onResponse(loginResult);
                }
            }

            @Override
            public void onCancel() {
                if (callBack != null) {
                    callBack.onError(null);
                }
            }

            @Override
            public void onError(FacebookException error) {
                if (callBack != null) {
                    callBack.onError(error);
                }
            }
        });
    }

    private void makeRequestShare(ShareDialog shareDialog, final IOFacebookCallBack callBack) {

        if (shareDialog != null && callBack != null) {
            shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                @Override
                public void onSuccess(Sharer.Result result) {
                    if (callBack != null) {
                        callBack.onResponse(result);
                    }
                }

                @Override
                public void onCancel() {
                    if (callBack != null) {
                        callBack.onError(null);
                    }
                }

                @Override
                public void onError(FacebookException error) {
                    if (callBack != null) {
                        callBack.onError(null);
                    }
                }
            });
        }
    }

    // Public Methods

    public <T extends AppUser> void doLogin(Object owner, final IOFacebookCallBack<T> callBack, final Class<T> clazz) {

        List<String> permission = new ArrayList<String>();
        permission.add("user_birthday");
        permission.add("email");

        if (owner instanceof AppCompatActivity)
            LoginManager.getInstance().logInWithReadPermissions((AppCompatActivity) owner, permission);
        else
            LoginManager.getInstance().logInWithReadPermissions((Fragment) owner, permission);

        makeRequestLogin(new IOFacebookCallBack() {
            @Override
            public void onResponse(Object response) {

                if (response != null) {
                    // Get detail information from user
                    GraphRequest request = GraphRequest.newMeRequest(
                            ((LoginResult) response).getAccessToken(),
                            new GraphRequest.GraphJSONObjectCallback() {
                                @Override
                                public void onCompleted(
                                        JSONObject object,
                                        GraphResponse response) {
                                    response.getRawResponse();
                                    try {
                                        T user = mGson.fromJson(response.getRawResponse(), clazz);
                                        Uri image = Profile.getCurrentProfile().getProfilePictureUri(SIZE_PROFILE_IMAGE, SIZE_PROFILE_IMAGE);
                                        user.setImageUrl(image.toString());
                                        if (callBack != null) {
                                            callBack.onResponse(user);
                                        }
                                    } catch (Exception exception) {
                                        Log.v(TAG, "GSON ERROR");
                                        if (callBack != null) {
                                            callBack.onError("GSON ERROR");
                                        }
                                    }
                                }
                            });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id,name,email,gender, birthday");
                    request.setParameters(parameters);
                    request.executeAsync();
                }
            }

            @Override
            public void onError(Object response) {
                if (callBack != null) {
                    callBack.onError(response);
                }
            }
        });
    }

    public void shareLink(Activity context, String title, String description, String urlImage, String urlShare, IOFacebookCallBack callBack) {

        if (ShareDialog.canShow(ShareLinkContent.class)) {

            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle(title)
                    .setContentDescription(
                            description)
                    .setContentUrl(Uri.parse(urlShare))
                    .setImageUrl(Uri.parse(urlImage))
                    .build();
            ShareDialog shareDialog = new ShareDialog(context);
            shareDialog.show(linkContent);

            makeRequestShare(shareDialog, callBack);
        }
    }

    public void logout() {
        LoginManager.getInstance().logOut();
    }

    public void init() {
        FacebookSdk.sdkInitialize(mContext);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
