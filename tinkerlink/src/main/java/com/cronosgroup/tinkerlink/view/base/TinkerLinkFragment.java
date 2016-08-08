package com.cronosgroup.tinkerlink.view.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;

import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.message.MessageDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.messageoptions.MessageOptionsDialogFragment;

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

    public <F extends Fragment> void addFragment(Class<F> clazz, int container, String name) {
        Fragment currentFragment = Fragment.instantiate(getActivity(), clazz.getName());
        if (currentFragment != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.add(container, currentFragment, name != null ? name : clazz.getName());
            transaction.commit();
        }
    }

    public <F extends Fragment> void addFragment(Class<F> clazz, int container) {
        addFragment(clazz, container, null);
    }

    public void showDialogMessage(String title, String description, int icon) {
        Bundle bundle = new Bundle();
        bundle.putString(TinkerDialogFragment.TITLE_KEY, title);
        bundle.putString(TinkerDialogFragment.DESCRIPTION_KEY, description);
        bundle.putInt(TinkerDialogFragment.ICON_KEY, icon);
        addDialogFragment(MessageDialogFragment.class, 0, bundle);
    }

    public void showDialogMessage(int title, int description, int icon) {
        showDialogMessage(getString(title), getString(description), icon);
    }

    public void showDialogMessageOptions(String title, String description, String actionButtonText, Bundle bundle) {
        if (bundle != null) {
            bundle = new Bundle();
        }
        bundle.putString(TinkerDialogFragment.TITLE_KEY, title);
        bundle.putString(TinkerDialogFragment.DESCRIPTION_KEY, description);
        bundle.putString(TinkerDialogFragment.ACTION_BUTTON_KEY, actionButtonText);
        addDialogFragment(MessageOptionsDialogFragment.class, MessageOptionsDialogFragment.CODE, bundle);
    }

    public void showDialogMessageOptions(String title, String description, Bundle bundle) {
        showDialogMessageOptions(title, description, null, bundle);
    }

    public void showDialogMessageOptions(int title, int description) {
        showDialogMessageOptions(getString(title), getString(description), null, null);
    }

    public void showDialogMessageOptions(int title, int description, Bundle bundle) {
        showDialogMessageOptions(getString(title), getString(description), null, bundle);
    }

    public void removeFragment(String tag) {
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    remove(fragment).commit();
        }
    }

    public Fragment getFragmentById(int id) {
        return getActivity().getSupportFragmentManager().findFragmentById(id);
    }

    public boolean onBackPressed() {
        return false;
    }
}
