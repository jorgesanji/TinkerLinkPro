package com.cronosgroup.tinkerlink.model.mapper;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
public class TLUsers {

    public static RestUser toRest(TLUser user, boolean isMe) {

        RestUser restUser = new RestUser();
        restUser.setMe(isMe);
        restUser.setId(user.getIdUser());
        restUser.setPhoto(user.getPhoto());
        restUser.setName(user.getName());
        restUser.setBirthday(user.getBirthday());
        restUser.setEmail(user.getEmail());

        return restUser;
    }

    public static RestContact toContact(TLUser user, boolean isMe) {

        RestUser restUser = new RestUser();
        restUser.setMe(isMe);
        restUser.setId(user.getIdUser());
        restUser.setPhoto(user.getPhoto());
        restUser.setName(user.getName());

        RestContact restContact = new RestContact();
//        restContact.setStatus(user.getStatus());
        restContact.setUser(restUser);

        return restContact;
    }

}
