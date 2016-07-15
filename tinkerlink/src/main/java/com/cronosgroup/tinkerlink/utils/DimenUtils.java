package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by jorgesanmartin on 7/14/16.
 */
public class DimenUtils {

    public static float getPixelsFromDp(Context context, float dp) {
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

}
