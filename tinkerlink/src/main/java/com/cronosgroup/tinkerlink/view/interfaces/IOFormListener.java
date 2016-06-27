package com.cronosgroup.tinkerlink.view.interfaces;

import com.cronosgroup.tinkerlink.model.business.model.AppUser;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public interface IOFormListener {
    AppUser getFormUser();

    void setFormUser(AppUser appUser);
}