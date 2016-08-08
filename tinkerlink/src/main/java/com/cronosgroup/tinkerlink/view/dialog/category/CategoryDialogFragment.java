package com.cronosgroup.tinkerlink.view.dialog.category;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.category.CategoryPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;

import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CategoryDialogFragment extends MVPTinkerLinkDialogFragment<CategoryPresenter, CategoryPresenter.View> implements CategoryPresenter.View, CategoryDialogScreen.Listener {

    // Vars
    public static final int CODE = 890;
    public static final String CATEGORY_SELECTED = "CATEGORY_SELECTED";
    private RestCategoria categoria;

    // Views
    private CategoryDialogScreen categoryDialogScreen;

    @Override
    protected View getRootView() {
        categoryDialogScreen = new CategoryDialogScreen(getActivity(), StackCardType.TINKER, this);
        return categoryDialogScreen;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getCategories();
        categoryDialogScreen.show();
    }

    //region **************  MVPFragment **************

    @Override
    protected CategoryPresenter createPresenter() {
        return new CategoryPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CategoryPresenter.View getPresenterView() {
        return this;
    }

    //endregion

    //region **************  CategoryPresenter.View **************

    @Override
    public void setCategories(List<RestCategoria> list) {
        categoryDialogScreen.setItems(list);
    }

    //endregion

    //region **************  CategoryScreen.Listener **************

    @Override
    public void setCurrentCategorySelected(RestCategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void skillSelectAtPosition(int position) {
        String name = categoria.getHabilidades().get(position);
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_SELECTED, name);
        sendResult(bundle, CODE);
    }

    @Override
    public void onClosePressed() {
        dismiss();
    }

    //endregion

}
