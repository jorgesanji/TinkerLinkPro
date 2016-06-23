package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed;

import android.view.View;

import com.cronosgroup.core.view.MVPFragment;
import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;


/**
 * NewsFeed Fragment
 */
public class NewsFeedFragment extends MVPFragment<NewsFeedPresenter, NewsFeedPresenter.View>
        implements NewsFeedPresenter.View, NewsFeedScreen.Listener {

    private NewsFeedScreen newsFeedScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        newsFeedScreen = new NewsFeedScreen(getActivity());
        newsFeedScreen.setListener(this);
        return newsFeedScreen;
    }
    //endregion

    //region **************  MVPFragment **************

    @Override
    protected NewsFeedPresenter createPresenter() {
        return new NewsFeedPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected NewsFeedPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //region **************  NewsFeedScreen.Listener **************

    @Override
    public void onImTinkerStackPressed() {
        getPresenter().onLaunchImTinker();
    }

    @Override
    public void onSearchTinkerStackPressed() {
        getPresenter().onLaunchSearchTinker();
    }

    @Override
    public void onLoadPost(String idLastPost, String... params) {

    }

    @Override
    public void onLikePressed(RestPost restPost) {

    }

    @Override
    public void onChatPressed(RestContacto restContacto) {

    }

    @Override
    public void onShareFacebookPressed(RestPost post) {

    }

    @Override
    public void onShareNewsFeedPressed(RestPost post) {

    }

    @Override
    public void onShowUserRecommendationPressed(RestPost restPost) {

    }

    @Override
    public void onAddContactPressed(RestPost restPost) {

    }

    @Override
    public void onUserIconPressed(RestContacto userContact) {

    }

    @Override
    public void onShowDetailCard(RestPost restPost) {

    }

    @Override
    public void onUserImagePressed(RestPost restPost) {

    }

    @Override
    public void onUserActivityPressed() {

    }

    //endregion

    //region **************  HomePresenter.View **************

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).hideLoading();
        }
    }


    //endregion
}
