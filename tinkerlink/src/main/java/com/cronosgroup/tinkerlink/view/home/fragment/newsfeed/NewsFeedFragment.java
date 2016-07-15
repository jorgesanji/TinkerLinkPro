package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

import java.util.List;


/**
 * NewsFeed Fragment
 */
public class NewsFeedFragment extends MVPTinkerLinkFragment<NewsFeedPresenter, NewsFeedPresenter.View>
        implements NewsFeedPresenter.View, NewsFeedScreen.Listener {

    private NewsFeedScreen newsFeedScreen;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    protected View getRootView() {
        newsFeedScreen = new NewsFeedScreen(getActivity());
        newsFeedScreen.setListener(this);
        newsFeedScreen.initAdapter(appConfigManager, appUserSessionManager);
        return newsFeedScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getPosts("0");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.newsfeed_search_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search_newsfeed) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public void addPosts(List<RestPost> list) {
        newsFeedScreen.addPosts(list);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }

    //endregion
}
