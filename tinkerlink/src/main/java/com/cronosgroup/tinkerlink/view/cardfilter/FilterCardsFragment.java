package com.cronosgroup.tinkerlink.view.cardfilter;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.filtercards.FilterCardsPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.List;

/**
 * FilterCards Fragment
 */
public class FilterCardsFragment extends MVPTinkerLinkFragment<FilterCardsPresenter, FilterCardsPresenter.View>
        implements FilterCardsPresenter.View, FilterCardsScreen.Listener {

    // Vars
    private StackCardType stackType;

    // Views
    private FilterCardsScreen filterCardsScreen;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stackType = (StackCardType) getArguments().getSerializable(StackActivity.STACK_TYPE);
    }

    @Override
    protected View getRootView() {
        filterCardsScreen = new FilterCardsScreen(getActivity(), this);
        return filterCardsScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getCategories();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected FilterCardsPresenter createPresenter() {
        return new FilterCardsPresenter();
    }

    @Override
    protected FilterCardsPresenter.View getPresenterView() {
        return this;
    }

    //region **************  FilterCardsScreen.Listener **************

    //endregion

    //region **************  FilterCardsPresenter.View **************

    @Override
    public void setCategories(List<RestCategoria> cards) {
        filterCardsScreen.setItems(cards, stackType);
        getSnackMessageManager().showCardsFilterWarning(628, 234);
    }
    //endregion
}
