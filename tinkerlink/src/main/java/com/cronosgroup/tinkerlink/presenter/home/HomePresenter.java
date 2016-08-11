package com.cronosgroup.tinkerlink.presenter.home;

/**
 * Created by jorgesanmartin on 16/10/15.
 */

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Home presenter.
 */
public class HomePresenter extends TinkerLinkPresenter<HomePresenter.View> {

    /**
     * Home listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    //region **************  View Actions **************

    public void onLaunchCreateRecommendation() {
        navigation.onLaunchCreateUserRecommendation(getView().getActivity(), null);
    }

    public void onLaunchCreateTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        navigation.onLaunchCreateCard(getView().getActivity(), bundle);
    }

    public void onLaunchCreateLinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        navigation.onLaunchCreateCard(getView().getActivity(), bundle);
    }
    //endregion


}