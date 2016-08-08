package com.cronosgroup.tinkerlink.model.business.model;

import android.content.res.Resources;
import android.location.Address;
import android.text.TextUtils;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.enums.PostStatus;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestHabilidad;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestStudy;
import com.cronosgroup.tinkerlink.model.mapper.TLUsers;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/20/15.
 */
public class UserForm {

    private Address address;
    private String category;
    private String profession;
    private String experience;
    private String description;
    private String pay;
    private String currency;
    private String time;
    private List<String> images = new ArrayList<>();
    private List<RestHabilidad> habilities = new ArrayList<>();
    private List<RestStudy> estudies = new ArrayList<>();
    private String country;
    private String city;
    private double latitude;
    private double longitude;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCost() {
        return pay;
    }

    public void setCost(String pay) {
        this.pay = pay;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCostByTime() {
        return time;
    }

    public void setCostByTime(String time) {
        this.time = time;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<RestHabilidad> getHabilities() {
        return habilities;
    }

    public void setHabilities(List<RestHabilidad> habilities) {
        this.habilities = habilities;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            setCity(getAddress().getLocality());
            setCountry(getAddress().getCountryName());
            setLatitude(getAddress().getLatitude());
            setLongitude(getAddress().getLongitude());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHabilitiesAsString() {
        List<String> habilities = new ArrayList<>();
        for (RestHabilidad habilidad : getHabilities()) {
            habilities.add(habilidad.getName());
        }
        return habilities;
    }

    public String getEstudiesAsString() {
        Gson gson = new Gson();
        return gson.toJson(getEstudies());
    }

    public List<String> getImageAsString() {
        List<String> bitmaps = new ArrayList<>();
//        for (Bitmap bitmap : getImages()) {
//            bitmaps.add("\"" + BitmapUtils.getBase64StringfromBitmap(bitmap) + "\"");
//        }

        for (String imageBase64 : getImages()) {
            bitmaps.add("\"" + imageBase64 + "\"");
        }
        return bitmaps;
    }

    public List<RestStudy> getEstudies() {
        return estudies;
    }

    public UserForm setEstudies(List<RestStudy> estudios) {
        this.estudies = estudios;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void clearForm() {
        habilities.clear();
        images.clear();
        category = null;
        profession = null;
        experience = null;
        pay = null;
        currency = null;
        time = null;
        description = null;
    }


    public RestPost toRestPost() {
        RestPost restPost = new RestPost();
        restPost.setProfesion(getProfession());
        restPost.setCategoria(getCategory());
        restPost.setHabilidades(getHabilitiesAsString());
        restPost.setExperiencia(getExperience());
        restPost.setCosteAproximado(getCost());
        restPost.setTipoCambio(getCurrency());
        restPost.setTipoProyecto(getCostByTime());
        restPost.setFotoString(getImageAsString());
        restPost.setCiudad(getAddress().getLocality());
        restPost.setPais(getAddress().getCountryName());
        restPost.setLatitude(getAddress().getLatitude());
        restPost.setLongitude(getAddress().getLongitude());
        restPost.setStatus(PostStatus.TO_PUBLISH);
        restPost.setDescripcion(getDescription());

        RestContacto contacto = new RestContacto();
        contacto.setUsuario(TLUsers.toRest(TinkerLinkApplication.getApp().getCurrentUserLoged(), true));

        restPost.setUser(contacto);

        return restPost;
    }

    public String getDescription(Resources resources, boolean isLinker) {
        String resultHabilidades = getProfession();
        if (!getHabilities().isEmpty()) {
            resultHabilidades += " " + resources.getString(isLinker ? R.string.detail_card_user_linker_knowledge : R.string.detail_card_user_knowledge) + " " + TextUtils.join(",", getHabilitiesAsString()).replace("\"", "");
        }
        setDescription(resultHabilidades);

        return resultHabilidades;
    }
}
