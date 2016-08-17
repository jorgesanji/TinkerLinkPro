package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/30/15.
 */
public class ContactsServices extends AppService {

    private static final String ROOT_PATH_CONTACTS = "contacts";
    private static final String ROOT_PATH_NOTIFICATION = "notificacion";

    private static final String URL_GET_CONTACTS = "users/getContactsFromAgenda";
    private static final String URL_GET_CONTACTS_SUGGESTION = "users/getSugerenciasContactos/";
    private static final String URL_GET_CONTACTS_SEARCH = "users/searchUsers/";
    public static final String URL_CONTACTS = "users/getContacts/";
    private static final String URL_ADD_CONTACT = "notificaciones/solicitarContacto/";
    private static final String URL_CANCEL_CONTACT = "notificaciones/respuestaPeticion/";
    private static final String URL_ACCEPT_CONTACT = "notificaciones/respuestaPeticion/";
    private static final String URL_DELETE_CONTACT = "notificaciones/eliminarContacto/";


    public static <T extends RestBase> void getContactsFromAgenda(HashMap<String, String> params, final Class<T> clazz, final Callback callback, Object tag) {

        PUT(URL_GET_CONTACTS, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CONTACTS, clazz, new JsonToModel.Listener<Object, RestError>() {
                            @Override
                            public void mappingFinished(Object response) {
                                if (callback != null) {
                                    callback.onResponse(response);
                                }
                            }

                            @Override
                            public void errorMagpping(RestError error) {
                                if (callback != null) {
                                    callback.onErrorResponse(error);
                                }
                            }
                        });
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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


    public static <T extends RestBase> void getSuggestionContacts(final Class<T> clazz, final Callback callback, Object tag) {

        GET(URL_GET_CONTACTS_SUGGESTION, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CONTACTS, clazz, new JsonToModel.Listener<Object, RestError>() {
                            @Override
                            public void mappingFinished(Object response) {
                                if (callback != null) {
                                    callback.onResponse(response);
                                }
                            }

                            @Override
                            public void errorMagpping(RestError error) {
                                if (callback != null) {
                                    callback.onErrorResponse(error);
                                }
                            }
                        });
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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

    public static <T extends RestBase> void searchContacts(String params, final Class<RestContact> clazz, final Callback<List<RestContact>, RestError> callback, Object tag) {

        String url = URL_GET_CONTACTS_SEARCH + params;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CONTACTS, clazz, new JsonToModel.Listener<List<RestContact>, RestError>() {

                            @Override
                            public void mappingFinished(List<RestContact> contacto) {
                                if (callback != null) {
                                    callback.onResponse(contacto);
                                }
                            }

                            @Override
                            public void errorMagpping(RestError error) {
                                if (callback != null) {
                                    callback.onErrorResponse(error);
                                }
                            }
                        });
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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

    public static <T extends RestBase> void getUserContacts(String params, final Class<T> clazz, final Callback callback, Object tag) {
        String url = URL_CONTACTS + params;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CONTACTS, clazz, new JsonToModel.Listener<Object, RestError>() {
                            @Override
                            public void mappingFinished(Object response) {
                                if (callback != null) {
                                    callback.onResponse(response);
                                }
                            }

                            @Override
                            public void errorMagpping(RestError error) {
                                if (callback != null) {
                                    callback.onErrorResponse(error);
                                }
                            }
                        });
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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


    public static void addContact(String url, final Class clazz, final Callback callback, Object tag) {

        String endpoint = URL_ADD_CONTACT + url;

        POST(endpoint, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_NOTIFICATION, clazz);
                        if (result != null) {
                            callback.onResponse(result);
                        } else {
                            callback.onErrorResponse(RestError.getMappingError());
                        }
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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


    public static void cancelContact(String url, final Class clazz, final Callback callback, Object tag) {

        String endpoint = URL_CANCEL_CONTACT + url;

        PUT(endpoint, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && response.getError() != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_NOTIFICATION, clazz);
                        if (result != null) {
                            callback.onResponse(result);
                        } else {
                            callback.onErrorResponse(RestError.getMappingError());
                        }
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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

    public static void acceptContact(String endpoint, final Class clazz, final Callback callback, Object tag) {

        String url = URL_ACCEPT_CONTACT + endpoint;

        PUT(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_NOTIFICATION, clazz);
                        if (result != null) {
                            callback.onResponse(result);
                        } else {
                            callback.onErrorResponse(RestError.getMappingError());
                        }
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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

    public static void deleteContact(String endpoint, final Class clazz, final Callback callback, Object tag) {

        String url = URL_DELETE_CONTACT + endpoint;

        POST(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_NOTIFICATION, clazz);
                        if (result != null) {
                            callback.onResponse(result);
                        } else {
                            callback.onErrorResponse(RestError.getMappingError());
                        }
                    } else {
                        callback.onErrorResponse(RestError.getRequestError());
                    }
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


