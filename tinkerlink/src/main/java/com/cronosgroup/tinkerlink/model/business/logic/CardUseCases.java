package com.cronosgroup.tinkerlink.model.business.logic;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.CardServices;

import java.util.HashMap;

/**
 * Created by jorgesanmartin on 11/20/15.
 */
public class CardUseCases {

    public static final int TYPE_LINKER = 1;
    public static final int TYPE_TINKER = 2;

    private static final String TINKER_KEY = "tinker/";
    private static final String LINKER_KEY = "linker/";

    private static final String CREATE_TINKER_KEY = "createTinker";
    private static final String CREATE_LINKER_KEY = "createLinker";

    private static final String CATEGORY_KEY = "categoria";
    private static final String PROFESSION_KEY = "profesion";
    private static final String HABILITIES_KEY = "habilidades";
    private static final String DESCRIPTION_KEY = "descripcion";
    private static final String COUNTRY_KEY = "pais";
    private static final String CITY_KEY = "ciudad";
    private static final String DURATION_KEY = "duracion";
    private static final String SALARY_TYPE_KEY = "tipoSalario";
    private static final String SALARY_KEY = "salario";
    private static final String EXPERIENCE_KEY = "experiencia";
    private static final String IMAGES_KEY = "fotos";
    private static final String LONGITUDE_KEY = "latitude";
    private static final String LATITUDE_KEY = "longitude";


    public static void getAllCards(int type, String offset, Callback callback, Object tag) {
        String endpoint = ((type == TYPE_LINKER) ? LINKER_KEY : TINKER_KEY) + offset;

//        CardServices.getCards(endpoint, RestPost.class, callback, tag);
    }

    public static void getUserCards(String idUser, int type, String offset, Callback callback, Object tag) {
        String endpoint = idUser + "/" + ((type == TYPE_LINKER) ? LINKER_KEY : TINKER_KEY) + offset;

//        CardServices.getUserCards(endpoint, RestPost.class, callback, tag);
    }

    public static void createCard(int type, RestPost form, Callback callback, Object tag) {
        String endpoint = ((type == TYPE_LINKER) ? CREATE_LINKER_KEY : CREATE_TINKER_KEY);

        HashMap<String, String> params = new HashMap<>();
        params.put(CATEGORY_KEY, form.getCategoria());
        params.put(PROFESSION_KEY, form.getProfesion());
        params.put(HABILITIES_KEY, AppRestManager.sharedManager().getMapperUsed().toJson(form.getHabilidades()));
        params.put(DURATION_KEY, form.getTipoProyecto());
        params.put(SALARY_TYPE_KEY, form.getTipoCambio());
        params.put(SALARY_KEY, form.getCosteAproximado());
        params.put(EXPERIENCE_KEY, form.getExperiencia());
        params.put(IMAGES_KEY, AppRestManager.sharedManager().getMapperUsed().toJson(form.getFotoString()));
        params.put(COUNTRY_KEY, form.getPais());
        params.put(CITY_KEY, form.getCiudad());
        params.put(LATITUDE_KEY, String.valueOf(form.getLatitude()));
        params.put(LONGITUDE_KEY, String.valueOf(form.getLongitude()));
        params.put(DESCRIPTION_KEY, form.getDescripcion());

//        CardServices.createCard(endpoint, params, RestPost.class, callback, tag);
    }

    public static void searchCards(int type, String text, Callback callback, Object tag) {
        String endpoint = ((type == TYPE_LINKER) ? LINKER_KEY : TINKER_KEY) + text;

//        CardServices.searchCards(endpoint, RestPost.class, callback, tag);
    }

    public static void deleteCard(String endpoint, final Callback callback, Object tag) {
        CardServices.deleteCard(endpoint, callback, tag);
    }

}
