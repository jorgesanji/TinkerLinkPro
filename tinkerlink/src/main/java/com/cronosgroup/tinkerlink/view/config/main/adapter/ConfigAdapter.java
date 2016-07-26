package com.cronosgroup.tinkerlink.view.config.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.config.main.adapter.pages.useraccount.ConfigAccountUserFragment;
import com.cronosgroup.tinkerlink.view.config.main.adapter.pages.usernotifications.UserNotificationsFragment;

/**
 * Created by jorgesanmartin on 7/26/16.
 */
public class ConfigAdapter extends FragmentStatePagerAdapter {

    // Vars
    public static final Class[] fragments = {ConfigAccountUserFragment.class, UserNotificationsFragment.class};
    public static final int[] titles = {R.string.configuration_account_title, R.string.configuration_notificaciones_title};

    private Context mContetxt;

    public ConfigAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContetxt = context;
    }

    @Override
    public Fragment getItem(int i) {
        return Fragment.instantiate(mContetxt, fragments[i].getName());
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContetxt.getResources().getString(titles[position]);
    }


}
