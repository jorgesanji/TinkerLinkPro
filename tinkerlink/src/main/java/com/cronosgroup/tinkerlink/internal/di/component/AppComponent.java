package com.cronosgroup.tinkerlink.internal.di.component;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.gcm.GcmRegistrationDevice;
import com.cronosgroup.tinkerlink.internal.di.module.AppModule;
import com.cronosgroup.tinkerlink.model.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.presenter.base.PresenterDependencies;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jorgesanmartin on 2/5/16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TinkerLinkActivity<MVPTinkerLinkFragment> activity);

    void inject(TinkerLinkApplication app);

    void inject(AppContactsManager manager);

    void inject(GcmRegistrationDevice manager);

    void inject(PresenterDependencies dependencies);

}
