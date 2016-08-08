package com.cronosgroup.tinkerlink.model.manager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 2/8/16.
 */
public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private List<String> mail = new ArrayList<>();
    private String photo;

    public Contact() {
        super();
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<String> getMail() {
        return mail;
    }

    public Contact setMail(List<String> mail) {
        this.mail = mail;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Contact setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
