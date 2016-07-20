package com.cronosgroup.tinkerlink.view.sign;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.cronosgroup.tinkerlink.event.FormRegistrationEvent;
import com.cronosgroup.tinkerlink.event.FormValidationEvent;
import com.cronosgroup.tinkerlink.event.NextPageEvent;
import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.event.enums.FormState;
import com.cronosgroup.tinkerlink.presenter.sign.SignPresenter;
import com.cronosgroup.tinkerlink.sms.SMSBroadcastReceiver;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.sign.adapter.SignAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Locale;


/**
 * Sign Fragment
 */
public class SignFragment extends MVPTinkerLinkFragment<SignPresenter, SignPresenter.View>
        implements SignPresenter.View, SignScreen.Listener {

    private SignScreen signScreen;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSmsBroadCastReceiver();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        signScreen = new SignScreen(getActivity(), getFragmentManager());
        signScreen.setListener(this);
        return signScreen;
    }

    @Override
    protected SignPresenter createPresenter() {
        return new SignPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected SignPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        signScreen.initAdapter();
    }

    //endregion

    //region **************  SignPresenter.View **************
    //endregion

    //region **************  SignScreen.Listener **************

    @Override
    public void verifiedPage(int page) {
        switch (page) {
            case SignAdapter.FACEBOOK_PAGE:
                EventBus.getDefault().post(new FormRegistrationEvent(FormState.FACEBOOK));
                break;
            case SignAdapter.PHONE_PAGE:
                EventBus.getDefault().post(new FormRegistrationEvent(FormState.PHONE));
                break;
            default:
                EventBus.getDefault().post(new FormRegistrationEvent(FormState.VALIDATION));
        }
    }
    //endregion

    public boolean onBackPressed() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        return signScreen.showPreviousPage();
    }

    private void initSmsBroadCastReceiver() {
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.recepcionMensajeActivacion,
                new IntentFilter("SMSActivacion"));
    }

    private BroadcastReceiver recepcionMensajeActivacion = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mensaje = intent.getStringExtra("mensajeActivacion");
            String codigoActivacion = "";
            if (Locale.getDefault().getLanguage().equals("es")) {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_ES.length());
            } else {
                codigoActivacion = mensaje.substring(mensaje.indexOf(SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN)
                        + SMSBroadcastReceiver.CODIGO_ACTIVACION_TINKERLINK2_EN.length());
            }

            EventBus.getDefault().post(new SmsEvent(codigoActivacion));
        }
    };

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(FormValidationEvent event) {
        if (event.isValidation()) {
            int index = signScreen.showNextPage();
            EventBus.getDefault().post(new NextPageEvent(FormState.stateFromIndex(index)));
        }
    }

    //endregion

}
