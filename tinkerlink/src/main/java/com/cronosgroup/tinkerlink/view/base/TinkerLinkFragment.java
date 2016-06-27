package com.cronosgroup.tinkerlink.view.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;

import javax.inject.Inject;


/**
 * Common functionalities for fragments.
 * Handles life cycle of presenters.
 */
public abstract class TinkerLinkFragment extends Fragment {

    @Inject
    public AppCountryManager appCountryManager;

    @Inject
    public AppUserSessionManager appUserSessionManager;

    @Inject
    public AppConfigManager appConfigManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }
}
