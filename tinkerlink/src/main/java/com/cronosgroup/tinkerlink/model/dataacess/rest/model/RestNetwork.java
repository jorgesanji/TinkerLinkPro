package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 7/14/16.
 */
public class RestNetwork extends RestBase {

    private List<String> tinkerCategories = new ArrayList<>();
    private List<String> linkerCategories = new ArrayList<>();
    private List<RestUser> contactsFriend = new ArrayList<>();

    public RestNetwork() {
    }

    public List<String> getTinkerCategories() {
        return tinkerCategories;
    }

    public void setTinkerCategories(List<String> tinkerCategories) {
        this.tinkerCategories = tinkerCategories;
    }

    public List<String> getLinkerCategories() {
        return linkerCategories;
    }

    public void setLinkerCategories(List<String> linkerCategories) {
        this.linkerCategories = linkerCategories;
    }

    public List<RestUser> getContactsFriend() {
        return contactsFriend;
    }

    public void setContactsFriend(List<RestUser> contactsFriend) {
        this.contactsFriend = contactsFriend;
    }
}
