package com.cronosgroup.tinkerlink.presenter.base;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.manager.AppImagePickerManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class PresenterDependencies {

    @Inject
    public AppCountryManager appCountryManager;

    @Inject
    public AppConfigManager appConfigManager;

    @Inject
    protected AppUserSessionManager appUserSessionManager;

    @Inject
    protected AppImagePickerManager appImagePickerManager;

    public PresenterDependencies() {
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }
}
