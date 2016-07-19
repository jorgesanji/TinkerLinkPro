package com.cronosgroup.tinkerlink.internal.di.component;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.gcm.GcmRegistrationDevice;
import com.cronosgroup.tinkerlink.internal.di.module.AppModule;
import com.cronosgroup.tinkerlink.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.manager.AppFacebookShareManager;
import com.cronosgroup.tinkerlink.manager.model.EntryItem;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.view.base.TinkerDialogFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jorgesanmartin on 2/5/16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TinkerLinkActivity<TinkerLinkFragment> activity);

    void inject(TinkerLinkApplication app);

    void inject(AppContactsManager manager);

    void inject(GcmRegistrationDevice manager);

    void inject(AppFacebookShareManager appFacebookShareManager);

    void inject(EntryItem entryItem);

    void inject(TinkerDialogFragment dialogFragment);

    void inject(TinkerLinkFragment tinkerLinkFragment);

    void inject(TinkerLinkPresenter <Presenter.View> presenter);

}
