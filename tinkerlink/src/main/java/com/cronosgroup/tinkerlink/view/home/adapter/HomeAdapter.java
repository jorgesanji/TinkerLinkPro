package com.cronosgroup.tinkerlink.view.home.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.view.home.MainFragments;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class HomeAdapter extends FragmentStatePagerAdapter {

    // Vars
    private MainFragments[] fragments = {MainFragments.PRENEWSFEED, MainFragments.CONTACTS, MainFragments.CHAT, MainFragments.ACCOUNT};

    private Context mContetxt;

    public HomeAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContetxt = context;
    }

    @Override
    public Fragment getItem(int i) {
        return Fragment.instantiate(mContetxt, fragments[i].getFragment());
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}

