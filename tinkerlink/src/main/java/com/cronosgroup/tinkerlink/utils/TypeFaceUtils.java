package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;

import com.cronosgroup.tinkerlink.enums.Font;

/**
 * Font utils.
 */
public class TypeFaceUtils {
    private static final String TAG = "TypeFaceUtils";

    // Public methods

    /**
     * @param context
     * @param font
     * @return
     */
    public static Typeface getFont(Context context, String font) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + font);
            return tf;
        } catch (Exception e) {
            Log.e(TAG, "Could not get typeface: " + e.getMessage());
        }
        return null;
    }

    public static Typeface getFontWithFlag(Context context, int type) {

        if (type == Font.REGULAR.getType()) {
            return getRegularFont(context);
        } else if (type == Font.BOLD.getType()) {
            return getBoldFont(context);
        } else if (type == Font.LIGTH.getType()) {
            return getLightFont(context);
        } else if (type == Font.SEMIBOLD.getType()) {
            return getSemiBoldFont(context);
        }

        return null;
    }


    /**
     * @return
     */
    public static Typeface getRegularFont(Context context) {
        return getFont(context, Font.REGULAR.getFontName());
    }

    /**
     * @return
     */
    public static Typeface getBoldFont(Context context) {
        return getFont(context, Font.BOLD.getFontName());
    }

    /**
     * @return
     */
    public static Typeface getLightFont(Context context) {
        return getFont(context, Font.LIGTH.getFontName());
    }

    /**
     * @return
     */
    public static Typeface getSemiBoldFont(Context context) {
        return getFont(context, Font.SEMIBOLD.getFontName());
    }

    public static SpannableString getStringByFontType(Context context, String text, Font type) {
        Typeface typeFace = TypeFaceUtils.getFont(context, type.getFontName());
        SpannableString spannableText = new SpannableString(text);
        spannableText.setSpan(new TLTypeFaceSpan("", typeFace),
                0, spannableText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableText;
    }


}
