package com.cronosgroup.tinkerlink.view.home;

import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.view.home.adapter.fragment.account.AccountFragment;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.chat.ChatFragment;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.ContactsFragment;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.newsfeed.NewsFeedFragment;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.prenewsfeed.PreNewsFeedFragment;

/**
 * Enumeration of the fragments that are in the slide menu.
 */

public enum MainFragments {
    PRENEWSFEED(PreNewsFeedFragment.class),
    CONTACTS(ContactsFragment.class),
    CHAT(ChatFragment.class),
    ACCOUNT(AccountFragment.class),
    NEWSFEED(NewsFeedFragment.class);

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
