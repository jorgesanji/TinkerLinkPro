package com.cronosgroup.tinkerlink.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import com.cronosgroup.tinkerlink.view.home.HomeActivity;


/**
 * Created by jorgesanmartin on 4/7/16.
 */
public class AppNotificationBuilder {

    private static void showNotification(Context mContext, String title, String message, int icon, int color, Bundle bundle, PendingIntent pendingIntentAction, int iconAction, int textAction) {

        Intent intent = new Intent(mContext, HomeActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(mContext)
                .setSmallIcon(icon)
                .setColor(mContext.getResources().getColor(color))
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        if (pendingIntentAction != null) {
            notificationBuilder.addAction(iconAction, mContext.getString(textAction), pendingIntentAction);
        }

        NotificationManager notificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

    //Public methods

    public static void showNotification(Context mContext, int title, int message, int icon, int color, Bundle bundle) {
        showNotification(mContext, mContext.getString(title), mContext.getString(message), icon, color, bundle, null, -1, -1);
    }

    public static void showNotification(Context mContext, String title, String message, int icon, int color, Bundle bundle) {
        showNotification(mContext, title, message, icon, color, bundle, null, -1, -1);
    }

    public static void showNotification(Context mContext, int title, int message, int icon, int color, Bundle bundle, PendingIntent pendingIntentAction, int iconAction, int textAction) {
        showNotification(mContext, mContext.getString(title), mContext.getString(message), icon, color, bundle, pendingIntentAction, iconAction, textAction);
    }
}
