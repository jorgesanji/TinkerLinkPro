package com.cronosgroup.tinkerlink.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.manager.AppCountryManager;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class TinkerDialogFragment extends AppCompatDialogFragment {

    @Inject
    public AppCountryManager appCountryManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }

}
