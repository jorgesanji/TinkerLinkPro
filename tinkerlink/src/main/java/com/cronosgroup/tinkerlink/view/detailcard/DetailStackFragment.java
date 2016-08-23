package com.cronosgroup.tinkerlink.view.detailcard;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.presenter.detailcard.DetailStackPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import java.util.List;


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
        detailCardScreen.initPager(getActivity().getSupportFragmentManager());
        getPresenter().getCards();
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

    @Override
    public String getIdCard() {
        return getArguments().getString(DetailStackActivity.KEY_ITEM);
    }

    @Override
    public void setCards(List<TLCard> list) {
        detailCardScreen.setItems(list);
    }

    @Override
    public void setCurrentCardVisible(int index) {
        detailCardScreen.setCurrentCardVisible(index);
    }

    //endregion

    //region ************** DetailStackScreen.Listener **************
    //endregion

    //region **************  EventBus **************
    //endregion
}
