package com.cronosgroup.tinkerlink.event;


import com.cronosgroup.core.view.sectionable.Item;

import java.util.List;

/**
 * Created by jorgesanmartin on 2/16/16.
 */
public class UpdateUserContactsEvent {

    private final List<Item> contacts;
    private final int typeContacts;

    public UpdateUserContactsEvent(List<Item> contacts, int typeContacts) {
        this.contacts = contacts;
        this.typeContacts = typeContacts;
    }

    public List<Item> getContacts() {
        return contacts;
    }

    public int getTypeContacts() {
        return typeContacts;
    }
}
