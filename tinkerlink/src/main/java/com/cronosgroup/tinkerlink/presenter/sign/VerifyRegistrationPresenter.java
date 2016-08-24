package com.cronosgroup.tinkerlink.presenter.sign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;
import com.cronosgroup.tinkerlink.sms.SMSBroadcastReceiver;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Validation sign presenter.
 */
public class VerifyRegistrationPresenter extends TinkerLinkDialogPresenter<VerifyRegistrationPresenter.View> {

    public static  final String SMS_ACTIVATION= "SMSActivacion";
    public static  final String MESSAGE_ACTIVATION= "mensajeActivacion";

    /**
     * Validation view.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        String getValidationCode();

        void validateUser(RestUser restUser);
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
                    getView().validateUser(null);
                    getView().hideLoading();
                }
            }
        }, 3000);


//        if (code.length() == 6) {
//            getView().showLoading();
//            UserUseCases.checkCode(code, new Callback<RestCode, RestError>() {
//
//                @Override
//                public void onResponse(RestCode restCode) {
//                    getView().hideLoading();
//                    getView().validateUser(restCode.getUser());
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        }
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

            EventBus.getDefault().post(new SmsEvent(codigoActivacion));
        }
    };



    //endregion
}
