package com.cronosgroup.tinkerlink.presenter.account;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class AccountPresenter extends TinkerLinkPresenter<AccountPresenter.View> {

    private final Actions listener;

    /**
     * Message listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Mesage actions.
     */
    public interface Actions {
        void onLaunchEditUserProfile(Activity activity, Bundle bundle);

        void onLaunchProfile(Activity activity, Bundle bundle);

        void onLaunchConfigProfile(Activity activity, Bundle bundle);

        void onLaunchStack(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public AccountPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    // Actions

    public void onLaunchEditProfile() {
        listener.onLaunchEditUserProfile(getView().getActivity(), null);
    }

    public void onLaunchProfile() {
        listener.onLaunchProfile(getView().getActivity(), null);
    }

    public void onLaunchConfigProfile() {
        listener.onLaunchConfigProfile(getView().getActivity(), null);
    }

    public void onLaunchTinkerCards() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        listener.onLaunchStack(getView().getActivity(), bundle);
    }

    public void onLaunchLinkerCards() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        listener.onLaunchStack(getView().getActivity(), bundle);
    }

}
