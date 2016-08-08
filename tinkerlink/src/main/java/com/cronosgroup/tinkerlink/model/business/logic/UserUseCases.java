package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.manager.model.Contact;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCode;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestLogin;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecovery;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestSign;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.UserServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class UserUseCases {

    public static final String KEY_USER_NAME = "nombre";
    public static final String KEY_USER_PICTURE = "foto";
    public static final String KEY_USER_PICTURE_CROP = "croppedFoto";
    public static final String KEY_USER_BIRTHDAY = "cumpleanos";
    public static final String KEY_USER_SEX = "sexo";
    public static final String KEY_NEW_USER = "false";
    public static final String KEY_REG_ID = "regId";
    public static final String KEY_RECEIPTS = "receipts";


    public static void doLogin(String param, final Callback callback, Object tag) {
        UserServices.doLogin(param, RestLogin.class, callback, tag);
    }

    public static void doLogout(String token, final Callback callback, Object tag) {

        HashMap<String, String> params = new HashMap<>();
        params.put(KEY_REG_ID, token);

        UserServices.doLogout(params, callback, tag);
    }

    public static void getCodeAndPassword(String param, Callback callback, Object tag) {
        UserServices.getCodeAndPassword(param, RestCode.class, callback, tag);
    }

    public static void checkCode(String param, final Callback callback, Object tag) {
        UserServices.checkCode(param, RestCode.class, callback, tag);
    }

    public static void recoveryPassword(String param, Callback callback, Object tag) {
        UserServices.recoveryPassword(param, RestRecovery.class, callback, tag);
    }

    public static void setUser(AppUser user, Callback callback, Object tag) {

        String codigo = user.getCode();
        String telefono = user.getPhone();
        String email = user.getEmail();

        String url = codigo + telefono + "/" +
                email + "/" + KEY_NEW_USER;

        HashMap<String, String> params = new HashMap<String, String>();
        params.put(KEY_USER_NAME, user.getName());
        params.put(KEY_USER_PICTURE, user.getOriginalBitmageBase64());
        params.put(KEY_USER_PICTURE_CROP, user.getCropBitmageBase64());
        params.put(KEY_USER_BIRTHDAY, user.getBirthday());
        params.put(KEY_USER_SEX, "" + user.getGender().charAt(0));

        UserServices.setUser(url, params, RestSign.class, callback, tag);
    }


    public static void setVisibility(int param, Callback callback, Object tag) {
        UserServices.setVisibility(param, RestUser.class, callback, tag);
    }

    public static void inviteUser(RestUser restUser, Callback callback, Object tag) {
        List<Contact> contacts = new ArrayList<>();

        Contact contact = new Contact();
        contact.setName(restUser.getName());
        contact.setPhoneNumber(restUser.getPhone());

        if (restUser.getEmail() != null && !restUser.getEmail().isEmpty()) {
            List<String> emails = new ArrayList<>();
            emails.add(restUser.getEmail());
            contact.setMail(emails);
        }

        contacts.add(contact);

        HashMap<String, String> params = new HashMap<>();
        params.put(KEY_RECEIPTS, AppRestManager.mapping.mappingToJson(contacts));

        UserServices.inviteUser(params, callback, tag);
    }
}
