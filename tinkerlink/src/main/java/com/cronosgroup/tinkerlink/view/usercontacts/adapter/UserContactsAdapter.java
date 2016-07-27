package com.cronosgroup.tinkerlink.view.usercontacts.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.usercontacts.adapter.pages.AllUserContactsFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class UserContactsAdapter extends FragmentStatePagerAdapter {

    // Vars
    public static final Class[] fragments = {AllUserContactsFragment.class, AllUserContactsFragment.class};
    public static final int[] titles = {R.string.contacts_in_common, R.string.contacts_all};

    private Context mContetxt;

    public UserContactsAdapter(FragmentManager fm, Context context) {
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
        return String.format(mContetxt.getResources().getString(titles[position], String.valueOf(getCount())));
    }
}

