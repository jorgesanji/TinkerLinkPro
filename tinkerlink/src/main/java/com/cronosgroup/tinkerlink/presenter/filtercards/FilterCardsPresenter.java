package com.cronosgroup.tinkerlink.presenter.filtercards;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class FilterCardsPresenter extends TinkerLinkPresenter<FilterCardsPresenter.View> {

    /**
     * FilterCards listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setCategories(List<RestCategory> cards);
    }

    //Actions

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
}


