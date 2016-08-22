package com.cronosgroup.tinkerlink.view.detailcard;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.detailcard.DetailStackPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Detail screen stack fragment
 */
public class DetailStackFragment extends MVPTinkerLinkFragment<DetailStackPresenter, DetailStackPresenter.View>
        implements DetailStackPresenter.View, DetailStackScreen.Listener {

    // Views
    private DetailStackScreen detailCardScreen;

    @Override
    protected View getRootView() {
        detailCardScreen = new DetailStackScreen(getActivity());
        detailCardScreen.setListener(this);
        return detailCardScreen;
    }

    @Override
    protected void onDidAppear() {
        int position = getArguments().getInt(DetailStackActivity.KEY_POSITION);
        detailCardScreen.initPager(getActivity().getSupportFragmentManager(), position);
    }

    //region **************  MVPFragment **************

    @Override
    protected DetailStackPresenter createPresenter() {
        return new DetailStackPresenter();
    }

    @Override
    protected DetailStackPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region ************** DetailStackPresenter.View **************
    //endregion

    //region ************** DetailStackScreen.Listener **************
    //endregion

    //region **************  EventBus **************
    //endregion
}
