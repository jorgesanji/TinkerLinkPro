package com.cronosgroup.tinkerlink.model.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.core.view.sectionable.Item;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.event.UpdateUserContactsEvent;
import com.cronosgroup.tinkerlink.model.manager.model.Contact;
import com.cronosgroup.tinkerlink.model.manager.model.EntryItem;
import com.cronosgroup.tinkerlink.model.manager.model.SectionItem;
import com.cronosgroup.tinkerlink.model.business.logic.ContactsUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by jorgesanmartin on 11/30/15.
 */
public class AppContactsManager {

    public static int PHONEBOOK_CONTACTS = 1;
    public static int SUGGESTION_CONTACTS = 2;
    public static int TINKELINK_CONTACTS = 3;

    public interface IORecoverContactsInOrder {
        void onContacts(Pair<List<Item>, List<Item>> pair);
    }

    @Inject
    AppUserSessionManager mUserSessionManager;

    private AppPermissionsManager permissionsManager;
    private Context mContext;
    private Gson mGson = new Gson();

    List<Item> userContacts = new ArrayList<>();
    List<Item> contactFromAgenda = new ArrayList<>();
    List<Item> tinkerLinksContacts = new ArrayList<>();
    List<Item> suggestionContacts = new ArrayList<>();

    public AppContactsManager(Context context) {
        this.mContext = context;
        this.permissionsManager = new AppPermissionsManager(context);
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }

    private String getContactsWithName() {
        long startTime = System.currentTimeMillis();

        List listContants = new ArrayList<>();

        String[] PROJECTION = new String[]{
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.TYPE,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI,
        };

        ContentResolver cr = mContext.getContentResolver();
        Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PROJECTION, null, null, null);
        if (cursor != null) {
            try {
                final int idIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
                final int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                final int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                String telephone = "";
                String name = "";
                while (cursor.moveToNext()) {
                    String image = cursor.getString(idIndex);

                    telephone = cursor.getString(numberIndex);
                    telephone = telephone.replace(" ", "");
                    telephone = telephone.replace("+", "");
                    telephone = telephone.replace("-", "");
                    telephone = telephone.replace("#", "");
                    telephone = telephone.replace("*", "");

                    List<String> emailList = new ArrayList<String>();

                    Cursor emails = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + image, null, null);
                    while (emails.moveToNext()) {
                        String emailAddress = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        if ((!emailAddress.equalsIgnoreCase("")) && (emailAddress.contains("@"))) {
                            emailList.add(emailAddress);
                        }
                    }
                    emails.close();

                    if (telephone != null && telephone.length() != 0) {
                        name = cursor.getString(nameIndex);
                        listContants.add(new Contact().setName(name).setPhoneNumber(telephone).setPhoto(image).setMail(emailList));
                    }
                }

            } finally {
                cursor.close();
            }
        }

        long totalTime = System.currentTimeMillis() - startTime;
        Log.d("Time to retrieve", totalTime + " miliseg");

        return mGson.toJson(listContants);
    }


    private static Pair<List<Item>, List<Item>> createSeccionableList(List<RestContact> list, boolean recoverTinkerLinkUsers) {
        List<Item> seccionableItems = new ArrayList<>();
        List<Item> tinkerItems = new ArrayList<>();

        if (!list.isEmpty()) {

            RestContact contact = list.get(0);
            String firstsLetter = contact.getUser().getName().substring(0, 1).toUpperCase();
            String firstsLetterTinker = "";

            seccionableItems.add(new SectionItem(firstsLetter));
            seccionableItems.add(new EntryItem(contact));

            if (recoverTinkerLinkUsers && contact.isAccepted()) {
                firstsLetterTinker = firstsLetter;
                tinkerItems.add(new SectionItem(firstsLetter));
                tinkerItems.add(new EntryItem(contact));
            }

            list.remove(contact);

            for (RestContact contacto : list) {
                String newfirstsLetter = contacto.getUser().getName().substring(0, 1).toUpperCase();
                if (!firstsLetter.equalsIgnoreCase(newfirstsLetter)) {
                    firstsLetter = newfirstsLetter;
                    seccionableItems.add(new SectionItem(newfirstsLetter));
                }

                seccionableItems.add(new EntryItem(contacto));

                if (recoverTinkerLinkUsers && contacto.isAccepted()) {
                    if (!firstsLetterTinker.equalsIgnoreCase(newfirstsLetter)) {
                        tinkerItems.add(new SectionItem(newfirstsLetter));
                        firstsLetterTinker = newfirstsLetter;
                    }

                    tinkerItems.add(new EntryItem(contacto));
                }
            }
        }

        return new Pair<List<Item>, List<Item>>(seccionableItems, tinkerItems);
    }


    // Public methods

    public void setContext(AppCompatActivity mContext) {
        this.mContext = mContext;
    }

    public void loadContacts() {
        if (permissionsManager.checkContactPermissions()) {
            loadContactsFromPhoneBook();
        }
        loadSuggestionContacts();
        loadUserContacts();
    }

    public void loadContactsFromPhoneBook() {
        AsyncLoader asyncLoader = new AsyncLoader<String>() {
            @Override
            public String doInBackground() {
                return getContactsWithName();
            }

            @Override
            public void postProcess(String result) {
                ContactsUseCases.getContactsFromAgenda(result, new Callback<List<RestContact>, RestError>() {
                    @Override
                    public void onResponse(List<RestContact> response) {
                        getListSectionableAndOrderAlphabetical(response, new IORecoverContactsInOrder() {
                            @Override
                            public void onContacts(Pair<List<Item>, List<Item>> pair) {
                                contactFromAgenda = (pair == null) ? new ArrayList<Item>() : pair.first;
                                tinkerLinksContacts = (pair == null) ? new ArrayList<Item>() : pair.second;

                                EventBus.getDefault().post(new UpdateUserContactsEvent(contactFromAgenda, PHONEBOOK_CONTACTS));

                            }
                        }, true);
                    }

                    @Override
                    public void onErrorResponse(RestError error) {
                    }

                }, mContext);
            }
        };
        asyncLoader.start();
    }

    public void loadSuggestionContacts() {
        ContactsUseCases.getSuggestionContacts(new Callback<List<RestContact>, RestError>() {
            @Override
            public void onResponse(List<RestContact> response) {
                getListSectionableAndOrderAlphabetical(response, new IORecoverContactsInOrder() {
                    @Override
                    public void onContacts(Pair<List<Item>, List<Item>> pair) {
                        suggestionContacts = (pair == null) ? new ArrayList<Item>() : pair.first;

                        EventBus.getDefault().post(new UpdateUserContactsEvent(suggestionContacts, SUGGESTION_CONTACTS));

                    }
                }, false);
            }

            @Override
            public void onErrorResponse(RestError error) {
            }

        }, mContext);
    }

    public void loadUserContacts() {
        if (mUserSessionManager.getCurrentUser() != null) {
            String idUser = mUserSessionManager.getCurrentUser().getIdUser();
            ContactsUseCases.getUserContacts(idUser, new Callback<List<RestContact>, RestError>() {
                @Override
                public void onResponse(List<RestContact> response) {
                    getListSectionableAndOrderAlphabetical(response, new IORecoverContactsInOrder() {
                        @Override
                        public void onContacts(Pair<List<Item>, List<Item>> pair) {
                            userContacts = (pair == null) ? new ArrayList<Item>() : pair.first;

                            EventBus.getDefault().post(new UpdateUserContactsEvent(userContacts, TINKELINK_CONTACTS));

                        }
                    }, false);
                }

                @Override
                public void onErrorResponse(RestError error) {
                }

            }, mContext);
        }
    }

    public List<Item> getContactFromPhoneBook() {
        return contactFromAgenda;
    }

    public List<Item> getSuggestionContacts() {
        return suggestionContacts;
    }

    public List<Item> getTinkerLinksContacts() {
        return tinkerLinksContacts;
    }

    public List<Item> getUserTinkerLinkContacts() {
        return userContacts;
    }

    public static void getListSectionableAndOrderAlphabetical(final List<RestContact> response, final IORecoverContactsInOrder callback, final boolean recoverTinkerLinkUsers) {

        AsyncLoader asyncLoader = new AsyncLoader<Pair<List<Item>, List<Item>>>() {
            @Override
            public Pair<List<Item>, List<Item>> doInBackground() {

                if (response != null) {
                    Collections.sort(response, new Comparator<RestContact>() {
                        @Override
                        public int compare(RestContact s1, RestContact s2) {
                            return s1.getUser().getName().compareToIgnoreCase(s2.getUser().getName());
                        }
                    });

                    return createSeccionableList(response, recoverTinkerLinkUsers);
                }
                return null;
            }

            @Override
            public void postProcess(Pair<List<Item>, List<Item>> result) {
                if (callback != null) {
                    callback.onContacts(result);
                }
            }
        };

        asyncLoader.start();
    }
}
