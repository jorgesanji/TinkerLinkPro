package com.cronosgroup.tinkerlink.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.cronosgroup.tinkerlink.model.manager.AppPermissionsManager;

import java.util.Locale;

/**
 * Created by jorgesanmartin on 10/29/15.
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {

    public static final String CODIGO_ACTIVACION_TINKERLINK1_ES = "Tinkerlink: envio de password.";
    public static final String CODIGO_ACTIVACION_TINKERLINK2_ES = "Su password es\n";
    public static final String CODIGO_ACTIVACION_TINKERLINK1_EN = "Tinkerlink: password sent.";
    public static final String CODIGO_ACTIVACION_TINKERLINK2_EN = "Your password is\n";

    @Override
    public void onReceive(Context context, Intent intent) {

        AppPermissionsManager permissionsManager = new AppPermissionsManager(context);

        if (permissionsManager.checkSmsPermissions()) {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                Bundle bundle = intent.getExtras();
                SmsMessage[] msgs = null;
                if (bundle != null) {
                    try {
                        Object[] pdus = (Object[]) bundle.get("pdus");
                        msgs = new SmsMessage[pdus.length];
                        for (int i = 0; i < msgs.length; i++) {
                            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                            String msgBody = msgs[i].getMessageBody();
                            if (Locale.getDefault().getLanguage().equals("es")) {
                                if (msgBody.contains(CODIGO_ACTIVACION_TINKERLINK1_ES) &&
                                        msgBody.contains(CODIGO_ACTIVACION_TINKERLINK2_ES)) {
                                    Intent intento = new Intent("SMSActivacion");
                                    intento.putExtra("mensajeActivacion", msgBody);
                                    LocalBroadcastManager.getInstance(context).sendBroadcast(intento);
                                    break;
                                }
                            } else {
                                if (msgBody.contains(CODIGO_ACTIVACION_TINKERLINK1_EN) &&
                                        msgBody.contains(CODIGO_ACTIVACION_TINKERLINK2_EN)) {
                                    Intent intento = new Intent("SMSActivacion");
                                    intento.putExtra("mensajeActivacion", msgBody);
                                    LocalBroadcastManager.getInstance(context).sendBroadcast(intento);
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.d("", "");
                    }
                }
            }
        }
    }
}
