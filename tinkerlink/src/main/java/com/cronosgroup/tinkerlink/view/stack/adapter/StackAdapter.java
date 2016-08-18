package com.cronosgroup.tinkerlink.view.stack.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;
import com.cronosgroup.tinkerlink.view.stack.adapter.stackcards.StackCardsFragment;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class StackAdapter extends FragmentStatePagerAdapter {

    // Vars
    private StackCardType[] stackCardsType = {StackCardType.TINKER, StackCardType.LINKER};

    private Context mContetxt;

    public StackAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContetxt = context;
    }

    @Override
    public Fragment getItem(int i) {
        StackCardsFragment fragment = (StackCardsFragment) Fragment.instantiate(mContetxt, StackCardsFragment.class.getName());
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, stackCardsType[i]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return stackCardsType.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(mContetxt.getResources().getString(stackCardsType[position].getStackTitle()));
    }
}

