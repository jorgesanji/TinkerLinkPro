package com.cronosgroup.tinkerlink.presenter.dialog.occupation;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DialogOccupationPresenter extends TinkerLinkDialogPresenter<DialogOccupationPresenter.View> {

    private final Actions listener;

    /**
     * DialogOccupation View.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        void setOccupations(List<String> occupations);
    }

    /**
     * DialogOccupation actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public DialogOccupationPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void getOccupations() {
        getView().showLoading();
        AsyncLoader<List<String>> asyncLoader = new AsyncLoader<List<String>>() {
            @Override
            public List<String> doInBackground() {
                List<String> list = new ArrayList<>();

                for (int count = 0; count < 30; count++) {
                    list.add("Cocinero");
                }

                return list;
            }

            @Override
            public void postProcess(List<String> result) {
                getView().setOccupations(result);
                getView().hideLoading();

            }
        };
        asyncLoader.start();
    }


}

