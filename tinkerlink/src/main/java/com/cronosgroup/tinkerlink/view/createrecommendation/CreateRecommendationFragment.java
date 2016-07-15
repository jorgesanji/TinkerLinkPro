package com.cronosgroup.tinkerlink.view.createrecommendation;

import android.view.View;

import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.createcard.CreateCardPresenter;
import com.cronosgroup.tinkerlink.presenter.createrecommendation.CreateRecommendationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Create card Fragment
 */
public class CreateRecommendationFragment extends MVPTinkerLinkFragment<CreateRecommendationPresenter, CreateRecommendationPresenter.View>
        implements CreateRecommendationPresenter.View, CreateRecommendationScreen.Listener {

    // Vars

    // Views
    private CreateRecommendationScreen createRecommendationScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        createRecommendationScreen = new CreateRecommendationScreen(getActivity());
        createRecommendationScreen.setListener(this);
        return createRecommendationScreen;
    }

    @Override
    protected CreateRecommendationPresenter createPresenter() {
        return new CreateRecommendationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CreateRecommendationPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** CreateCardPresenter.View **************
    //endregion

    //region ************** CreateCardScreen.Listener **************
    //endregion

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
