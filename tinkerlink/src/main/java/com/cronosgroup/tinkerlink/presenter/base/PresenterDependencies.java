package com.cronosgroup.tinkerlink.presenter.base;

import android.location.Geocoder;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.manager.AppImagePickerManager;
import com.cronosgroup.tinkerlink.model.manager.AppUserSessionManager;

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

    @Inject
    protected Geocoder geocoder;

    public PresenterDependencies() {
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }
}
