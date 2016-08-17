package com.cronosgroup.tinkerlink.view.recommendations;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.presenter.recommendations.RecommendationsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import java.util.List;


/**
 * UserRecommendations Fragment
 */
public class RecommendationsFragment extends MVPTinkerLinkFragment<RecommendationsPresenter, RecommendationsPresenter.View>
        implements RecommendationsPresenter.View, RecommendationsScreen.Listener {

    // Vars

    // Views
    private RecommendationsScreen recommendationsScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        recommendationsScreen = new RecommendationsScreen(getActivity());
        recommendationsScreen.setListener(this);
        return recommendationsScreen;
    }

    @Override
    protected RecommendationsPresenter createPresenter() {
        return new RecommendationsPresenter();
    }

    @Override
    protected RecommendationsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getRecommendations();
    }

    //endregion

    //region ************** RecommendationsPresenter.View **************

    @Override
    public void setRecommendationsList(List<RestRecommendation> list) {
        recommendationsScreen.setItems(list);
    }

    //endregion

    //region ************** RecommendationsScreen.Listener **************

    @Override
    public void onItemPressed(int position) {

    }

    @Override
    public void onGiveRecommendationPressed() {
        getPresenter().onGiveRecommendationPressed();
    }

    //endregion

}
