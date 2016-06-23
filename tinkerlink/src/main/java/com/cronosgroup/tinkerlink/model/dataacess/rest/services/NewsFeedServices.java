package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.dataacess.rest.mapping.JsonToModel;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestBase;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 11/6/15.
 */
public class NewsFeedServices extends AppService {

    private static final String TYPE_SEARCH = "noticias/";

    private static final String ROOT_PATH_POSTS = "posts";
    private static final String ROOT_PATH_POST = "post";


    private static final String URL_LIKE_POSTS = "posts/like/";
    private static final String URL_NEWS_FEED_POSTS = "posts/getPosts/";
    private static final String URL_NEWS_FEED_SEARCH_POSTS = "posts/search/";
    private static final String URL_NEWS_FEED_SHARE_POST = "posts/share/";
    private static final String URL_NEWS_FEED_SEND_CHAT = "chat/enviarMensaje/";
    private static final String URL_NEWS_FEED_RECOMENDATIONS = "posts/getRecomendaciones/";
    private static final String URL_SEND_STATUS = "posts/createEstado/";


    public static <T extends RestBase> void getPosts(String offset, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_NEWS_FEED_POSTS + offset;

        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_POSTS, clazz, new JsonToModel.Listener<Object, RestError>() {

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

    public static void likePost(final String idPost, final Callback callback, Object tag) {

        String url = URL_LIKE_POSTS + idPost;

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


    public static <T extends RestBase> void searchNewsFeedPost(String text, HashMap<String, String> params, final Class<T> clazz, final Callback callback, Object tag) {

        String url = URL_NEWS_FEED_SEARCH_POSTS + TYPE_SEARCH + text;

        POST(url, params, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_POSTS, clazz, new JsonToModel.Listener<Object, RestError>() {
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


    public static void sharePost(String url, HashMap<String, String> params, final Class clazz, final Callback callback, Object tag) {

        String endpoint = URL_NEWS_FEED_SHARE_POST + url;

        POST(endpoint, params, getHeaders(), new Callback<RestResponse, RestError>() {
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


    public static <T extends RestBase> void getRecommendations(String url, final Class<T> type, final Callback callback, Object tag) {

        String endpoint = URL_NEWS_FEED_RECOMENDATIONS + url;

        GET(endpoint, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        mappingListInBackground(response.getData(), ROOT_PATH_POSTS, type, new JsonToModel.Listener<Object, RestError>() {
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

    public static <T extends RestBase> void sendStatus(HashMap<String, String> params, final Class<T> clazz, final Callback callback, Object tag) {

        String endpoint = URL_SEND_STATUS;

        POST(endpoint, params, getHeaders(), new Callback<RestResponse, RestError>() {
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
