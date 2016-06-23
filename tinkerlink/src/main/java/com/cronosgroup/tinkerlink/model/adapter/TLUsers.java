package com.cronosgroup.tinkerlink.model.adapter;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
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
        restUser.setVisibility(user.getVisibility());

        RestProfile profile = new RestProfile();
        profile.setDescripcion(user.getJobDescription());
        restUser.setProfile(profile);

        return restUser;
    }

    public static RestContacto toContact(TLUser user, boolean isMe) {

        RestUser restUser = new RestUser();
        restUser.setMe(isMe);
        restUser.setId(user.getIdUser());
        restUser.setPhoto(user.getPhoto());
        restUser.setName(user.getName());

        RestProfile profile = new RestProfile();
        profile.setDescripcion(user.getJobDescription());
        restUser.setProfile(profile);

        RestContacto restContacto = new RestContacto();
        restContacto.setStatus(user.getStatus());
        restContacto.setUser(restUser);

        return restContacto;
    }

}
