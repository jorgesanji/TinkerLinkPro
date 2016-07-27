package com.cronosgroup.tinkerlink.view.giverecommendation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.giverecommendation.GiveRecommendationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * UserRecommendations Fragment
 */
public class GiveRecommendationsFragment extends MVPTinkerLinkFragment<GiveRecommendationPresenter, GiveRecommendationPresenter.View>
        implements GiveRecommendationPresenter.View, GiveRecommendationsScreen.Listener {

    // Vars

    // Views
    private GiveRecommendationsScreen recommendationsScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.giverecommendation_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_send_recommendation) {
            getPresenter().onSendRecommendation();
        }

        return super.onOptionsItemSelected(item);
    }

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        recommendationsScreen = new GiveRecommendationsScreen(getActivity());
        recommendationsScreen.setListener(this);
        return recommendationsScreen;
    }

    @Override
    protected GiveRecommendationPresenter createPresenter() {
        return new GiveRecommendationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected GiveRecommendationPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** GiveRecommendationsPresenter.View **************


    //endregion

    //region ************** GiveRecommendationsScreen.Listener *************

    //endregion

}
