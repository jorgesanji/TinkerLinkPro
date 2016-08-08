package com.cronosgroup.tinkerlink.view.dialog.validation;

import android.view.View;

import com.cronosgroup.tinkerlink.event.FormRegistrationEvent;
import com.cronosgroup.tinkerlink.event.RegistrationStepsEvent;
import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.enums.FormState;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.sign.ValidationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class ValidationDialogFragment extends MVPTinkerLinkDialogFragment<ValidationPresenter, ValidationPresenter.View>
        implements ValidationPresenter.View, ValidationDialogScreen.Listener {

    public static final int CODE = 123;

    //Views
    private ValidationDialogScreen validationDialogScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        validationDialogScreen = new ValidationDialogScreen(getActivity());
        validationDialogScreen.setListener(this);
        return validationDialogScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getPermissionManager().requestSmsPermission();
        validationDialogScreen.show();
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

    @Override
    public void dismiss() {
        validationDialogScreen.dismiss();
        super.dismiss();
    }

    @Override
    public void showLoading() {
        validationDialogScreen.showLoader();
    }

    @Override
    public void hideLoading() {
        validationDialogScreen.hideLoader();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected ValidationPresenter createPresenter() {
        return new ValidationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ValidationPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  ValidationPresenter.View **************

    @Override
    public String getValidationCode() {
        return validationDialogScreen.getValidationCode();
    }

    @Override
    public void validateUser(RestUser restUser) {
        EventBus.getDefault().post(new RegistrationStepsEvent());
        dismiss();
    }

    //endregion

    //region **************  ValidationScreen.Listener **************

    @Override
    public void onVeryfiedPressed() {
        getPresenter().checkCode();
    }

    @Override
    public void onClosePressed() {
        dismiss();
    }
    //endregion

    //region **************  EventBus **************

    @Subscribe
    public void onEventMainThread(SmsEvent event) {
        validationDialogScreen.setCode(event.getCode());
        getPresenter().checkCode();
    }

    @Subscribe
    public void onEventMainThread(FormRegistrationEvent event) {
        if (event.getState() == FormState.VALIDATION) {
            getPresenter().checkCode();
        }
    }

    //endregion
}
