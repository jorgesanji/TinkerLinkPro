package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 11/19/15.
 */
public class CardServices extends AppService {

    private static final String ROOT_PATH_CARDS = "posts";
    private static final String ROOT_PATH_CARD = "post";

    private static final String URL_GET_ALL_CARDS = "posts/getAllCards/";
    private static final String URL_GET_SEARCH_CARDS = "posts/search/";
    private static final String URL_CREATE_CARD = "posts/";
    private static final String URL_GET_USER_CARDS = "posts/getCards/";
    private static final String URL_DELETE_USER_CARDS = "posts/deletePost/";


    public static <T extends RestBase> void getCards(String endpoint, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_GET_ALL_CARDS + endpoint;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {

            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CARDS, clazz, new JsonToModel.Listener<Object, RestError>() {
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

    public static <T extends RestBase> void getUserCards(String endpoint, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_GET_USER_CARDS + endpoint;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {

            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CARDS, clazz, new JsonToModel.Listener<Object, RestError>() {
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


    public static <T extends RestBase> void createCard(String endpoint, HashMap<String, String> params, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_CREATE_CARD + endpoint;

        POST(url, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object object = mappingJson(response.getData(), ROOT_PATH_CARD, clazz);
                        if (object != null) {
                            callback.onResponse(object);
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

    public static <T extends RestBase> void searchCards(String endpoint, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_GET_SEARCH_CARDS + endpoint;

        POST(url, null, getHeaders(), new Callback<RestResponse, RestError>() {

            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_CARDS, clazz, new JsonToModel.Listener<Object, RestError>() {
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


    public static void deleteCard(String endpoint, final Callback callback, Object tag) {

        String url = URL_DELETE_USER_CARDS + endpoint;

        DELETE(url, null, getHeaders(), new Callback<RestResponse, RestError>() {

            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null) {
                        callback.onResponse(response.getError().hasError());
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