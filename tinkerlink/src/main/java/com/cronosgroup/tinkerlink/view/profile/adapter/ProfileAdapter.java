package com.cronosgroup.tinkerlink.view.profile.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.profile.adapter.pages.userinformation.UserInformationFragment;
import com.cronosgroup.tinkerlink.view.profile.adapter.pages.userrecommendation.UserRecommendationsFragment;
import com.cronosgroup.tinkerlink.view.profile.adapter.pages.useractivity.UserActivityFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class ProfileAdapter extends FragmentStatePagerAdapter {

    // Vars
    public static final Class[] fragments = {UserInformationFragment.class, UserRecommendationsFragment.class, UserActivityFragment.class};
    public static final int[] titles = {R.string.profile_page_user_information, R.string.profile_page_user_recommendation, R.string.profile_page_user_activity};

    private Context mContetxt;

    public ProfileAdapter(FragmentManager fm, Context context) {
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
