package com.cronosgroup.tinkerlink.presenter.createrecommendation;

import android.os.Handler;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class CreateRecommendationPresenter extends TinkerLinkPresenter<CreateRecommendationPresenter.View> {

    private final Actions listener;

    /**
     * Contacts listeners.
     */
    public interface View extends Presenter.View {

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
                getView().hideLoading();
                getView().getActivity().finish();
            }
        }, 5000);

    }

}
