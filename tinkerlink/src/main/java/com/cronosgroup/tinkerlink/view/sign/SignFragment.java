package com.cronosgroup.tinkerlink.view.sign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.RegistrationStepsEvent;
import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.event.enums.FormState;
import com.cronosgroup.tinkerlink.presenter.sign.SignPresenter;
import com.cronosgroup.tinkerlink.sms.SMSBroadcastReceiver;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.validation.ValidationDialogFragment;
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
    private Fragment mRegistrationSelectorFragment;

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
        this.signScreen = new SignScreen(getActivity(), getFragmentManager());
        signScreen.setListener(this);
        this.mRegistrationSelectorFragment = getFragmentById(R.id.registrationSelectorFragment);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mRegistrationSelectorFragment.onActivityResult(requestCode, resultCode, data);
    }

    //endregion

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

    //region **************  SignPresenter.View **************
    //endregion

    //region **************  SignScreen.Listener **************

    @Override
    public void verifiedPage(int page) {
        if (page == SignAdapter.TINKER || page == SignAdapter.LINKER) {
            signScreen.showNextPage();
        } else if (page == SignAdapter.USERFORM) {
            addDialogFragment(ValidationDialogFragment.class, ValidationDialogFragment.CODE);
        } else {
            getPresenter().goToHome();
        }
    }

    public boolean onBackPressed() {
        return signScreen.showPreviousPage();
    }

    //endregion

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(RegistrationStepsEvent event) {
        if (event.getState() == FormState.SOCIALNETWORK_REGISTRATION) {
            signScreen.removeSocialNetworksPage();
        } else {
            signScreen.showNextPage();
        }
    }

    //endregion

}
