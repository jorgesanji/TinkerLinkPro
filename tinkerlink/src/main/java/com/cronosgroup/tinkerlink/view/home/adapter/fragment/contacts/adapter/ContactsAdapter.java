package com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.mycontacts.MyContactsFragment;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.requestcontacts.RequestContactsFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class ContactsAdapter extends FragmentStatePagerAdapter {

    // Vars
    public static final Class[] fragments = {MyContactsFragment.class, RequestContactsFragment.class};
    public static final int[] titles = {R.string.contacts_my_contacts, R.string.contacts_request_contacts};

    private Context mContetxt;

    public ContactsAdapter(FragmentManager fm, Context context) {
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

