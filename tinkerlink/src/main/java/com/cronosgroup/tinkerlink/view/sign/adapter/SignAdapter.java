package com.cronosgroup.tinkerlink.view.sign.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.view.sign.fragments.phone.PhoneFragment;
import com.cronosgroup.tinkerlink.view.sign.fragments.facebook.FacebookFragment;
import com.cronosgroup.tinkerlink.view.sign.fragments.validation.ValidationFragment;

/**
 * Created by jorgesanmartin on 11/16/15.
 */
public class SignAdapter extends FragmentStatePagerAdapter {
    public static final int FACEBOOK_PAGE = 0;
    public static final int PHONE_PAGE = 1;
    public static final int VALIDATION_PAGE = 2;

    // Vars
    private final Context mContext;

    public SignAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FACEBOOK_PAGE:
                return Fragment.instantiate(mContext, FacebookFragment.class.getName());
            case PHONE_PAGE:
                return Fragment.instantiate(mContext, PhoneFragment.class.getName());
            default:
                return Fragment.instantiate(mContext, ValidationFragment.class.getName());
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
