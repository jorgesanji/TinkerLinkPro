package com.cronosgroup.tinkerlink.view.createcard.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category.CategorySelectionFragment;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.experience.ExperienceSelectionFragment;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.skills.SkillsSelectionFragment;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.tinkerexperience.TinkerExperienceSelectionFragment;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CreateCardAdapter extends FragmentStatePagerAdapter {

    public static final Class[] lfragments = {CategorySelectionFragment.class, SkillsSelectionFragment.class, ExperienceSelectionFragment.class};
    public static final Class[] tfragments = {CategorySelectionFragment.class, SkillsSelectionFragment.class, TinkerExperienceSelectionFragment.class};
    private final Context mContext;
    private Class[] fragments;
    private StackCardType type;

    public CreateCardAdapter(FragmentManager fm, Context mContext, StackCardType type) {
        super(fm);
        this.mContext = mContext;
        this.type = type;
        this.fragments = (type == StackCardType.LINKER) ? lfragments : tfragments;
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

    public StackCardType getType() {
        return type;
    }

    public void setType(StackCardType type) {
        this.type = type;
    }
}
