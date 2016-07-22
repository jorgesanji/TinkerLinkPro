package com.cronosgroup.tinkerlink.manager.socialnetworks;

import android.content.Intent;

import com.cronosgroup.tinkerlink.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.cronosgroup.tinkerlink.manager.socialnetworks.interfaces.IOSocialNetWorkSignCallBack;

/**
 * Created by jorgesanmartin on 7/21/16.
 */
public interface IOSocialNetwork<T extends Object> {

    void LogIn(IOSocialNetWorkCallBack<T> callBack);

    void LogOut(IOSocialNetWorkSignCallBack callBack);

    void revokeAccess(IOSocialNetWorkSignCallBack callBack);

    boolean onActivityResult(int requestCode, int resultCode, Intent data);
}
