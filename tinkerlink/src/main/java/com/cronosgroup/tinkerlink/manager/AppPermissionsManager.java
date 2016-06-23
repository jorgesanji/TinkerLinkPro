package com.cronosgroup.tinkerlink.manager;

import android.content.Context;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.BaseActivity;


/**
 * Created by jorgesanmartin on 1/21/16.
 */
public class AppPermissionsManager extends PermissionsManager {

    public AppPermissionsManager(BaseActivity activity) {
        super(activity);
    }

    public AppPermissionsManager(Context context) {
        super(context);
    }

    public AppPermissionsManager() {
        super(null);
    }
}
