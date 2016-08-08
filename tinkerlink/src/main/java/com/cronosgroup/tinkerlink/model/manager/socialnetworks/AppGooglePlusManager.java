package com.cronosgroup.tinkerlink.model.manager.socialnetworks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkSignCallBack;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by jorgesanmartin on 7/21/16.
 */
public class AppGooglePlusManager<T extends AppUser> implements IOSocialNetwork<T>, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private static final int RC_SIGN_IN = 9001;

    private Activity mActivity;
    private GoogleApiClient mGoogleApiClient;
    private IOSocialNetWorkCallBack mCallBack;
    private T user;

    public AppGooglePlusManager(Activity owner) {
        this.mActivity = owner;
        init();
    }

    private void init() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(mActivity)
                .enableAutoManage((FragmentActivity) mActivity, R.string.google_plus_debug_id, this)
                .addConnectionCallbacks(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            user = (T) new AppUser();
            user.setName(acct.getDisplayName());
            user.setEmail(acct.getEmail());
            user.setId(acct.getId());
            String userImageUrl = acct.getPhotoUrl().toString();
            if (!userImageUrl.isEmpty()) {
                user.setImageUrl(acct.getPhotoUrl().toString());
                ImageLoader.getInstance().loadImage(userImageUrl, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        if (mCallBack != null) {
                            mCallBack.onResponse(user);
                        }
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        user.setOriginalBitmageBase64(BitmapUtils.getBase64StringfromBitmap(loadedImage));
                        if (mCallBack != null) {
                            mCallBack.onResponse(user);
                        }
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                        if (mCallBack != null) {
                            mCallBack.onResponse(user);
                        }
                    }
                });
            }

        } else {
            mCallBack.onError(null);
        }
    }

    // Public methods

    @Override
    public void LogIn(IOSocialNetWorkCallBack<T> callBack) {
        this.mCallBack = callBack;
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        mActivity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void LogOut(final IOSocialNetWorkSignCallBack callBack) {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (callBack != null) {
                            if (status.isSuccess()) {
                                callBack.onSuccess();
                            } else {
                                callBack.onError();
                            }
                        }
                    }
                });
    }

    @Override
    public void revokeAccess(final IOSocialNetWorkSignCallBack callBack) {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (callBack != null) {
                            if (status.isSuccess()) {
                                callBack.onSuccess();
                            } else {
                                callBack.onError();
                            }
                        }
                    }
                });
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
            return true;
        }

        return false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("", "onConnectionFailed");
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d("", "onConnected");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("", "onConnectionSuspended");
    }
}
