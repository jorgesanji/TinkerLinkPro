package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestBase;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

/**
 * Created by jorgesanmartin on 10/1/16.
 */
public class NotificationsServices extends AppService {

    private static final String ROOT_PATH_NOTIFICATIONS = "notificaciones";
    private static final String ROOT_PATH_NOTIFICATION = "notificacion";

    private static final String NOTIFICACIONES_GET_NOTIFICACIONES = "notificaciones/getNotificaciones/";
    private static final String URL_DELETE_NOTIFICATION = "notificaciones/deleteNotificacion/";
    private static final String URL_NOTIFICATIONS_RESPONSE_RECOMMENDATIONS = "notificaciones/respuestaRecomendacion/";
    private static final String URL_NOTIFICATIONS_CHECK_READED = "notificaciones/marcarLeida/";

    public static <T extends RestBase> void getNotifications(String endpoint, final Class<T> clazz, final Callback callback, Object tag) {

        String url = NOTIFICACIONES_GET_NOTIFICACIONES + endpoint;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_NOTIFICATIONS, clazz, new JsonToModel.Listener<Object ,RestError>() {
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

    public static void deleteNotification(String endpoint, final Callback callback, Object tag) {

        String url = URL_DELETE_NOTIFICATION + endpoint;

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


    public static void responseRecommendation(String endpoint, final Class clazz, final Callback callback, Object tag) {

        String url = URL_NOTIFICATIONS_RESPONSE_RECOMMENDATIONS + endpoint;

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

    public static void checkNotificationReaded(String endpoint, final Callback callback, Object tag) {

        String url = URL_NOTIFICATIONS_CHECK_READED + endpoint;

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
}