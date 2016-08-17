package com.cronosgroup.tinkerlink.view.giverecommendation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.giverecommendation.GiveRecommendationPresenter;
import com.cronosgroup.tinkerlink.utils.TLMMenuBuilder;
import com.cronosgroup.tinkerlink.utils.TLMMenuItem;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import java.util.ArrayList;
import java.util.List;


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
    protected List<TLMMenuBuilder> getMenuItems() {
        List<TLMMenuBuilder> menuItems = new ArrayList<>();
        menuItems.add(new TLMMenuItem().
                setId(R.id.action_send_recommendation).
                setTitle(R.string.profile_recommendations_publish_recommendations).
                setTitleColor(R.color.text_black_totally).
                setAction(TLMMenuItem.SHOW_ACTION));
        return menuItems;
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
        return new GiveRecommendationPresenter();
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
