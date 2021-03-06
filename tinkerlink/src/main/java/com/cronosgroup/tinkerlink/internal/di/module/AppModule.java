package com.cronosgroup.tinkerlink.internal.di.module;

import android.content.Context;

import com.cronosgroup.core.managers.LocationManager;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.logger.Logger;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.manager.AppMessagesManager;
import com.cronosgroup.tinkerlink.manager.AppNotificationsManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;

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
    AppConfigManager provideConfigManager() {
        return new AppConfigManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    AppNotificationsManager provideNotificationsManager() {
        return new AppNotificationsManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    AppMessagesManager provideMessagesManager() {
        return new AppMessagesManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    AppContactsManager provideContactsManager() {
        return new AppContactsManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return new LocationManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    AppCountryManager provideCountryManager() {
        return new AppCountryManager(provideApplicationContext());
    }

    @Provides
    @Singleton
    Logger Logger() {
        return new Logger();
    }
}
