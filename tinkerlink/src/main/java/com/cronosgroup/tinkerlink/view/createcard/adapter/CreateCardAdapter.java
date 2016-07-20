package com.cronosgroup.tinkerlink.view.createcard.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category.CategorySelectionFragment;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.experience.ExperienceSelectionFragment;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.skills.SkillsSelectionFragment;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CreateCardAdapter extends FragmentStatePagerAdapter {

    public static final Class[] fragments = {CategorySelectionFragment.class, SkillsSelectionFragment.class, ExperienceSelectionFragment.class};
    private final Context mContext;

    public CreateCardAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment.instantiate(mContext, fragments[position].getName());
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public Context getmContext() {
        return mContext;
    }
}
