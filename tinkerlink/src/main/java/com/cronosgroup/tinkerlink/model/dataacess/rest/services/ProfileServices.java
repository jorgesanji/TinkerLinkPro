package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestBase;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 12/10/15.
 */
public class ProfileServices extends AppService {

    private static final String ROOT_PATH_USER = "contact";
    private static final String ROOT_PATH_NOTIFICATION = "notificacion";
    private static final String ROOT_PATH_ACTIVITY = "posts";
    private static final String ROOT_PATH_POST = "post";
    private static final String ROOT_PATH_UPDATE_USER = "usuario";
    private static final String ROOT_PATH_UPLOAD_USER_GALLERY_PHOTO = "photo";

    private static final String URL_GET_PROFILE = "profiles/getPerfil/";
    private static final String URL_GET_ACTIVITY = "posts/getPostsUser/";
    private static final String URL_UPDATE_PHOTO = "profiles/updateFoto";
    private static final String URL_DELETE_PHOTO = "profiles/updateFoto";
    private static final String URL_DELETE_CONTACT = "notificaciones/eliminarContacto/";
    private static final String URL_BLOCK_CONTACT = "notificaciones/bloquearContacto/";
    private static final String URL_UPDATE_PROFILE = "profiles/upsertPerfil/";
    private static final String URL_ADD_GALLERY_PHOTO_PROFILE = "profiles/uploadFoto/";
    private static final String URL_REQUEST_RECOMENDATION = "notificaciones/pedirRecomendacion/";
    private static final String URL_GIVE_RECOMENDATION = "posts/createRecomendacion/";
    private static final String URL_GIVE_LIKE = "profiles/like/";
    private static final String URL_SHARE_PROFILE = "profiles/compartirPerfil/";


    public static void getProfile(String endpoint, final Class clazz, final Callback callback, Object tag) {

        String url = URL_GET_PROFILE + endpoint;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_USER, clazz);
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


    public static <T extends RestBase> void getActivityUser(String endpoint, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_GET_ACTIVITY + endpoint;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_ACTIVITY, clazz, new JsonToModel.Listener<Object, RestError>() {
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

    public static void updatePhoto(HashMap<String, String> maps, final Class clazz, final Callback callback, Object tag) {

        PUT(URL_UPDATE_PHOTO, maps, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_UPDATE_USER, clazz);
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


    public static void deletePhoto(final Class clazz, final Callback callback, Object tag) {

        PUT(URL_DELETE_PHOTO, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_UPDATE_USER, clazz);
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

    public static void blockContact(String idUser, final Class clazz, final Callback callback, Object tag) {

        String url = URL_BLOCK_CONTACT + idUser;

        PUT(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_USER, clazz);
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


    public static void updateProfile(HashMap<String, String> params, final Class clazz, final Callback callback, Object tag) {

        PUT(URL_UPDATE_PROFILE, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_UPDATE_USER, clazz);
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


    public static void uploadGalleryImage(HashMap<String, String> params, final Callback callback, Object tag) {

        POST(URL_ADD_GALLERY_PHOTO_PROFILE, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_UPLOAD_USER_GALLERY_PHOTO, String.class);
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


    public static void requestRecommendation(String endpoint, HashMap<String, String> params, final Callback callback, Object tag) {

        endpoint = URL_REQUEST_RECOMENDATION + endpoint;
        POST(endpoint, params, getHeaders(), new Callback<RestResponse, RestError>() {
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


    public static void giveRecommendation(String endpoint, HashMap<String, String> params, final Class clazz, final Callback callback, Object tag) {

        endpoint = URL_GIVE_RECOMENDATION + endpoint;
        PUT(endpoint, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_NOTIFICATION, clazz);
                        callback.onResponse(result);
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

    public static void giveLike(String endpoint, final Callback callback, Object tag) {

        endpoint = URL_GIVE_LIKE + endpoint;
        PUT(endpoint, null, getHeaders(), new Callback<RestResponse, RestError>() {
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


    public static void shareProfile(String endpoint, final Class clazz, final Callback callback, Object tag) {

        endpoint = URL_SHARE_PROFILE + endpoint;
        POST(endpoint, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), ROOT_PATH_POST, clazz);
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