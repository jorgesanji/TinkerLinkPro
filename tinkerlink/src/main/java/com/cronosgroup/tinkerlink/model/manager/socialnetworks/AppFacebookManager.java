package com.cronosgroup.tinkerlink.model.manager.socialnetworks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkSignCallBack;
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
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class AppFacebookManager<T extends AppUser> implements IOSocialNetwork<T> {

    private static final String TAG = AppFacebookManager.class.toString();

    private static final int SIZE_PROFILE_IMAGE = 320;

    private CallbackManager callbackManager = CallbackManager.Factory.create();
    private Gson mGson = new Gson();
    private final Context mContext;
    private final Object mOwner;
    private Class clazz = AppUser.class;

    public AppFacebookManager(Context context) {
        this.mContext = context;
        this.mOwner = null;
        init();
    }

    public AppFacebookManager(Activity context) {
        this.mContext = context;
        this.mOwner = context;
        init();
    }

    private void makeRequestLogin(final IOSocialNetWorkCallBack callBack) {

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


    // Public Methods

    @Override
    public void LogIn(final IOSocialNetWorkCallBack<T> callBack) {
//        Object owner = params[0];
//        final Class<T> clazz = (Class<T>) params[1];

        List<String> permission = new ArrayList<String>();
        permission.add("user_birthday");
        permission.add("email");

        if (mOwner instanceof AppCompatActivity)
            LoginManager.getInstance().logInWithReadPermissions((AppCompatActivity) mOwner, permission);
        else
            LoginManager.getInstance().logInWithReadPermissions((Fragment) mOwner, permission);

        makeRequestLogin(new IOSocialNetWorkCallBack() {
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
                                        final T user = (T) mGson.fromJson(response.getRawResponse(), clazz);
                                        Uri image = Profile.getCurrentProfile().getProfilePictureUri(SIZE_PROFILE_IMAGE, SIZE_PROFILE_IMAGE);
                                        String userImageUrl = image.toString();
                                        if (!userImageUrl.isEmpty()) {
                                            user.setImageUrl(userImageUrl);
                                            ImageLoader.getInstance().loadImage(userImageUrl, new ImageLoadingListener() {
                                                @Override
                                                public void onLoadingStarted(String imageUri, View view) {

                                                }

                                                @Override
                                                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                                                    if (callBack != null) {
                                                        callBack.onResponse(user);
                                                    }
                                                }

                                                @Override
                                                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                                    user.setOriginalBitmageBase64(BitmapUtils.getBase64StringfromBitmap(loadedImage));
                                                    if (callBack != null) {
                                                        callBack.onResponse(user);
                                                    }
                                                }

                                                @Override
                                                public void onLoadingCancelled(String imageUri, View view) {
                                                    if (callBack != null) {
                                                        callBack.onResponse(user);
                                                    }
                                                }
                                            });

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

    @Override
    public void LogOut(IOSocialNetWorkSignCallBack callBack) {
        LoginManager.getInstance().logOut();
    }

    @Override
    public void revokeAccess(IOSocialNetWorkSignCallBack callBack) {
        LoginManager.getInstance().logOut();
    }

    public void init() {
        FacebookSdk.sdkInitialize(mContext);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
