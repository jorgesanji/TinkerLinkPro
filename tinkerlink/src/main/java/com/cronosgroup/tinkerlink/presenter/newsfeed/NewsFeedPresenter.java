package com.cronosgroup.tinkerlink.presenter.newsfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.rest.RestError;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.manager.socialnetworks.AppFacebookShareManager;
import com.cronosgroup.tinkerlink.model.business.logic.NewsFeedUseCases;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import java.util.List;


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
    public interface View extends TinkerLinkPresenterView {
        void addPosts(List<RestPost> list);
    }

    /**
     * NewsFeed actions.
     */
    public interface Actions {
        void onLaunchStack(Activity activity, Bundle bundle);
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
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCard.TINKER);
        listener.onLaunchStack(getView().getActivity(), bundle);
    }

    public void onLaunchSearchTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCard.LINKER);
        listener.onLaunchStack(getView().getActivity(), bundle);
    }

    public void getPosts(String idLastPost) {

        if (idLastPost.equalsIgnoreCase("0")) {
            getView().showLoading();
        }

        NewsFeedUseCases.getPosts(idLastPost, new Callback<List<RestPost>, RestError>() {
            @Override
            public void onResponse(List<RestPost> list) {
                getView().hideLoading();
                getView().addPosts(list);
            }

            @Override
            public void onErrorResponse(RestError error) {
                getView().hideLoading();
                getView().getMessagesHandler().showNetworkError();
            }

        }, getView().getActivity());
    }

}
