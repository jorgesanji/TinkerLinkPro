package com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchalltinkerlink.SearchAllTinkerLinksFragment;
import com.cronosgroup.tinkerlink.view.searchnewsfeed.adapter.pages.searchmycontacts.SearchMyContactsFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class SearchNewsFeedAdapter extends FragmentStatePagerAdapter {

    // Vars
    public static final Class[] fragments = {SearchAllTinkerLinksFragment.class, SearchMyContactsFragment.class};
    public static final int[] titles = {R.string.search_newsfeed_title_tab_alltinkerlink, R.string.search_newsfeed_title_tab_my_contacts};

    private Context mContetxt;

    public SearchNewsFeedAdapter(FragmentManager fm, Context context) {
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

