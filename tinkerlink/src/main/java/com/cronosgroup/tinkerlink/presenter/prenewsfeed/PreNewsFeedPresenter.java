package com.cronosgroup.tinkerlink.presenter.prenewsfeed;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class PreNewsFeedPresenter extends TinkerLinkPresenter<PreNewsFeedPresenter.View> {

    // Vars

    /**
     * Config user account listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //Actions

    public void onCompleteProfilePressed() {
        navigation.onLaunchEditUserProfile(getView().getActivity(), null);
    }

    public void onLaunchVerifyEmail() {
        navigation.onLaunchVerifyEmail(getView().getActivity(), null);
    }

    public void onLaunchImTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

    public void onLaunchSearchTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

}


