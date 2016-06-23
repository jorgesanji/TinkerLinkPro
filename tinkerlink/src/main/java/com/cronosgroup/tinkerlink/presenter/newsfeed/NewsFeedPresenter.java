package com.cronosgroup.tinkerlink.presenter.newsfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.manager.AppFacebookShareManager;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;


/**
 * NewsFeed presenter.
 */
public class NewsFeedPresenter extends TinkerLinkPresenter<NewsFeedPresenter.View> {

    public static final int CHAT_CODE = 7000;
    public static final int RECOMENDATIONS_CODE = 8000;
    public static final int TIME_TO_OBSERVER = 3000;

    private final Actions listener;
    private AppFacebookShareManager mFacebookManager;

    /**
     * NewsFeed listeners.
     */
    public interface View extends Presenter.View {

    }

    /**
     * NewsFeed actions.
     */
    public interface Actions {
        void onLaunchImTinkerStack(Activity activity, Bundle bundle);

        void onLaunchSearchTinkerStack(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public NewsFeedPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region

    // **************  BasePresenter **************

    @Override
    public void attachView(View view) {
        super.attachView(view);
        mFacebookManager = new AppFacebookShareManager(getView().getActivity());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CHAT_CODE) {
//            Bundle extras = data.getExtras();
//            String texto = extras.getString(ChatDialogFragment.TEXT_TO_SEND);
//            String idUser = extras.getString(ChatDialogFragment.ID_USER);
//            sendChat(texto, idUser);
//        } else {
        mFacebookManager.onActivityResult(requestCode, resultCode, data);
//        }
    }


    //endregion

    //region **************  View Actions **************

    //endregion


    public void onLaunchImTinker() {
        listener.onLaunchImTinkerStack(getView().getActivity(), null);
    }

    public void onLaunchSearchTinker() {
        listener.onLaunchSearchTinkerStack(getView().getActivity(), null);
    }

}
