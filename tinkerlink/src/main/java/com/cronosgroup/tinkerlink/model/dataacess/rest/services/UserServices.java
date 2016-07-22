package com.cronosgroup.tinkerlink.model.dataacess.rest.services;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestResponse;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.base.AppService;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 14/10/15.
 */
public class UserServices extends AppService {

    public static final String KEY_USER = "usuario";

    private static final String URL_LOGOUT = "users/singOut";
    private static final String URL_LOGIN = "api/login/";
    public static final String URL_GET_CODIGO = "api/getCodigoYPass/";
    public static final String URL_SET_USER = "api/setUser/";
    public static final String URL_CHECK_CODE = "api/checkCode/";
    public static final String URL_RETRIEVE_PASSWORD = "api/retrievePassword/";
    public static final String URL_SET_VISIBILITY = "users/setVisibility/";
    public static final String URL_INVITE = "users/invitar";


    public static void doLogin(String params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_LOGIN + params;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), clazz);
                        if (result != null) {
                            AppService.saveSessionToken(response.getToken());
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

    public static void doLogout(HashMap<String, String> params, final Callback callback, Object tag) {
        String url = URL_LOGOUT;
        PUT(url, params, getHeaders(), new Callback<RestResponse, RestError>() {
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

    public static void checkCode(String params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_CHECK_CODE + params;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), clazz);
                        if (result != null) {
                            AppService.saveSessionToken(response.getToken());
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

    public static void getCodeAndPassword(String params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_GET_CODIGO + params;
        GET(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), clazz);
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

    public static void setUser(String url, HashMap<String, String> param, final Class clazz, final Callback callback, Object tag) {
        String endpoint = URL_SET_USER + url;
        PUT(endpoint, param, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), clazz);
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

    public static void recoveryPassword(String params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_RETRIEVE_PASSWORD + params;
        GET(url, new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), clazz);
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

    public static void setVisibility(int params, final Class clazz, final Callback callback, Object tag) {
        String url = URL_SET_VISIBILITY + params;
        PUT(url, null, getHeaders(), new Callback<RestResponse, RestError>() {
            @Override
            public void onResponse(RestResponse response) {
                if (callback != null) {
                    if (response != null && !response.getError().hasError()) {
                        Object result = mappingJson(response.getData(), KEY_USER, clazz);
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

    public static void inviteUser(HashMap<String, String> params, final Callback callback, Object tag) {
        String url = URL_INVITE;
        POST(url, params, getHeaders(), new Callback<RestResponse, RestError>() {
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
