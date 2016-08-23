package com.cronosgroup.tinkerlink.presenter.sign;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Linker presenter.
 */
public class TLinkerSelectorPresenter extends TinkerLinkPresenter<TLinkerSelectorPresenter.View> {

    /**
     * TLinkerSelectorPresenter view.
     */
    public interface View extends TinkerLinkPresenterView {
         void setCategories(List<RestCategory> categories);
    }

    //region **************  View Actions **************

    public void getCategories() {

        getView().showLoading();

        AsyncLoader<List<RestCategory>> asyncLoader = new AsyncLoader<List<RestCategory>>() {
            @Override
            public List<RestCategory> doInBackground() {
                final List<RestCategory> list = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    final RestCategory categoria = new RestCategory();
                    categoria.setCategoria("Reparación");
                    final List<String> stringList = new ArrayList<>();
                    for (int j = 0; j < 10; j++) {
                        stringList.add("carpintero");
                    }
                    categoria.setHabilidades(stringList);
                    list.add(categoria);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestCategory> result) {
                getView().setCategories(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();

    }

    //endregion

}
