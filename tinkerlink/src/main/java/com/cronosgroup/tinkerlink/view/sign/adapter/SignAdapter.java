package com.cronosgroup.tinkerlink.view.sign.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.formuser.FormUserFragment;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.profile.SignProfileFragment;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.TLinkerSelectorFragment;

/**
 * Created by jorgesanmartin on 11/16/15.
 */
public class SignAdapter extends FragmentStatePagerAdapter {
    public static final int TINKER = 0;
    public static final int LINKER = 1;
    public static final int USERFORM = 2;
    public static final int VALITATION = 3;

    Class[] fragments = {TLinkerSelectorFragment.class, TLinkerSelectorFragment.class, FormUserFragment.class, SignProfileFragment.class};

    // Vars
    private final Context mContext;

    public SignAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        if (position == 0) {
            bundle.putSerializable(TLinkerSelectorFragment.KEY_TYPE, StackCard.TINKER);
        } else if (position == 1) {
            bundle.putSerializable(TLinkerSelectorFragment.KEY_TYPE, StackCard.LINKER);
        }

        return Fragment.instantiate(mContext, fragments[position].getName(), bundle);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}
