package com.cronosgroup.tinkerlink.presenter.stack;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jorgesanmartin on 2/8/16.
 */
public class CardRecommendationsPresenter extends TinkerLinkPresenter<CardRecommendationsPresenter.View> {

    /**
     * UserRecommendations listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setRecommendationsList(List<RestRecommendation> list);
    }

    //Actions

    public void getRecommendations() {

        AsyncLoader<List<RestRecommendation>> asyncLoader = new AsyncLoader<List<RestRecommendation>>() {
            @Override
            public List<RestRecommendation> doInBackground() {
                List<RestRecommendation> list = new ArrayList<>();

                RestUser restUser = new RestUser();
                restUser.setName("Luisito");
                restUser.setProfession("Fontanero");
                restUser.setPhoto("http://api.ning.com/files/3G-NNOsexAFFbCt-XN5LbraHbYlrzivPtxx39pnQ8w48JITkdWKLhPCFGwt4p7794nvVE97YYfqtSwVmiSLhl1jXxV4IfejV/Staindwallcopy.jpg");


                for (int init = 0; init < 10; init++) {
                    RestRecommendation restRecomendacion = new RestRecommendation();
                    restRecomendacion.setUser(restUser);
                    restRecomendacion.setText("Es un crack de craks es el padre de la informatica si si siiiiiiii");
//                    restRecomendacion.setCreateDate(DateUtils.getDateIntervalFromTimeStamp(1350574775, getView().getContext()));
                    restRecomendacion.setCreateDate(new Date());
                    list.add(restRecomendacion);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestRecommendation> result) {
                getView().setRecommendationsList(result);
            }
        };

        asyncLoader.start();
    }

}
