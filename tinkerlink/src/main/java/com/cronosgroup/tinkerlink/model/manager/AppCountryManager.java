package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.cronosgroup.core.managers.AssetsManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class AppCountryManager {

    private final Context mContext;
    private List<RestCountry> countries;
    private RestCountry currentCountry;

    public AppCountryManager(Context context) {
        this.mContext = context;
        loadCountries();
    }

    private List<RestCountry> parseJsonCountries() {
        List<RestCountry> countries = new ArrayList<RestCountry>();

        try {
            String jsonLocation = AssetsManager.getAssetFromFilePath(mContext, "countries/countries.json");
            JSONArray jsonCountries = new JSONArray(jsonLocation);
            Gson gson = new Gson();
            countries = new ArrayList<>();
            for (int i = 0; i < jsonCountries.length(); i++) {
                JSONObject jsonElement = jsonCountries.getJSONObject(i);
                countries.add(gson.fromJson(jsonElement.toString(), RestCountry.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countries;
    }

    private RestCountry findCurrentCountry() {
        String locale = mContext.getResources().getConfiguration().locale.getCountry();
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getIso().equalsIgnoreCase(locale) || countries.get(i).getUn().equalsIgnoreCase(locale)) {
                return countries.get(i);
            }
        }
        return null;
    }

    // Public methods

    public List<RestCountry> getCountries() {
        return countries;
    }

    public RestCountry getCurrentCountry() {
        return currentCountry;
    }

    public static String getCurrentNameFromLocale(Context context, RestCountry country) {
        String locale = context.getResources().getConfiguration().locale.getDisplayLanguage();
        return locale.equalsIgnoreCase("en") ? country.getEn() : country.getEs();
    }

    public void loadCountries() {

        AsyncLoader loader = new AsyncLoader() {

            @Override
            public Objects doInBackground() {
                countries = parseJsonCountries();
                currentCountry = findCurrentCountry();
                return null;
            }

            @Override
            public void postProcess(Object object) {
            }
        };
        loader.start();
    }
}

