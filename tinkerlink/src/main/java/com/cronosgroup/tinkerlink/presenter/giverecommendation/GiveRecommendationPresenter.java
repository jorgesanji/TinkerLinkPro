package com.cronosgroup.tinkerlink.presenter.giverecommendation;

import android.os.Handler;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class GiveRecommendationPresenter extends TinkerLinkPresenter<GiveRecommendationPresenter.View> {

    // Vars
    private final Actions listener;

    /**
     * GiveRecommendation listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * GiveRecommendation actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public GiveRecommendationPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //Actions

    public void onSendRecommendation() {
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
}


