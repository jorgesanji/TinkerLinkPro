package com.cronosgroup.tinkerlink.internal.di.module;

import android.content.Context;
import android.location.Geocoder;

import com.cronosgroup.core.managers.LocationManager;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.interfaces.IONavigation;
import com.cronosgroup.tinkerlink.utils.logger.Logger;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.model.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.manager.AppImagePickerManager;
import com.cronosgroup.tinkerlink.model.manager.AppMessagesManager;
import com.cronosgroup.tinkerlink.model.manager.AppNotificationsManager;
import com.cronosgroup.tinkerlink.model.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.view.AppNavigation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgesanmartin on 2/5/16.
 */

@Module
public class AppModule {
    private final TinkerLinkApplication application;

    public AppModule(TinkerLinkApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    TinkerLinkApplication getApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    AppUserSessionManager provideUserSessionManager() {
        return new AppUserSessionManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    IONavigation providerNavigation() {
        return new AppNavigation();
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return new LocationManager(provideApplicationContext());
    }

    @Provides
    AppCountryManager provideCountryManager() {
        return new AppCountryManager(provideApplicationContext());
    }

    @Provides
    Logger providerLooger() {
        return new Logger();
    }

    @Provides
    AppImagePickerManager providerPickerImage() {
        return new AppImagePickerManager();
    }

    @Provides
    AppConfigManager provideConfigManager() {
        return new AppConfigManager(provideApplicationContext());
    }

    @Provides
    AppNotificationsManager provideNotificationsManager() {
        return new AppNotificationsManager(provideApplicationContext());
    }

    @Provides
    AppMessagesManager provideMessagesManager() {
        return new AppMessagesManager(provideApplicationContext());
    }

    @Provides
    AppContactsManager provideContactsManager() {
        return new AppContactsManager(provideApplicationContext());
    }

    @Provides
    Geocoder provideGeocoder() {
        return new Geocoder(provideApplicationContext());
    }
}
