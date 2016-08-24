package com.cronosgroup.tinkerlink.model.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class AppUser implements Serializable {

//     Current Json from facebook API
//    {
//        "id":"10207727275679157",
//            "birthday":"01/14/1985",
//            "gender":"male",
//            "email":"areason879@hotmail.com",
//            "name":"Jorge Luis Sanmartin"
//    }

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private String idUser;
    private String id;
    private String birthday;
    private String gender;
    private String email;
    private String name;
    private String imageUrl;
    private String originalBitmageBase64;
    private String cropBitmageBase64;
    private String phone;
    private String code;
    private List<String> skills = new ArrayList<>();

    public AppUser() {
        super();
    }

    public AppUser(String id, String birthday, String gender, String email, String name) {
        super();
        this.id = id;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOriginalBitmageBase64() {
        return originalBitmageBase64;
    }

    public void setOriginalBitmageBase64(String originalBitmageBase64) {
        this.originalBitmageBase64 = originalBitmageBase64;
    }

    public String getCropBitmageBase64() {
        return cropBitmageBase64;
    }

    public void setCropBitmageBase64(String cropBitmageBase64) {
        this.cropBitmageBase64 = cropBitmageBase64;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isMale() {
        return (getGender().equalsIgnoreCase("male"));
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
