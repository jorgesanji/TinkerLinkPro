package com.cronosgroup.tinkerlink.view.home;

import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.view.home.fragment.contacts.ContactsFragment;
import com.cronosgroup.tinkerlink.view.home.fragment.messages.MessagesFragment;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.NewsFeedFragment;
import com.cronosgroup.tinkerlink.view.home.fragment.account.AccountFragment;

/**
 * Enumeration of the fragments that are in the slide menu.
 */

public enum MainFragments {
    NEWSFEED(NewsFeedFragment.class),
    CONTACTS(ContactsFragment.class),
    CHAT(MessagesFragment.class),
    PROFILE(AccountFragment.class);

    private Class<? extends Fragment> fragment;

    private MainFragments(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }

    /**
     * @return the name of the fragment.
     */

    public String getFragment() {
        return fragment.getName();
    }

    public Class getClassFragment() {
        return fragment;
    }
}
