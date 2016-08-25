package com.cronosgroup.tinkerlink.presenter.sign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;
import com.cronosgroup.tinkerlink.sms.SMSBroadcastReceiver;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;

/**
 * Validation sign presenter.
 */
public class PhoneRegistrationPresenter extends TinkerLinkDialogPresenter<PhoneRegistrationPresenter.View> {

    public static final String SMS_ACTIVATION = "SMSActivacion";
    public static final String MESSAGE_ACTIVATION = "mensajeActivacion";

    /**
     * Validation view.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        String getValidationCode();

        String getPhoneNumber();

        String getPassword();

        void setCode(String code);

        void setValidCode(boolean validCode);
    }

    //region **************  BasePresenter **************

    @Override
    public void destroy() {
        super.destroy();
        LocalBroadcastManager.getInstance(getView().getActivity()).unregisterReceiver(recepcionMensajeActivacion);
    }

    //endregion

    //region **************  View Actions **************

    public void checkCode() {
        String code = getView().getValidationCode();
        getView().showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().hideLoading();
                    getView().setValidCode(true);
                }
            }
        }, 3000);

    }

    public void sendPhoneNumber() {
        String phoneNumber = getView().getPhoneNumber();
        getView().showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().hideLoading();
                    getView().setCode("3456");
                }
            }
        }, 3000);
    }

    public void createAccount() {
        String password = getView().getPassword();
        getView().showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().hideLoading();
                    navigation.onLaunchUserFormRegistration(getView().getActivity(), null);
                }
            }
        }, 3000);
    }

    public void initSmsBroadCastReceiver() {
        LocalBroadcastManager.getInstance(getView().getActivity()).registerReceiver(this.recepcionMensajeActivacion,
                new IntentFilter(SMS_ACTIVATION));
    }

    private BroadcastReceiver recepcionMensajeActivacion = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mensaje = intent.getStringExtra(MESSAGE_ACTIVATION);
            String codigoActivacion = "";
            if (LocaleUtils.isES()) {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES.length());
            } else {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN.length());
            }

            getView().setCode(codigoActivacion);
        }
    };


    //endregion
}
