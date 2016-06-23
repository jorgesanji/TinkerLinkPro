package com.cronosgroup.tinkerlink.utils;

import java.util.Locale;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class LocaleUtils {

    public static final String EN_LANGUAGE = "en";
    public static final String ES_LANGUAGE = "es";
    public static final String ES_LOCALE = "es";

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase(ES_LOCALE) ? ES_LANGUAGE : EN_LANGUAGE;
    }

    public static boolean isEN() {
        return getCurrentLanguage() == EN_LANGUAGE;
    }

    public static boolean isES() {
        return getCurrentLanguage() == EN_LANGUAGE;
    }
}
