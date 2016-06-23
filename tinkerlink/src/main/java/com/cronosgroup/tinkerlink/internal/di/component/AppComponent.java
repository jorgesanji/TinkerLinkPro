package com.cronosgroup.tinkerlink.internal.di.component;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.gcm.GcmRegistrationDevice;
import com.cronosgroup.tinkerlink.internal.di.module.AppModule;
import com.cronosgroup.tinkerlink.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.manager.AppFacebookShareManager;
import com.cronosgroup.tinkerlink.manager.model.EntryItem;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jorgesanmartin on 2/5/16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TinkerLinkActivity activity);

    void inject(TinkerLinkApplication app);

    void inject(AppContactsManager manager);

    void inject(GcmRegistrationDevice manager);

//    void inject(ViewHolderPostBase viewHolderPostBase);

    void inject(AppFacebookShareManager appFacebookShareManager);

    void inject(EntryItem entryItem);

//    void inject(TinkerLinkPresenter tinkerLinkPresenter);
}
