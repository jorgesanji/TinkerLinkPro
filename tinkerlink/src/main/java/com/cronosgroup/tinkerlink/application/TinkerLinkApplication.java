package com.cronosgroup.tinkerlink.application;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.cronosgroup.core.managers.AnalyticsManager;
import com.cronosgroup.core.managers.LocationManager;
import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.application.BaseApplication;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.UpdateUserProfileEvent;
import com.cronosgroup.tinkerlink.internal.di.component.AppComponent;
import com.cronosgroup.tinkerlink.internal.di.component.DaggerAppComponent;
import com.cronosgroup.tinkerlink.internal.di.module.AppModule;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.model.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.manager.AppDataBaseManager;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.AppFacebookManager;
import com.cronosgroup.tinkerlink.model.manager.AppImageLoaderManager;
import com.cronosgroup.tinkerlink.model.manager.AppMessagesManager;
import com.cronosgroup.tinkerlink.model.manager.AppNotificationsManager;
import com.cronosgroup.tinkerlink.model.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.IOSocialNetwork;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.mapper.TLUsers;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 2/5/16.
 */
public class TinkerLinkApplication extends BaseApplication implements PermissionsManager.IOAppPermission {

    // singletone
    private static TinkerLinkApplication app;

    @Inject
    AppUserSessionManager appUserSessionManager;

    @Inject
    LocationManager mLocationManager;

    @Inject
    AppConfigManager appConfigManager;

    @Inject
    AppNotificationsManager appNotificationsManager;

    @Inject
    AppMessagesManager appMessagesManager;

    @Inject
    AppContactsManager appContactsManager;

    @Inject
    AppCountryManager appCountryManager;

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        init();
    }

    @Override
    public void onTerminate() {
        AppDataBaseManager.destroy();
        super.onTerminate();
    }

    @Override
    public void onBackground() {
        mLocationManager.startLocationUpdates();
        if (Adjust.getDefaultInstance() != null) {
            Adjust.onPause();
        }
    }

    @Override
    public void onForeground() {
        mLocationManager.stopLocationUpdates();
        appConfigManager.loadConfig();
        if (Adjust.getDefaultInstance() != null) {
            Adjust.onResume();
        }
    }

    private void buildComponentAndInject() {
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
    }

    private void initImageLoader() {
        AppImageLoaderManager appImageLoaderManager = new AppImageLoaderManager(getApplicationContext());
        appImageLoaderManager.initImageLoader();
    }

    private void initFacebook() {
        IOSocialNetwork<AppUser> appFacebookManager = new AppFacebookManager(getApplicationContext());
        if (getCurrentUserLoged() == null) {
            appFacebookManager.LogOut(null);
        }
    }

    private void initAnalytics() {
        AnalyticsManager.initTracker(this, R.string.google_analytics_key);

        String appToken = getString(R.string.adjust_token);
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
        Adjust.onCreate(config);
    }

    private void initcountryManager() {
        appCountryManager.loadCountries();
    }

    private void init() {
        AppDataBaseManager.initDataBase(getApplicationContext());
        buildComponentAndInject();
        AppRestManager.configureRestManager(getConfig(), appUserSessionManager);
        initFacebook();
        initAnalytics();
        initcountryManager();
        initImageLoader();
    }

    public void AppUpdateData() {
        setFirstLoadApplication(true);
        appConfigManager.sendUserTimeZone();
        appNotificationsManager.getNotifications();
        appMessagesManager.getMessagesUnRead();
        appContactsManager.loadContacts();

        EventBus.getDefault().post(new UpdateUserProfileEvent(TLUsers.toRest(appUserSessionManager.getCurrentUser(), true)));
    }

    public static TinkerLinkApplication getApp() {
        return app;
    }

    public AppComponent getComponent() {
        return component;
    }

    public TLUser getCurrentUserLoged() {
        return appUserSessionManager.getCurrentUser();
    }

    /**
     * Callback rermissions received from any Activity
     *
     * @param permission
     * @param enable
     */

    @Override
    public void permission(PermissionsManager.Permission permission, boolean enable) {

    }
}
