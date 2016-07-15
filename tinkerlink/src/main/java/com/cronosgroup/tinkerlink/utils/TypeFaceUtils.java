package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

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

        if (type == TLTextView.Font.REGULAR.getType()) {
            return getRegularFont(context);
        } else if (type == TLTextView.Font.BOLD.getType()) {
            return getBoldFont(context);
        } else if (type == TLTextView.Font.LIGTH.getType()) {
            return getLightFont(context);
        } else if (type == TLTextView.Font.SEMIBOLD.getType()) {
            return getSemiBoldFont(context);
        }

        return null;
    }


    /**
     * @return
     */
    public static Typeface getRegularFont(Context context) {
        return getFont(context, "OpenSans-Regular.ttf");
    }

    /**
     * @return
     */
    public static Typeface getBoldFont(Context context) {
        return getFont(context, "OpenSans-Bold.ttf");
    }

    /**
     * @return
     */
    public static Typeface getLightFont(Context context) {
        return getFont(context, "OpenSans-Light.ttf");
    }

    /**
     * @return
     */
    public static Typeface getSemiBoldFont(Context context) {
        return getFont(context, "OpenSans-Semibold.ttf");
    }
}
