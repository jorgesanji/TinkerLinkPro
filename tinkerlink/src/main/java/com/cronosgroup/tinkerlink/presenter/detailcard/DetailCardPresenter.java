package com.cronosgroup.tinkerlink.presenter.detailcard;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DetailCardPresenter extends TinkerLinkPresenter<DetailCardPresenter.View> {

    private final Actions listener;

    /**
     * Detailcard View.
     */
    public interface View extends TinkerLinkPresenterView {
        RestPost getCardData();
    }

    /**
     * DetailCard actions.
     */
    public interface Actions {
        void onLaunchNetWork(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public DetailCardPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void createCard() {
        getView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().hideLoading();
                    getView().getActivity().finish();
                }
            }
        }, 1000);
    }

    public void showNetwork() {
        listener.onLaunchNetWork(getView().getActivity(), null);
    }

}

