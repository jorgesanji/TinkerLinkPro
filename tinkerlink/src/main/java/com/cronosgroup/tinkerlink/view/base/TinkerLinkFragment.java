package com.cronosgroup.tinkerlink.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.utils.TLMMenuBuilder;
import com.cronosgroup.tinkerlink.view.AppSnackManager;
import com.cronosgroup.tinkerlink.view.dialog.base.TinkerDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.message.MessageDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.messageoptions.MessageOptionsDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/28/16.
 */
public abstract class TinkerLinkFragment extends Fragment {

    // Vars
    protected AppSnackManager appStatusMessageManager;
    private boolean readyInitialized = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appStatusMessageManager = new AppSnackManager();
    }

    // Abstract methods

    protected abstract void onDidAppear();

    protected abstract View getRootView();

    protected abstract List<TLMMenuBuilder> getMenuItems();

    /*
     Life cycle
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!readyInitialized) {
            onDidAppear();
            readyInitialized = true;
        }
    }

    /*
        MENU OPTIONS
     */

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        List<TLMMenuBuilder> list = getMenuItems();
        if (list != null) {
            for (final TLMMenuBuilder menuItem : list) {
                final View titleView = menuItem.Build(getActivity());
                final MenuItem mItem = menu.add(0, menuItem.getId(), 0, menuItem.getTitle());
                mItem.setShowAsActionFlags(menuItem.getAction());
                mItem.setActionView(titleView);
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onOptionsItemSelected(mItem);
                    }
                });
            }
            list.clear();
        }
    }

    /*
        DIALOGS
     */

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
        addFragment(clazz, container, null);
    }

    public <F extends Fragment> void addFragment(Class<F> clazz, int container, String name) {
        Fragment currentFragment = Fragment.instantiate(getActivity(), clazz.getName());
        if (currentFragment != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.add(container, currentFragment, name != null ? name : clazz.getName());
            transaction.commit();
        }
    }

    public void showDialogMessage(int title, int description, int icon) {
        showDialogMessage(getString(title), getString(description), icon);
    }

    public void showDialogMessage(String title, String description, int icon) {
        Bundle bundle = new Bundle();
        bundle.putString(TinkerDialogFragment.TITLE_KEY, title);
        bundle.putString(TinkerDialogFragment.DESCRIPTION_KEY, description);
        bundle.putInt(TinkerDialogFragment.ICON_KEY, icon);
        addDialogFragment(MessageDialogFragment.class, 0, bundle);
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

    public void showDialogMessageOptions(String title, String description, String actionButtonText, Bundle bundle) {
        if (bundle != null) {
            bundle = new Bundle();
        }
        bundle.putString(TinkerDialogFragment.TITLE_KEY, title);
        bundle.putString(TinkerDialogFragment.DESCRIPTION_KEY, description);
        bundle.putString(TinkerDialogFragment.ACTION_BUTTON_KEY, actionButtonText);
        addDialogFragment(MessageOptionsDialogFragment.class, MessageOptionsDialogFragment.CODE, bundle);
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
