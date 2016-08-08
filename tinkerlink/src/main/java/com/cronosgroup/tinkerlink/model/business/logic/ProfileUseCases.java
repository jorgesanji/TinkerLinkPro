package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.model.business.model.UserForm;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.ProfileServices;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jorgesanmartin on 12/10/15.
 */
public class ProfileUseCases {

    public static final String KEY_PHOTO = "foto";
    public static final String KEY_PHOTO_CROPPED = "foto2";

    private static final String CATEGORY_KEY = "categoria";
    private static final String PROFESSION_KEY = "profesion";
    private static final String HABILITIES_KEY = "habilidades";
    private static final String DESCRIPTION_KEY = "descripcion";
    private static final String COUNTRY_KEY = "pais";
    private static final String CITY_KEY = "ciudad";
    private static final String LONGITUDE_KEY = "latitude";
    private static final String LATITUDE_KEY = "longitude";
    private static final String ESTUDIES_KEY = "estudios";
    private static final String IDUSERS_KEY = "destinations";

    private static final String TEXT_KEY = "texto";
    private static final String REQUESTRECOMMENDATION_KEY = "requestRecommendation";
    private static final String IDNOTIFICATION_KEY = "idNotification";


    public static void getProfile(String idUser, Callback<RestContacto, RestError> callback, Object tag) {
        ProfileServices.getProfile(idUser, RestContacto.class, callback, tag);
    }

    public static void getActivityUser(String params, Callback callback, Object tag) {
//        ProfileServices.getActivityUser(params, RestPost.class, callback, tag);
    }

    public static void updatePhoto(String foto, String fotoCropped, Callback callback, Object tag) {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put(KEY_PHOTO, foto);
        parameters.put(KEY_PHOTO_CROPPED, fotoCropped);

        ProfileServices.updatePhoto(parameters, RestUser.class, callback, tag);
    }

    public static void deletePhoto(Callback callback, Object tag) {
        ProfileServices.deletePhoto(RestUser.class, callback, tag);
    }

    public static void blockContact(String idUser, Callback callback, Object tag) {
        ProfileServices.blockContact(idUser, RestUser.class, callback, tag);
    }

    public static void updateProfile(UserForm form, Callback callback, Object tag) {

        HashMap<String, String> params = new HashMap<>();
        params.put(CATEGORY_KEY, form.getCategory());
        params.put(PROFESSION_KEY, form.getProfession());
        params.put(HABILITIES_KEY, AppRestManager.mapping.mappingToStringJson(form.getHabilitiesAsString()));
        params.put(ESTUDIES_KEY, form.getEstudiesAsString());
        params.put(COUNTRY_KEY, form.getCountry());
        params.put(CITY_KEY, form.getCity());
        params.put(LATITUDE_KEY, String.valueOf(form.getLatitude()));
        params.put(LONGITUDE_KEY, String.valueOf(form.getLongitude()));
        params.put(DESCRIPTION_KEY, form.getDescription());

        ProfileServices.updateProfile(params, RestUser.class, callback, tag);
    }

    public static void uploadGalleryImage(String foto, final Callback callback, Object tag) {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put(KEY_PHOTO, foto);

        ProfileServices.uploadGalleryImage(parameters, callback, tag);
    }

    public static void requestRecommendation(List<String> idUsers, Callback callback, Object tag) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put(IDUSERS_KEY, AppRestManager.mapping.mappingToStringJson(idUsers));
        String endpoint = DateUtils.getCurrentDateTime() + "/" + LocaleUtils.getCurrentLanguage();
        ProfileServices.requestRecommendation(endpoint, parameters, callback, tag);
    }

    public static void giveRecommendation(String idNotification, String idUsers, String text, boolean requestRecomendation, Callback callback, Object tag) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put(TEXT_KEY, text);
        parameters.put(REQUESTRECOMMENDATION_KEY, String.valueOf(requestRecomendation));
        parameters.put(IDNOTIFICATION_KEY, idNotification);
        String endpoint = idUsers + "/" + DateUtils.getCurrentDateTime();
        ProfileServices.giveRecommendation(endpoint, parameters, RestNotificacion.class, callback, tag);
    }

    public static void giveLike(String idUser, Callback callback, Object tag) {
        ProfileServices.giveLike(idUser, callback, tag);
    }

    public static void shareProfile(String idUser, Callback callback, Object tag) {
        String endpoint = idUser + "/" + DateUtils.getCurrentDateTime() + "/" + LocaleUtils.getCurrentLanguage();
        ProfileServices.shareProfile(endpoint, RestPost.class, callback, tag);
    }
}
