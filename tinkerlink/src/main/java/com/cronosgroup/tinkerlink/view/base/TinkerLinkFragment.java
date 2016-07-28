package com.cronosgroup.tinkerlink.view.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;

import com.cronosgroup.tinkerlink.view.dialog.message.MessageDialogFragment;

/**
 * Created by jorgesanmartin on 7/28/16.
 */
public class TinkerLinkFragment extends Fragment {

    public AppCompatDialogFragment addDialogFragment(Class clazz, int code) {
        return addDialogFragment(clazz, code, null);
    }

    public AppCompatDialogFragment addDialogFragment(Class clazz, int code, Bundle bundle) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        AppCompatDialogFragment fragment = (AppCompatDialogFragment) AppCompatDialogFragment.instantiate(getContext(), clazz.getName());
        fragment.setTargetFragment(this, code);
        fragment.setArguments(bundle);
        fragment.show(fragmentTransaction, clazz.toString());

        return fragment;
    }

    public <F extends Fragment> void addFragment(Class<F> clazz, int container) {
        Fragment currentFragment = Fragment.instantiate(getActivity(), clazz.getName());
        if (currentFragment != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.add(container, currentFragment, clazz.getName());
            transaction.commit();
        }
    }

    public void showDialogMessage(String title, String description, int icon) {
        Bundle bundle = new Bundle();
        bundle.putString(MessageDialogFragment.KEY_TITLE, title);
        bundle.putString(MessageDialogFragment.KEY_DESCRIPTION, description);
        bundle.putInt(MessageDialogFragment.KEY_ICON, icon);
        addDialogFragment(MessageDialogFragment.class, 0, bundle);
    }

    public void removeFragment(String tag) {
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    remove(fragment).commit();
        }
    }
}
