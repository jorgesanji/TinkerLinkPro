package com.cronosgroup.tinkerlink.model.business.logic;

import android.util.Pair;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.core.view.sectionable.Item;
import com.cronosgroup.tinkerlink.model.manager.AppContactsManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.ContactsServices;
import com.cronosgroup.tinkerlink.utils.DateUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class ContactsUseCases {

    public static final String KEY_SEARCH = "texto";
    public static final String KEY_CONTACTS = "contacts";

    public static void getContactsFromAgenda(String param, final Callback<List<RestContact>, RestError> callback, Object tag) {

        HashMap<String, String> params = new HashMap<>();
        params.put(KEY_CONTACTS, param);

        ContactsServices.getContactsFromAgenda(params, RestContact.class, callback, tag);
    }

    public static void getSuggestionContacts(final Callback callback, Object tag) {
        ContactsServices.getSuggestionContacts(RestContact.class, callback, tag);
    }

    public static void searchContacts(String texto, String offset, final Callback callback, Object tag) {

        String params = texto + "/" + offset;

        ContactsServices.searchContacts(params, RestContact.class, new Callback<List<RestContact>, RestError>() {
            @Override
            public void onResponse(List<RestContact> response) {
                if (callback != null) {
                    AppContactsManager.getListSectionableAndOrderAlphabetical(response, new AppContactsManager.IORecoverContactsInOrder() {
                        @Override
                        public void onContacts(Pair<List<Item>, List<Item>> pair) {
                            callback.onResponse(pair.first);
                        }
                    }, false);
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }

        }, tag);
    }

    public static void getUserContacts(String params, final Callback callback, Object tag) {
        ContactsServices.getUserContacts(params, RestContact.class, callback, tag);
    }

    public static void addContact(String idUser, final Callback callback, Object tag) {
        String endpoint = idUser + "/" + DateUtils.getCurrentDateTime();
        ContactsServices.addContact(endpoint, RestNotificacion.class, new Callback<RestNotificacion, RestError>() {
            @Override
            public void onResponse(RestNotificacion response) {

//                if (TinkerLinkApplication.getApp() != null) {
//                    TinkerLinkApplication.getApp().loadContacts();
//                }

                if (callback != null) {
                    callback.onResponse(response);
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }
        }, tag);
    }

    public static void cancelContact(long idNotification, final Callback callback, Object tag) {
        String endpoint = String.valueOf(idNotification) + "/false/" + DateUtils.getCurrentDateTime();
        ContactsServices.cancelContact(endpoint, RestNotificacion.class, new Callback<RestNotificacion, RestError>() {
            @Override
            public void onResponse(RestNotificacion response) {

//                if (TinkerLinkApplication.getApp() != null) {
//                    TinkerLinkApplication.getApp().loadContacts();
//                }

                if (callback != null) {
                    callback.onResponse(response);
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }
        }, tag);
    }

    public static void acceptContact(long idNotification, final Callback callback, Object tag) {
        String endpoint = String.valueOf(idNotification) + "/true/" + DateUtils.getCurrentDateTime();
        ContactsServices.acceptContact(endpoint, RestNotificacion.class, new Callback<RestNotificacion, RestError>() {
            @Override
            public void onResponse(RestNotificacion response) {

//                if (TinkerLinkApplication.getApp() != null) {
//                    TinkerLinkApplication.getApp().loadContacts();
//                }

                if (callback != null) {
                    callback.onResponse(response);
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }
        }, tag);
    }

    public static void deleteContact(String idUser, final Callback callback, Object tag) {
        String endpoint = idUser + "/" + DateUtils.getCurrentDateTime();
        ContactsServices.deleteContact(endpoint, RestNotificacion.class, new Callback<RestNotificacion, RestError>() {
            @Override
            public void onResponse(RestNotificacion response) {

//                if (TinkerLinkApplication.getApp() != null) {
//                    TinkerLinkApplication.getApp().loadContacts();
//                }

                if (callback != null) {
                    callback.onResponse(response);
                }
            }

            @Override
            public void onErrorResponse(RestError error) {
                if (callback != null) {
                    callback.onErrorResponse(error);
                }
            }
        }, tag);
    }
}
