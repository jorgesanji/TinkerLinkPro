package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.view.View;

import com.cronosgroup.tinkerlink.enums.SourceImageType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.createcard.CategorySelectionPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.category.CategoryDialogFragment;
import com.cronosgroup.tinkerlink.view.dialog.places.PlacesDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionFragment extends MVPTinkerLinkFragment<CategorySelectionPresenter, CategorySelectionPresenter.View>
        implements CategorySelectionPresenter.View, CategorySelectionScreen.Listener {

    // Vars
    private SourceImageType type;

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
        return new CategorySelectionPresenter();
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

    @Override
    public void onSelectGeoPositionPressed() {
        addDialogFragment(PlacesDialogFragment.class, PlacesDialogFragment.CODE);
    }

    @Override
    public void onSelectCategoryPressed() {
        addDialogFragment(CategoryDialogFragment.class, CategoryDialogFragment.CODE);
    }

    @Override
    public void onImageSourceSelected(SourceImageType type) {
        this.type = type;
        if (type == SourceImageType.GALLERY) {
            getPresenter().launchGallery();
        } else {
            getPresenter().launchCamera();
        }
    }

    //endregion

}
