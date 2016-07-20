package com.cronosgroup.tinkerlink.model.mapper;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
public class RestUsers {

    public static TLUser toUserDb(RestUser user) {
        TLUser userDb = new TLUser();
        userDb.setName(user.getName());
        userDb.setBirthday(user.getBirthday());
        userDb.setEmail(user.getEmail());
        userDb.setGender(user.getGender());
        userDb.setIdUser(user.getId());
        userDb.setPhoto(user.getPhoto());
        userDb.setLoged(false);
        return userDb;
    }

}
