package com.cronosgroup.tinkerlink.presenter.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.interfaces.IOUserLogin;
import com.cronosgroup.tinkerlink.model.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.sms.SMSBroadcastReceiver;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by jorgesanmartin on 2/23/16.
 */
public class TinkerLinkPresenter<V extends TinkerLinkPresenterView> extends PresenterDependencies implements Presenter<V> {

    // Vars
    public static final String ACTIVATION_SMS = "SMSActivacion";
    public static final String ACTIVATION_MESSAGE = "mensajeActivacion";

    // Views

    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public V getView() {
        return view;
    }

    public PermissionsManager getPermissionManager() {
        return ((BaseActivity) getView().getActivity()).getPermissionsManager();
    }

    public void login(final IOUserLogin userLogin) {

        ((BaseActivity) getView().getActivity()).setPermissionListener(new PermissionsManager.IOAppPermission() {
            @Override
            public void permission(PermissionsManager.Permission permission, boolean enable) {
                if (permission == PermissionsManager.Permission.CONTACTOS) {

                    if (!getPermissionManager().checkLocationPermissions()) {
                        getPermissionManager().requestLocationPermission();
                    } else {

                        if (userLogin != null) {
                            userLogin.login();
                        }
                    }

                } else if (permission == PermissionsManager.Permission.LOCATION) {

                    if (userLogin != null) {
                        userLogin.login();
                    }
                }
            }
        });

        if (!getPermissionManager().checkContactPermissions()) {
            getPermissionManager().requestContactPermission();
        } else if (!getPermissionManager().checkLocationPermissions()) {
            getPermissionManager().requestLocationPermission();
        } else {
            if (userLogin != null) {
                userLogin.login();
            }
        }
    }

    public void initSmsHandler() {
        ((BaseActivity) getView().getActivity()).setPermissionListener(new PermissionsManager.IOAppPermission() {
            @Override
            public void permission(PermissionsManager.Permission permission, boolean enable) {
                if (permission == PermissionsManager.Permission.LOCATION && enable) {
                    LocalBroadcastManager.getInstance(getView().getActivity()).registerReceiver(recepcionMensajeActivacion,
                            new IntentFilter(ACTIVATION_SMS));
                }
            }
        });

        if (!getPermissionManager().checkSmsPermissions()) {
            getPermissionManager().requestSmsPermission();
        } else {
            LocalBroadcastManager.getInstance(getView().getActivity()).registerReceiver(recepcionMensajeActivacion,
                    new IntentFilter(ACTIVATION_SMS));
        }
    }

    private BroadcastReceiver recepcionMensajeActivacion = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mensaje = intent.getStringExtra(ACTIVATION_MESSAGE);
            String codigoActivacion = "";
            if (LocaleUtils.isES()) {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES.length());
            } else {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN.length());
            }

            EventBus.getDefault().post(new SmsEvent(codigoActivacion));
        }
    };

    public AppUserSessionManager getAppUserSessionManager() {
        return appUserSessionManager;
    }

    public AppCountryManager getAppCountryManager() {
        return appCountryManager;
    }

    public AppConfigManager getAppConfigManager() {
        return appConfigManager;
    }
}
