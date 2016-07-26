package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.validation;

import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.FormRegistrationEvent;
import com.cronosgroup.tinkerlink.event.NextPageEvent;
import com.cronosgroup.tinkerlink.event.SmsEvent;
import com.cronosgroup.tinkerlink.event.enums.FormState;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.sign.ValidationPresenter;
import com.cronosgroup.tinkerlink.utils.AppAlertBuilder;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.view.interfaces.IOValidationForm;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class ValidationFragment extends MVPTinkerLinkFragment<ValidationPresenter, ValidationPresenter.View>
        implements ValidationPresenter.View, ValidationScreen.Listener, IOValidationForm {

    //Vars
    private IOFormListener mCallback;
    private AppUser appUser;

    //Views
    private ValidationScreen validationPage;

    //region **************  Fragment **************

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if (activity instanceof IOFormListener) {
                mCallback = (IOFormListener) activity;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement IOFormListener");
        }
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
        validationPage = new ValidationScreen(getActivity());
        validationPage.setListener(this);
        return validationPage;
    }

    @Override
    protected ValidationPresenter createPresenter() {
        return new ValidationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ValidationPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getPermissionManager().requestSmsPermission();
    }

    //endregion

    //region **************  ValidationPresenter.View **************

    @Override
    public AppUser getFormUser() {
        return appUser;
    }

    @Override
    public String getValidationCode() {
        return validationPage.getValidationCode();
    }

    @Override
    public void validateUser(RestUser restUser) {
        if (restUser == null) {
            AppAlertBuilder.showAlertWithTitleAndMessage(getActivity(), R.string.sign_code_validation_title_error, R.string.sign_code_validation_message_error, R.string.ok_button_title, null);
        } else if (!restUser.isActive()) {
            AppAlertBuilder.showAlertWithMessage(getActivity(), R.string.login_enter_email_pasword_error, R.string.cancel_button_title, null);
        } else if (restUser.getDuplicate()) {
            AppAlertBuilder.showAlertWithMessage(getActivity(), R.string.login_user_duplicate_error, R.string.cancel_button_title, null);
        } else {
            if (restUser.isActive()) {
                // Save User and load data config and user data
                getPresenter().getAppUserSessionManager().login(restUser);

                getPresenter().onSuccessValidation();
            } else {
                AppAlertBuilder.showAlertWithMessage(getActivity(), R.string.login_code_error, R.string.cancel_button_title, null);
            }
        }
    }

    //endregion

    //region **************  ValidationPage.Listener **************

    @Override
    public void getCode() {
        getPresenter().getCode();
    }

    @Override
    public void onVeryfiedPressed() {
        EventBus.getDefault().post(new NextPageEvent());
    }

    //endregion

    @Override
    public boolean validationForm() {
        return false;
    }


    //region **************  EventBus **************
    @Subscribe
    public void onEventMainThread(SmsEvent event) {
        validationPage.setCode(event.getCode());
        getPresenter().checkCode(event.getCode());
    }

    @Subscribe
    public void onEventMainThread(NextPageEvent event) {
        if (event.getState() == FormState.VALIDATION) {
            appUser = mCallback.getFormUser();
            validationPage.setTitle(appUser.getPhone());
        }
    }

    @Subscribe
    public void onEventMainThread(FormRegistrationEvent event) {
        if (event.getState() == FormState.VALIDATION) {
            getPresenter().checkCode(validationPage.getValidationCode());
        }
    }

    //endregion
}
