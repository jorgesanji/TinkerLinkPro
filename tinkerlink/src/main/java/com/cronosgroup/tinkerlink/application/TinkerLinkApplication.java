package com.cronosgroup.tinkerlink.application;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.cronosgroup.core.managers.LocationManager;
import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.application.BaseApplication;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.UpdateUserProfileEvent;
import com.cronosgroup.tinkerlink.internal.di.component.AppComponent;
import com.cronosgroup.tinkerlink.internal.di.component.DaggerAppComponent;
import com.cronosgroup.tinkerlink.internal.di.module.AppModule;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.manager.AppDataBaseManager;
import com.cronosgroup.tinkerlink.manager.AppFacebookManager;
import com.cronosgroup.tinkerlink.manager.AppMessagesManager;
import com.cronosgroup.tinkerlink.manager.AppNotificationsManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.model.adapter.TLUsers;
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
        if (Adjust.getDefaultInstance() != null) {
            Adjust.onResume();
        }
    }

    @Override
    public void permission(PermissionsManager.Permission permission, boolean enable) {

    }

    private void initFacebook() {
        AppFacebookManager appFacebookManager = new AppFacebookManager(getApplicationContext());
        appFacebookManager.init();
        if (getCurrentUserLoged() == null) {
            appFacebookManager.logout();
        }
    }

    private void initAnalytics() {
//        AnalyticsManager.initTracker(this, R.string.google_analytics_key);

        String appToken = getString(R.string.adjust_token);
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
        Adjust.onCreate(config);
    }

    private void init() {
        AppDataBaseManager.initDataBase(getApplicationContext());
        buildComponentAndInject();
        AppRestManager.configureRestManager(getConfig(), appUserSessionManager);
        initFacebook();
        initAnalytics();
    }

    public void buildComponentAndInject() {
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
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
}
