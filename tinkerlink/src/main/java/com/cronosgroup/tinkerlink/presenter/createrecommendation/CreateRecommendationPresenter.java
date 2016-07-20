package com.cronosgroup.tinkerlink.presenter.createrecommendation;

import android.os.Handler;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class CreateRecommendationPresenter extends TinkerLinkPresenter<CreateRecommendationPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {

    }

    /**
     * Contacts actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public CreateRecommendationPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void sendRecommendation() {
        getView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView() != null && getView().getActivity() != null) {
                    getView().hideLoading();
                    getView().getActivity().finish();
                }
            }
        }, 5000);

    }

}
