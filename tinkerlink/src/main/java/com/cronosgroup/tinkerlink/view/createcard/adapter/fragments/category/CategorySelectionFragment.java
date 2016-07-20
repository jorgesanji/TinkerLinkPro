package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.createcard.CategorySelectionPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionFragment extends MVPTinkerLinkFragment<CategorySelectionPresenter, CategorySelectionPresenter.View>
        implements CategorySelectionPresenter.View, CategorySelectionScreen.Listener {

    // Vars

    private RestCategoria categoria;
    private List<String> skillList = new ArrayList<>();

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
        categorySelectionScreen.setItems(categories);
    }

    //endregion

    //region ************** CategoryScreen.Listener **************

    @Override
    public void setCurrentCategorySelected(RestCategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void skillSelectAtPosition(int position) {
        int positionOffset = (position - categorySelectionScreen.getItems().indexOf(categoria)) - 1;
        String skill = categoria.getChildItemList().get(positionOffset);
        if (!skill.contains(skill)) {
            skillList.add(skill);
        }
    }

    //endregion

}
