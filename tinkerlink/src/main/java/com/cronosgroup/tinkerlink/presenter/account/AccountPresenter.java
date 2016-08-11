package com.cronosgroup.tinkerlink.presenter.account;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class AccountPresenter extends TinkerLinkPresenter<AccountPresenter.View> {

    /**
     * Message listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    // Actions

    public void onLaunchEditProfile() {
        navigation.onLaunchEditUserProfile(getView().getActivity(), null);
    }

    public void onLaunchProfile() {
        navigation.onLaunchProfile(getView().getActivity(), null);
    }

    public void onLaunchConfigProfile() {
        navigation.onLaunchConfigProfile(getView().getActivity(), null);
    }

    public void onLaunchTinkerCards() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

    public void onLaunchLinkerCards() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

}
