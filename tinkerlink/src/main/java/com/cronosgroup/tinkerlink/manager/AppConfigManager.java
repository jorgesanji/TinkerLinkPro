package com.cronosgroup.tinkerlink.manager;

import android.content.Context;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.business.logic.AppGlobalConfigUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestConfigApp;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestError;
import com.cronosgroup.tinkerlink.utils.AppUserPreferences;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/17/15.
 */
public class AppConfigManager {

    public enum Path {
        PATH_PRIVACY_ES(10),
        PATH_PRIVACY_EN(9),
        PATH_SHARE(8),
        PATH_ICON(7),
        PATH_IMAGE_CROPPED_THUMBNAIL(6),
        PATH_IMAGE_CROPPED(5),
        PATH_IMAGE_GALLERY(4),
        PATH_IMAGE_GALLERY_THUMBNAIL(3),
        PATH_IMAGE_PROFILE_THUMBNAIL(2),
        PATH_IMAGE_PROFILE(1);

        private final int type;

        private Path(int levelCode) {
            this.type = levelCode;
        }

        public int getType() {
            return type;
        }
    }

    private final Context mContext;
    private Gson mGson = new Gson();
    private RestConfigApp restConfigApp;

    public AppConfigManager(Context context) {
        this.mContext = context;
    }

    public void loadConfig() {

        AppGlobalConfigUseCases.getAppGlobalConfig(new Callback<RestConfigApp, RestError>() {
            @Override
            public void onResponse(RestConfigApp response) {
                restConfigApp = response;
                String json = mGson.toJson(response);
                AppUserPreferences.saveAppConfig(mContext, json);
            }

            @Override
            public void onErrorResponse(RestError error) {

            }

        }, mContext);
    }

    public void sendUserTimeZone() {
        AppGlobalConfigUseCases.updateTimezone(new Callback<Boolean, RestError>() {
            @Override
            public void onResponse(Boolean response) {

            }

            @Override
            public void onErrorResponse(RestError error) {

            }

        }, mContext);
    }

    private RestConfigApp getConfigApp() {
        if (restConfigApp == null) {
            String jsonConfig = AppUserPreferences.getAppConfig(mContext);
            if (jsonConfig != null && jsonConfig.length() > 0) {
                restConfigApp = mGson.fromJson(jsonConfig, RestConfigApp.class);
            }
        }
        return restConfigApp;
    }


    public String getPath(AppConfigManager.Path path) {
        RestConfigApp restConfigApp = getConfigApp();
        if (restConfigApp != null && path != null) {
            switch (path) {
                case PATH_IMAGE_GALLERY_THUMBNAIL:
                    return restConfigApp.getImageGalleryThumbnailPath();
                case PATH_IMAGE_PROFILE_THUMBNAIL:
                    return restConfigApp.getImageProfileThumbnailPath();
                case PATH_IMAGE_PROFILE:
                    return restConfigApp.getImageProfilePath();
                case PATH_IMAGE_GALLERY:
                    return restConfigApp.getImageGalleryPath();
                case PATH_IMAGE_CROPPED:
                    return restConfigApp.getImageProfileCroppedPath();
                case PATH_IMAGE_CROPPED_THUMBNAIL:
                    return restConfigApp.getImageProfileCroppedThumbnailPath();
                case PATH_ICON:
                    return restConfigApp.getIconPath();
                case PATH_SHARE:
                    return restConfigApp.getImageSharePath();
                case PATH_PRIVACY_ES:
                    return restConfigApp.getPrivacyPolicyPathES();
                case PATH_PRIVACY_EN:
                    return restConfigApp.getPrivacyPolicyPathEN();
            }
        }
        return "";
    }

    public List<RestCategoria> getCategories() {
        RestConfigApp restConfigApp = getConfigApp();
        List<RestCategoria> restCategoriaList = new ArrayList<RestCategoria>();
        if (restConfigApp != null) {
            restCategoriaList = restConfigApp.getCategories();
        }
        return restCategoriaList;
    }

    public String getSupportId() {
        RestConfigApp restConfigApp = getConfigApp();
        return restConfigApp.getSupportId();
    }

    public String getPrivacyUrl() {
        return LocaleUtils.isES() ? getPath(Path.PATH_PRIVACY_ES) : getPath(Path.PATH_PRIVACY_EN);
    }
}
