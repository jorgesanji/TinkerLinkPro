package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 14/10/15.
 */
public class ChatServices extends AppService {

    public static final String MESSAGE_KEY = "mensaje";
    public static final String MESSAGES_KEY = "conversaciones";

    private static final String URL_SEND_MESSAGE = "chat/enviarMensaje/";
    private static final String URL_MESSAGES_UNREAD = "chat/getMensajesNoLeidos/";
    private static final String URL_REMOVE_CHAT = "chat/deleteConversacion/";
    private static final String URL_CHECK_MESSAGES = "chat/marcarLeidosConversacion/";


    public static void sendMessage(String endpoint, HashMap<String, String> params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_SEND_MESSAGE + endpoint;
        PUT(url, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), MESSAGE_KEY, clazz);
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

    public static <T extends RestBase> void getMessagesUnRead(final Class<T> clazz, final Callback callback, Object tag) {
        String url = URL_MESSAGES_UNREAD;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), MESSAGES_KEY, clazz, new JsonToModel.Listener<Object, RestError>() {
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

    public static void removeChat(String endpoint, final Callback callback, Object tag) {
        String url = URL_REMOVE_CHAT + endpoint;
        PUT(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
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

    public static void checkAllMessages(String endpoint, final Callback callback, Object tag) {
        String url = URL_CHECK_MESSAGES + endpoint;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
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
