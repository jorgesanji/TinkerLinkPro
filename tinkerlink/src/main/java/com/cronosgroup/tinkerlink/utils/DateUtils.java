package com.cronosgroup.tinkerlink.utils;

import android.content.Context;

import com.cronosgroup.tinkerlink.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class DateUtils {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String DATE_TO_PRINT_IN_POST = "MMM dd yy, hh:mm";
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public static String getCurrentDateTime() {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        return df.format(Calendar.getInstance().getTime());
    }

    public static String getInterval(Date date, Context context) {

        if (date == null) {
            date = new Date();
        }

        long time = date.getTime();

        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = new Date().getTime();

        final long diff = now - time;
        if (diff < MINUTE_MILLIS || diff == 0) {
            return context.getString(R.string.time_just_now);
        } else if (diff < 2 * MINUTE_MILLIS) {
            return context.getString(R.string.time_minute_ago);
        } else if (diff < 50 * MINUTE_MILLIS) {
            return String.format(context.getString(R.string.time_minutes_ago), String.valueOf(diff / MINUTE_MILLIS));
        } else if (diff < 90 * MINUTE_MILLIS) {
            return context.getString(R.string.time_hour_ago);
        } else if (diff < 24 * HOUR_MILLIS) {
            return String.format(context.getString(R.string.time_hours_ago), String.valueOf(diff / HOUR_MILLIS));
        } else if (diff < 48 * HOUR_MILLIS) {
            return context.getString(R.string.time_yesterday);
        } else {
            return  android.text.format.DateFormat.format(DATE_TO_PRINT_IN_POST, date).toString();
        }
    }
}
