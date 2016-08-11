package com.cronosgroup.tinkerlink.presenter.category;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class CategoryPresenter extends TinkerLinkDialogPresenter<CategoryPresenter.View> {

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        void setCategories(List<RestCategoria> list);
    }

    // public methods

    public void getCategories() {

        getView().showLoading();

        AsyncLoader<List<RestCategoria>> asyncLoader = new AsyncLoader<List<RestCategoria>>() {
            @Override
            public List<RestCategoria> doInBackground() {
                final List<RestCategoria> list = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    final RestCategoria categoria = new RestCategoria();
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
            public void postProcess(List<RestCategoria> result) {
                getView().setCategories(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();

    }


}
