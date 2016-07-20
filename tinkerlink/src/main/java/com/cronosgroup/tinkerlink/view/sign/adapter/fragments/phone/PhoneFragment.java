package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.phone;

import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.event.FormRegistrationEvent;
import com.cronosgroup.tinkerlink.event.FormValidationEvent;
import com.cronosgroup.tinkerlink.event.NextPageEvent;
import com.cronosgroup.tinkerlink.event.enums.FormState;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.presenter.sign.PhonePresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.view.interfaces.IOValidationForm;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class PhoneFragment extends MVPTinkerLinkFragment<PhonePresenter, PhonePresenter.View>
        implements PhonePresenter.View, PhoneScreen.Listener, IOValidationForm {

    //Vars
    private IOFormListener mCallback;
    private AppUser appUser;

    //Views
    private PhoneScreen phonePage;

    //region **************  Fragment **************

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (IOFormListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
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
        phonePage = new PhoneScreen(getActivity());
        phonePage.setListener(this);
        return phonePage;
    }

    @Override
    protected PhonePresenter createPresenter() {
        return new PhonePresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected PhonePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        RestCountry restCountry = getPresenter().getAppCountryManager().getCurrentCountry();
        setCountry(restCountry);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }

    private void setCountry(RestCountry restCountry) {
        String countryName = getPresenter().getAppCountryManager().getCurrentNameFromLocale(getPresenter().getAppCountryManager().getCurrentCountry());
        phonePage.currentCountry(countryName, restCountry.getCode());
    }

    //endregion

    //region **************  PhonePresenter.View **************

    @Override
    public void setCountrySelected(RestCountry restCountry) {
        setCountry(restCountry);
        getFormUser().setCode(restCountry.getCode());
    }

    @Override
    public AppUser getFormUser() {
        return appUser;
    }

    @Override
    public String getPhone() {
        return phonePage.getPhone();
    }

    @Override
    public String getCodePhone() {
        return phonePage.getCountryCode();
    }

    @Override
    public void noGoToNextPage() {
        EventBus.getDefault().post(new FormValidationEvent(FormState.PHONE, true));
    }

    //endregion

    //region **************  PhonePage.Listener **************

    @Override
    public void showCountrySelector() {
        getPresenter().showCountrySelector();
    }

    @Override
    public void onSetUser() {
        getPresenter().setUser();
    }

    //endregion

    @Override
    public boolean validationForm() {
        return getPresenter().validateForm();
    }

    //region **************  EventBus **************
    @Subscribe
    public void onEventMainThread(FormRegistrationEvent event) {
        if (event.getState() == FormState.PHONE) {
            if (validationForm()) {
                getPresenter().setUser();
            }
        }
    }

    @Subscribe
    public void onEventMainThread(NextPageEvent event) {
        if (event.getState() == FormState.PHONE) {
            appUser = mCallback.getFormUser();
        }
    }

    //endregion
}
