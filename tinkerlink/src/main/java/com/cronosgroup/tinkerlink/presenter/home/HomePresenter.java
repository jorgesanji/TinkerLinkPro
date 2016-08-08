package com.cronosgroup.tinkerlink.presenter.home;

/**
 * Created by jorgesanmartin on 16/10/15.
 */

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Home presenter.
 */
public class HomePresenter extends TinkerLinkPresenter<HomePresenter.View> {
    private final Actions listener;

    /**
     * Home listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Home actions.
     */
    public interface Actions {
        void onLaunchCreateUserRecommendation(Activity activity, Bundle bundle);

        void onLaunchCreateCard(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public HomePresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //region **************  BasePresenter **************


    //endregion

    //region **************  View Actions **************

    public void onLaunchCreateRecommendation() {
        listener.onLaunchCreateUserRecommendation(getView().getActivity(), null);
    }

    public void onLaunchCreateTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        listener.onLaunchCreateCard(getView().getActivity(), bundle);
    }

    public void onLaunchCreateLinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        listener.onLaunchCreateCard(getView().getActivity(), bundle);
    }
    //endregion


}