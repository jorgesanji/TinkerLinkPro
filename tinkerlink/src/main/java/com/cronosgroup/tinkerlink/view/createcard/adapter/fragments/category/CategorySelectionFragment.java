package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.createcard.CategorySelectionPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionFragment extends MVPTinkerLinkFragment<CategorySelectionPresenter, CategorySelectionPresenter.View>
        implements CategorySelectionPresenter.View, CategorySelectionScreen.Listener {

    // Vars

    // Views
    private CategorySelectionScreen categorySelectionScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        categorySelectionScreen = new CategorySelectionScreen(getActivity());
        categorySelectionScreen.setListener(this);
        return categorySelectionScreen;
    }

    @Override
    protected CategorySelectionPresenter createPresenter() {
        return new CategorySelectionPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CategorySelectionPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getCategories();
    }

    //endregion

    //region ************** CategorySelectionPresenter.View **************

    @Override
    public void setCategories(List<RestCategoria> categories) {
    }

    //endregion

    //region ************** CategoryScreen.Listener **************


    //endregion

}
