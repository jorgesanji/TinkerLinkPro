package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class RestUser extends RestBase {

    public enum UserStatus {
        ACTIVE("active", 1),
        INACTIVE("inactive", 2),
        UNVERIFIED("unverified", 3),
        UNSIGNED("unsigned", 4),
        BOOKED("booked", 5),
        NONE("none", 6);

        private final String state;
        private final int code;

        UserStatus(String state, int code) {
            this.state = state;
            this.code = code;
        }

        public String getState() {
            return state;
        }

        public int getCode() {
            return code;
        }
    }


    @SerializedName("_id")
    private String id = "";

    @SerializedName("telefono")
    private String phone = "";

    @SerializedName("nombreCompleto")
    private String name = "";

    @SerializedName("sexo")
    private String gender = "";

    @SerializedName("email")
    private String email = "";

    @SerializedName("foto")
    private String photo = "";

    @SerializedName("cumpleanos")
    private String birthday = "";

    @SerializedName("signing")
    private Boolean signing = Boolean.FALSE;

    @SerializedName("usersCompartido")
    private List<String> usersShareProfile = new ArrayList<>();

    @SerializedName("contactos")
    private List<RestContacto> contacts = new ArrayList<>();

    @SerializedName("perfil")
    private RestProfile profile = new RestProfile();

    @SerializedName("linker")
    private int numberLinkers;

    @SerializedName("tinker")
    private int numberTinkers;

    @SerializedName("recommendations")
    private int recommendations;

    @SerializedName("visibility")
    private String visibility = "";

    @SerializedName("duplicado")
    private Boolean duplicate = Boolean.FALSE;

    @SerializedName("state")
    private String state = UserStatus.UNSIGNED.getState();

    private boolean me = false;

    private boolean support = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getSigning() {
        return signing;
    }

    public void setSigning(Boolean signing) {
        this.signing = signing;
    }

    public List<String> getUsersShareProfile() {
        return usersShareProfile;
    }

    public void setUsersShareProfile(List<String> usersShareProfile) {
        this.usersShareProfile = usersShareProfile;
    }

    public List<RestContacto> getContacts() {
        return contacts;
    }

    public void setContacts(List<RestContacto> contacts) {
        this.contacts = contacts;
    }

    public RestProfile getProfile() {
        return profile;
    }

    public void setProfile(RestProfile profile) {
        this.profile = profile;
    }

    public int getNumberLinkers() {
        return numberLinkers;
    }

    public void setNumberLinkers(int numberLinkers) {
        this.numberLinkers = numberLinkers;
    }

    public int getNumberTinkers() {
        return numberTinkers;
    }

    public void setNumberTinkers(int numberTinkers) {
        this.numberTinkers = numberTinkers;
    }

    public int getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(int recommendations) {
        this.recommendations = recommendations;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isMe() {
        return me;
    }

    public RestUser setMe(boolean me) {
        this.me = me;
        return this;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public boolean isActive() {
        return UserStatus.ACTIVE.getState().equalsIgnoreCase(getState());
    }
}
