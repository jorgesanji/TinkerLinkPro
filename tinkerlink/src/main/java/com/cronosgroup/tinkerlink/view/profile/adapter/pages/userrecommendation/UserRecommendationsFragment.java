package com.cronosgroup.tinkerlink.view.profile.adapter.pages.userrecommendation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.presenter.profile.UserRecommendationsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.customviews.TLRecommendationView;

import java.util.List;


/**
 * UserRecommendations Fragment
 */
public class UserRecommendationsFragment extends MVPTinkerLinkFragment<UserRecommendationsPresenter, UserRecommendationsPresenter.View>
        implements UserRecommendationsPresenter.View, UserRecommendationsScreen.Listener {

    // Vars

    // Views
    private UserRecommendationsScreen userRecommendationsScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        userRecommendationsScreen = new UserRecommendationsScreen(getActivity());
        userRecommendationsScreen.setListener(this);
        return userRecommendationsScreen;
    }

    @Override
    protected UserRecommendationsPresenter createPresenter() {
        return new UserRecommendationsPresenter();
    }

    @Override
    protected UserRecommendationsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getRecommendations();
    }

    //endregion

    //region ************** CardRecommendationsPresenter.View **************

    @Override
    public void setRecommendationsList(List<RestRecommendation> list) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (RestRecommendation restRecommendation : list) {

            TLRecommendationView recommendationView = new TLRecommendationView(getContext());
            recommendationView.setUserName(restRecommendation.getUser().getUser().getName());
            recommendationView.setJob(restRecommendation.getUser().getUser().getProfile().getProfession());
            recommendationView.setTime(restRecommendation.getCreateDate());
            recommendationView.setRecommendation(restRecommendation.getRecomendacion());
            recommendationView.setLayoutParams(params);

            userRecommendationsScreen.addRecommendation(recommendationView);
        }
    }

    //endregion

    //region ************** UserRecommendationsScreen.Listener **************

    @Override
    public void onItemPressed(int position) {

    }

    @Override
    public void onShowAllRecommendationsPressed() {
        getPresenter().onShowAllRecommendationsPressed();
    }

    @Override
    public void onGiveRecommendationPressed() {
        getPresenter().onGiveRecommendationPressed();
    }

    //endregion

    //endregion

}
