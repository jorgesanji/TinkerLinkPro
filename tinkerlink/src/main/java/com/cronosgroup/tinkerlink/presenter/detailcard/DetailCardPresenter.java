package com.cronosgroup.tinkerlink.presenter.detailcard;

import android.os.Handler;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DetailCardPresenter extends TinkerLinkPresenter<DetailCardPresenter.View> {


    /**
     * Detailcard View.
     */
    public interface View extends TinkerLinkPresenterView {
        RestPost getCardData();
    }

    // public methods

    public void createCard() {
        getView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().showDialogMessage(R.string.message_create_card_title, R.string.message_create_card_message, R.mipmap.newsfeed_post_selected);
                    getView().hideLoading();
                    getView().removeActivityDelay();
                }
            }
        }, 1000);
    }

}

