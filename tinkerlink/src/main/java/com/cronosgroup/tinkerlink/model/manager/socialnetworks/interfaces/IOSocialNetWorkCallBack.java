package com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces;

/**
 * Created by jorgesanmartin on 7/21/16.
 */
public interface IOSocialNetWorkCallBack<T> {
    void onResponse(T response);

    void onError(Object response);
}
